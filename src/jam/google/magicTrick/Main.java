package jam.google.magicTrick;

import jam.google.deployment.Runner;

public final class Main {
    
    public static void main(String[] args) {
        ProblemObjectFactory f = new ProblemObjectFactory();
        // Runner.runSys(f);
        Runner.runIO("/home/nachos/Downloads/A-small-attempt0.in",
                "/home/nachos/Downloads/A-small-attempt0.out", f);
    }
}
