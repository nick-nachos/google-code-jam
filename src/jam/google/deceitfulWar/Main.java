package jam.google.deceitfulWar;

import jam.google.deployment.Runner;

public final class Main
{
    public static void main(String[] args)
    {
        ProblemObjectFactory f = new ProblemObjectFactory();
//        Runner.runSys(f);
      
//        Runner.runIO("/home/nachos/Downloads/D-small-attempt1.in", 
//                "/home/nachos/Downloads/D-small-attempt1.out", 
//                f);
      
        Runner.runIO("/home/nachos/Downloads/D-large.in", 
                "/home/nachos/Downloads/D-large.out", 
                f);
    }
}
