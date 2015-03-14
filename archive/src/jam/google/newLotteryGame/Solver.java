package jam.google.newLotteryGame;

import java.math.BigInteger;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
        BigInteger max;
        BigInteger min;
        int cmp = instance.a.compareTo(instance.b); 
        
        if (cmp > 0) {
            max = instance.a;
            min = instance.b;
        }
        else {
            max = instance.b;
            min = instance.a;
        }
        
        if (instance.k.compareTo(min) >= 0) {
            return max.multiply(min).toString();
        }
        
        BigInteger result = instance.k.multiply(max);
        BigInteger index = instance.k;
        
        while (index.compareTo(min) < 0) {
            BigInteger innerIndex = BigInteger.ZERO;
            
            while (innerIndex.compareTo(max) < 0) {
                if (index.and(innerIndex).compareTo(instance.k) < 0) {
                    result = result.add(BigInteger.ONE);
                }
                
                innerIndex = innerIndex.add(BigInteger.ONE);
            }
            
            index = index.add(BigInteger.ONE);
        }
        
        return result.toString();
    }

}
