package jam.google.storeCredit;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends
        TestCaseEnumerationBase<TestCase> {

    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        int credit = this.readIntegerLine();
        int itemCount = this.readIntegerLine();
        int[] items = this.readIntegerItemLine(itemCount);
        
        return new TestCase(testCaseSeqNum, credit, items);
    }

}
