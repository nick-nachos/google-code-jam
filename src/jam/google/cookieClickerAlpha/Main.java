package jam.google.cookieClickerAlpha;

import jam.google.deployment.Runner;

public final class Main
{
    public static void main(String[] args)
    {
        ProblemObjectFactory f = new ProblemObjectFactory();
//        Runner.runSys(f);
        
//        Runner.runIO("/home/nachos/Downloads/B-small-attempt0.in", 
//                "/home/nachos/Downloads/B-small-attempt0.out", 
//                f);
        
        Runner.runIO("/home/nachos/Downloads/B-large.in", 
                "/home/nachos/Downloads/B-large.out", 
                f);
    }
}
