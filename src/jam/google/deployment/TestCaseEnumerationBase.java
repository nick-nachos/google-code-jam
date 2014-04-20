package jam.google.deployment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

public abstract class TestCaseEnumerationBase<T extends TestCaseBase>
        implements Enumeration<T> {
    
    private BufferedReader reader;
    private int testCaseCount;
    private int currentTestCase;

    public TestCaseEnumerationBase(BufferedReader in) {
        this.reader = in;
        this.testCaseCount = this.readIntegerLine();
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

    protected abstract T readNextTestCase(int testCaseSeqNum);

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

    protected final int[] readIntegerItemLine() {
        String[] stringItems = this.readStringItemLine();
        int[] items = new int[stringItems.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = Integer.parseInt(stringItems[i]);
        }

        return items;
    }

    protected final double[] readDecimalItemLine() {
        String[] stringItems = this.readStringItemLine();
        double[] items = new double[stringItems.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = Double.parseDouble(stringItems[i]);
        }

        return items;
    }
}
