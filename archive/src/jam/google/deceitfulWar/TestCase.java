package jam.google.deceitfulWar;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {
    
    private double[] naomi;
    private double[] ken;

    public TestCase(int seqNum, double[] naomi, double[] ken) {
        super(seqNum);
        this.naomi = naomi;
        this.ken = ken;
    }

    public double[] getNaomi() {
        return this.naomi;
    }

    public double[] getKen() {
        return this.ken;
    }
}
