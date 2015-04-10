package jam.google.alienLanguage;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends TestCaseEnumerationBase<TestCase> {

	private String[] dictionary;
	
    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected void initialize() {
    	int[] parameters = super.readIntegerItemLine();
    	int wordLength = parameters[0];
    	int dictionarySize = parameters[1];
    	super.setTestCaseCount(parameters[2]);
    	this.dictionary = new String[dictionarySize];
    	
    	for (int i = 0; i < dictionarySize; i++) {
    		this.dictionary[i] = this.readLine();
    		
    		if (this.dictionary[i].length() != wordLength) {
    			throw new IllegalStateException();
    		}
    	}
    }
    
    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        return new TestCase(testCaseSeqNum, this.dictionary, super.readLine());
    }

}
