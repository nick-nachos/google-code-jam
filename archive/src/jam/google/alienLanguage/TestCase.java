package jam.google.alienLanguage;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase {

	public final String[] dictionary;
	public final String pattern;
	
    public TestCase(int seqNum, String[] dictionary, String pattern) {
        super(seqNum);
        this.dictionary = dictionary;
        this.pattern = pattern;
    }

}
