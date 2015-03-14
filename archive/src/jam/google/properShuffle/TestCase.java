package jam.google.properShuffle;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

    private int[] permutation;
    
    public TestCase(int seqNum, int[] permutation) {
        super(seqNum);
        this.permutation = permutation;
        
    }

    public int[] getPermutation() {
        return this.permutation;
    }
}
