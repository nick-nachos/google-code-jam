package jam.google.repeater;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends
        TestCaseEnumerationBase<TestCase> {

    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        int n = this.readIntegerLine();
        String[] words = new String[n];
        
        for (int i = 0; i < words.length; i++) {
            words[i] = this.readLine();
        }
        
        return new TestCase(testCaseSeqNum, n, words);
    }

}
