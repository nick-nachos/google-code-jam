package jam.google.cookieClickerAlpha;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {
    
    private double farmCost;
    private double farmGain;
    private double cookieTarget;

    public TestCase(int seqNum, double farmCost, double farmGain, double cookieTarget) {
        super(seqNum);
        this.farmCost = farmCost;
        this.farmGain = farmGain;
        this.cookieTarget = cookieTarget;
    }

    public double getFarmCost() {
        return farmCost;
    }

    public double getFarmGain() {
        return farmGain;
    }

    public double getCookieTarget() {
        return cookieTarget;
    }
}
