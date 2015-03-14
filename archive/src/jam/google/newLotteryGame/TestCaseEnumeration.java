package jam.google.newLotteryGame;

import java.io.BufferedReader;
import java.math.BigInteger;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends
        TestCaseEnumerationBase<TestCase> {

    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        String[] input = this.readStringItemLine();
        
        return new TestCase(testCaseSeqNum, new BigInteger(input[0]), new BigInteger(input[1]), new BigInteger(input[2]));
    }

}
