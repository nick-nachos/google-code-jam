package jam.google.storeCredit;

public class StoreItem implements Comparable<StoreItem> {

	public final int position;
	public final int value;
	
	public StoreItem (int position, int value) {
		this.position = position;
		this.value = value;
	}

	@Override
	public int compareTo(StoreItem o) {
		return this.value - o.value;
	}
}
