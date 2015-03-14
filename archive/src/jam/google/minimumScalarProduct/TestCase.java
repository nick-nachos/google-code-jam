package jam.google.minimumScalarProduct;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

    private int[] vector1;
    private int[] vector2;
    
	public TestCase(int seqNum, int[] vector1, int[] vector2) {
		super(seqNum);
		this.vector1 = vector1;
		this.vector2 = vector2;
	}

    public int[] getVector1() {
        return vector1;
    }

    public int[] getVector2() {
        return vector2;
    }
}
