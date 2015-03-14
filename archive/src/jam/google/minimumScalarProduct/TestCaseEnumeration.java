package jam.google.minimumScalarProduct;

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
        int vectorSize = this.readIntegerLine();
        int[] vector1 = this.readIntegerItemLine(vectorSize);
        int[] vector2 = this.readIntegerItemLine(vectorSize);
        
        return new TestCase(testCaseSeqNum, vector1, vector2);
    }
}
