package jam.google.properShuffle;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
        long goodTotalDist = 0;
        long badTotalDist = 0;
        int[] permutation = instance.getPermutation();
        int[] original = this.getOriginal(permutation.length);
        int repetitions = permutation.length;
        
        for (int i = 0; i < repetitions; i++) {
            int[] init1 = this.getOriginal(permutation.length);
            int[] init2 = this.getOriginal(permutation.length);
            this.good(init1);
            this.bad(init2);
            goodTotalDist += this.dist(original, init1);
            badTotalDist += this.dist(original, init2);
        }
        
        double goodAvgDist = goodTotalDist / (double)repetitions;
        double badAvgDist = badTotalDist / (double)repetitions;
        int actualDist = this.dist(original, permutation);
        
        double goodScore = Math.abs(goodAvgDist - actualDist) / (goodAvgDist + 1); 
        double badScore = Math.abs(badAvgDist - actualDist) / (badAvgDist + 1);
        
        if (goodScore < badScore) {
            return "GOOD";
        }
        else {
            return "BAD";
        }
    }

    private int[] getOriginal(int length) {
        int[] items = new int[length];
        
        for (int i = 0; i < length; i++) {
            items[i] = i;
        }
        
        return items;
    }
    
    private int randInt(int a, int b) {
        return a + (int)(Math.random() * ((b - a) + 1));
    }
    
    private int dist(int[] original, int[] permutation) {
        int dist = 0;
        int limit = Math.max(original.length / 3, 1);
        
        for (int i = 0; i < limit; i++) {
            if (original[i] != permutation[i]) {
                dist++;
            }
        }
        
        return dist;
    }
    
    private void good(int[] items) {
        for (int k = 0; k < items.length; k++) {
            int p = this.randInt(k, items.length - 1);
            this.swap(items, k, p);
        }
    }
    
    private void bad(int[] items) {
        for (int k = 0; k < items.length; k++) {
            int p = this.randInt(0, items.length - 1);
            this.swap(items, k, p);
        }
    }
    
    private void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
