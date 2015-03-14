package jam.google.properShuffle;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends
        TestCaseEnumerationBase<TestCase> {

    public TestCaseEnumeration(BufferedReader in) {
        super(in);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        int n = this.readIntegerLine();
        int[] permutation = this.readIntegerItemLine(n);
        
        return new TestCase(testCaseSeqNum, permutation);
    }

}
