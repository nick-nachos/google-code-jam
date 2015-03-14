package jam.google.repeater;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

    public final int n;
    public final String[] words;
    
    public TestCase(int seqNum, int n, String[] words) {
        super(seqNum);
        this.n = n;
        this.words = words;
    }

}
