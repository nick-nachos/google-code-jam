package jam.google.cookieClickerAlpha;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends TestCaseEnumerationBase<TestCase> {
    
    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        double[] values = this.readDecimalItemLine();
        return new TestCase(testCaseSeqNum, values[0], values[1], values[2]);
    }
}
