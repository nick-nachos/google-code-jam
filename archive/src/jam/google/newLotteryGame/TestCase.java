package jam.google.newLotteryGame;

import java.math.BigInteger;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

    public final BigInteger a;
    public final BigInteger b;
    public final BigInteger k;
    
    public TestCase(int seqNum, BigInteger a, BigInteger b, BigInteger k) {
        super(seqNum);
        this.a = a;
        this.b = b; 
        this.k = k;
    }

}
