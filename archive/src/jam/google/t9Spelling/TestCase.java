package jam.google.t9Spelling;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

	public final String line;
	
    public TestCase(int seqNum, String line) {
        super(seqNum);
        this.line = line;
    }

}
