package jam.google.storeCredit;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

	public final int credit;
	public final StoreItem[] items;
	
    public TestCase(int seqNum, int credit, int[] items) {
        super(seqNum);
        this.credit = credit;
        this.items = new StoreItem[items.length];
        
        for (int i = 0; i < items.length; i++) {
        	this.items[i] = new StoreItem(i + 1, items[i]);
        }
    }
}
