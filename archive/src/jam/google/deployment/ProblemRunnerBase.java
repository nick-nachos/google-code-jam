package jam.google.deployment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;
import java.util.Enumeration;

public abstract class ProblemRunnerBase<T extends TestCaseBase> {

    private static final String FILE_ENCODING;
    
    private static final String DIR_DOWNLOADS;
    private static final String DIR_NAMESPACE_ROOT;
    private static final String DIR_DESKTOP;
    
    private static final String EXT_IN;
    private static final String EXT_OUT;
    private static final String EXT_ZIP;
    
    static {
        FILE_ENCODING = "utf-8";
        DIR_DOWNLOADS = getUserHomeDir() + "/Downloads";
        DIR_DESKTOP = getUserHomeDir() + "/Desktop";
        DIR_NAMESPACE_ROOT = getUserHomeDir() + "/workspace/google-code-jam/archive/src/jam/google";
        EXT_IN = ".in";
        EXT_OUT = ".out";
        EXT_ZIP = ".zip";
    }
    
    private static String getUserHomeDir() {
        return System.getProperty("user.home");
    }
    
    private static String fixFileExtension(String extension) {
        if (extension.startsWith(".")) {
            return extension;
        }
        
        return "." + extension;
    }
    
    private static String makeTempDesktopDir() {
        Date d = new Date();
        String tempDirName = DIR_DESKTOP + "/" + d.toString().replace(" ", "-");
        new File(tempDirName).mkdir();
        
        return tempDirName;
    }
    
    private ProblemObjectFactory<T> objectFactory;
    private char problemLetterIndex;
    
    public ProblemRunnerBase(ProblemObjectFactory<T> objectFactory, char problemLetterIndex) {
        if (objectFactory == null) {
            throw new IllegalArgumentException();
        }
        
        if (!Character.isLetter(problemLetterIndex)) {
            throw new IllegalArgumentException();
        }
        
        this.objectFactory = objectFactory;
        this.problemLetterIndex = Character.toUpperCase(problemLetterIndex);
    }

    public void runSys() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;
        run(in, out);
    }

    public void runSmall(int attempt) {
        String inFile = this.getSmallFileName(attempt, EXT_IN);
        String outFile = this.getSmallFileName(attempt, EXT_OUT);
        String codeZipFile = this.getSmallFileName(attempt, EXT_ZIP);
        this.runIO(inFile, outFile, codeZipFile);
    }
    
    public void runSmallPractice() {
        String inFile = this.getSmallPracticeFileName(EXT_IN);
        String outFile = this.getSmallPracticeFileName(EXT_OUT);
        this.runIO(inFile, outFile, null);
    }
    
    public void runLarge() {
        String inFile = this.getLargeFileName(EXT_IN);
        String outFile = this.getLargeFileName(EXT_OUT);
        String codeZipFile = this.getLargeFileName(EXT_ZIP);
        this.runIO(inFile, outFile, codeZipFile);
    }
    
    public void runLargePractice() {
        String inFile = this.getLargePracticeFileName(EXT_IN);
        String outFile = this.getLargePracticeFileName(EXT_OUT);
        this.runIO(inFile, outFile, null);
    }
    
    private void runIO(String inFile, String outFile, String codeZipFile) {
        BufferedReader in = null;
        PrintStream out = null;

        try {
            try {
                in = new BufferedReader(new InputStreamReader(
                        new FileInputStream(inFile), FILE_ENCODING));

                try {
                    out = new PrintStream(outFile, FILE_ENCODING);
                    run(in, out);
                }
                finally {
                    if (out != null)
                        out.close();
                }
            }
            finally {
                if (in != null)
                    in.close();
            }
            
            if (codeZipFile != null) {
                this.copyAndCompresssCode(codeZipFile);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void run(BufferedReader in, PrintStream out) {
        Enumeration<T> testCases = this.objectFactory.getTestCaseEnumeration(in);

        while (testCases.hasMoreElements()) {
            ProblemSolver<T> solver = this.objectFactory.createSolver();
            T instance = testCases.nextElement();
            
            try {
                String solution = solver.solve(instance);
                out.format("Case #%d: %s%n", instance.getSeqNum(), solution);
            }
            catch(Exception ex) {
                System.err.format("Case #%d: %s%n", instance.getSeqNum(), ex.getMessage() == null ? "" : ex.getMessage());
                ex.printStackTrace();
                return;
            }
        }
    }
    
    private String getSmallFileName(int attempt, String extension) {
        extension = fixFileExtension(extension);
        
        return String.format("%s/%s-small-attempt%d%s", DIR_DOWNLOADS, this.problemLetterIndex, attempt, extension);
    }
    
    private String getSmallPracticeFileName(String extension) {
        extension = fixFileExtension(extension);
        
        return String.format("%s/%s-small-practice%s", DIR_DOWNLOADS, this.problemLetterIndex, extension);
    }
    
    private String getLargeFileName(String extension) {
        extension = fixFileExtension(extension);
        
        return String.format("%s/%s-large%s", DIR_DOWNLOADS, this.problemLetterIndex, extension);
    }
    
    private String getLargePracticeFileName(String extension) {
        extension = fixFileExtension(extension);
        
        return String.format("%s/%s-large-practice%s", DIR_DOWNLOADS, this.problemLetterIndex, extension);
    }
    
    private void copyAndCompresssCode(String codeZipFile) throws IOException, InterruptedException {
        String tempDirName = makeTempDesktopDir();
        String deploymentPckgDir = DIR_NAMESPACE_ROOT + "/" + "deployment";
        String problemPckgDir = DIR_NAMESPACE_ROOT + "/" + this.getProblemPackageName();
        File tempDestination = new File(tempDirName + "/jam/google");
        tempDestination.mkdirs();
        String[] commands = new String[] {
                String.format("cp -R %s %s", deploymentPckgDir, tempDestination.getAbsolutePath()),
                String.format("cp -R %s %s", problemPckgDir, tempDestination.getAbsolutePath()),
                String.format("zip -r %s jam", codeZipFile)
        };
        
        for (String command : commands) {
            Process p = Runtime.getRuntime().exec(command, null, new File(tempDirName));
            p.waitFor();
        }
        
        String cleanUpCommand = String.format("rm -r %s", tempDirName);
        Runtime.getRuntime().exec(cleanUpCommand).waitFor();
    }
    
    private String getProblemPackageName() {
        String[] tokens = this.getClass().getCanonicalName().split("\\.");
        
        return tokens[tokens.length - 2];
    }
}
