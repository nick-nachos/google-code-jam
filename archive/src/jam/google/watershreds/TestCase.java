package jam.google.watershreds;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

	public final Map map;
	
    public TestCase(int seqNum, int[][] map) {
        super(seqNum);
        this.map = new Map(map);
    }

}
