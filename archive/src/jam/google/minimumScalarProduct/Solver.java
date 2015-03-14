package jam.google.minimumScalarProduct;

import java.math.BigInteger;
import java.util.Arrays;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
        int[] vector1 = instance.getVector1();
        int[] vector2 = instance.getVector2();
        Arrays.sort(vector1);
        Arrays.sort(vector2);
        BigInteger product = BigInteger.ZERO;
        
        for (int i = 0; i < vector1.length; i++) {
            BigInteger v1 = BigInteger.valueOf(vector1[i]);
            BigInteger v2 = BigInteger.valueOf(vector2[vector2.length - 1 - i]);
            product = product.add(v1.multiply(v2));
        }
        
        return product.toString();
    }
}
