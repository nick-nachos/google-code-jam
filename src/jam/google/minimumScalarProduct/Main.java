package jam.google.minimumScalarProduct;

import jam.google.deployment.Runner;

public final class Main {

    public static void main(String[] args) {
        ProblemObjectFactory f = new ProblemObjectFactory();
        
//        Runner.runSys(f);
        
//        Runner.runIO("/home/nachos/Documents/google-jam/minimum-scalar-product/A-small-practice.in", 
//                "/home/nachos/Documents/google-jam/minimum-scalar-product/A-small-practice.out", f);
        
        Runner.runIO("/home/nachos/Documents/google-jam/minimum-scalar-product/A-large-practice.in", 
                "/home/nachos/Documents/google-jam/minimum-scalar-product/A-large-practice.out", f);
    }

}
