package jam.google.chargingChaos;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

    private int n;
    private int l;
    private String[] outlets;
    private String[] devices;
    
    public TestCase(int seqNum, int n, int l, String[] outlets, String[] devices) {
        super(seqNum);
        this.n = n;
        this.l = l;
        this.outlets = outlets;
        this.devices = devices;
    }
    
    public int getN() {
        return n;
    }

    public int getL() {
        return l;
    }

    public String[] getOutlets() {
        return outlets;
    }

    public String[] getDevices() {
        return devices;
    }
    
}
