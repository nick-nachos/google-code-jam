package jam.google.chargingChaos;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends
        TestCaseEnumerationBase<TestCase> {

    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        int[] nums = this.readIntegerItemLine();
        int n = nums[0];
        int l = nums[1];
        String[] outlets = this.readStringItemLine(n);
        String[] devices = this.readStringItemLine(n);
        this.validateItemLength(outlets, l);
        this.validateItemLength(devices, l);
        
        return new TestCase(testCaseSeqNum, n, l, outlets, devices);
    }
    
    private void validateItemLength(String[] items, int length) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].length() != length) {
                throw new IllegalArgumentException("Invalid item length.");
            }
        }
    }

}
