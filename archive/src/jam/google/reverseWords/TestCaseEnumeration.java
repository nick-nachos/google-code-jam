package jam.google.reverseWords;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends
        TestCaseEnumerationBase<TestCase> {

    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
    	return new TestCase(testCaseSeqNum, super.readLine());
    }

}
