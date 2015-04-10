package jam.google.deployment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

public abstract class TestCaseEnumerationBase<T extends TestCaseBase>
        implements Enumeration<T> {
    
    private BufferedReader reader;
    private int testCaseCount;
    private int currentTestCase;

    public TestCaseEnumerationBase(BufferedReader in) {
        this.reader = in;
        this.initialize();
    }

    @Override
    public final boolean hasMoreElements() {
        return this.currentTestCase < this.testCaseCount;
    }

    @Override
    public final T nextElement() {
        if (!this.hasMoreElements())
            return null;

        T testCase = this.readNextTestCase(this.currentTestCase + 1);
        this.currentTestCase++;

        return testCase;
    }

    protected void initialize() {
    	this.setTestCaseCount(this.readIntegerLine());
    }
    
    protected abstract T readNextTestCase(int testCaseSeqNum);

    protected final int getTestCaseCount() {
    	return this.testCaseCount;
    }
    
    protected final void setTestCaseCount(int testCaseCount) {
    	this.testCaseCount = testCaseCount;
    }
    
    protected final String readLine() {
        try {
            return this.reader.readLine();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected final int readIntegerLine() {
        return Integer.parseInt(this.readLine());
    }

    protected final String[] readStringItemLine() {
        return this.readLine().split(" ");
    }
    
    protected final String[] readStringItemLine(int length) {
        String[] items = this.readLine().split(" ");
        
        if (length < 0 || length == items.length) {
            return items;
        }
        else {
            return Arrays.copyOf(items, length);
        }
    }

    protected final int[] readIntegerItemLine() {
        return this.readIntegerItemLine(-1);
    }
    
    protected final int[] readIntegerItemLine(int length) {
        String[] stringItems = this.readStringItemLine(length);
        int[] items = new int[stringItems.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = Integer.parseInt(stringItems[i]);
        }

        return items;
    }

    protected final double[] readDecimalItemLine() {
        return this.readDecimalItemLine(-1);
    }
    
    protected final double[] readDecimalItemLine(int length) {
        String[] stringItems = this.readStringItemLine(length);
        double[] items = new double[stringItems.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = Double.parseDouble(stringItems[i]);
        }

        return items;
    }
}
