package jam.google.deployment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public final class Runner
{
    private static final String FILE_ENCODING = "utf-8";
    
    public static <T extends TestCaseBase> void runSys(IProblemObjectFactory<T> factory)
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;
        run(in, out, factory);
    }
    
    public static <T extends TestCaseBase> void runIO(String fileIn, String fileOut, IProblemObjectFactory<T> factory)
    {
        BufferedReader in = null;
        PrintStream out = null;
        
        try
        {
            try
            {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn), FILE_ENCODING));
                
                try
                {
                    out = new PrintStream(fileOut, FILE_ENCODING);
                    run(in, out, factory);
                }
                finally
                {
                    if (out != null) out.close();
                }
            }
            finally
            {
                if (in != null) in.close();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    private static <T extends TestCaseBase> void run(BufferedReader in, PrintStream out, IProblemObjectFactory<T> factory)
    {
        TestCaseEnumerationBase<T> testCases = factory.getTestCaseEnumeration(in);
        
        while (testCases.hasMoreElements())
        {
            IProblemSolver<T> solver = factory.createSolver();
            T instance = testCases.nextElement();
            String solution = solver.solve(instance);
            out.format("Case #%d: %s%n", instance.getSeqNum(), solution);
        }
    }
}
