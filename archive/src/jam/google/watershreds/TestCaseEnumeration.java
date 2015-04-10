package jam.google.watershreds;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends
        TestCaseEnumerationBase<TestCase> {

    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
    	int[] dimensions = this.readIntegerItemLine(2);
    	int height = dimensions[0];
    	int width = dimensions[1];
    	int[][] map = new int[height][];
    	
    	for (int i = 0; i < map.length; i++) {
    		map[i] = this.readIntegerItemLine(width);
    	}
    	
    	return new TestCase(testCaseSeqNum, map);
    }

}
