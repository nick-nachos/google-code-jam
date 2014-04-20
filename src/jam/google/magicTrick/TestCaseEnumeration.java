package jam.google.magicTrick;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends TestCaseEnumerationBase<TestCase> {
    
    public TestCaseEnumeration(BufferedReader in) {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum) {
        TestCase tc = new TestCase(testCaseSeqNum);
        this.readCardRow(tc.getFirstRow());
        this.readCardRow(tc.getSecondRow());

        return tc;
    }

    private void readCardRow(int[] targetRow) {
        int rowIndex = this.readIntegerLine() - 1;

        for (int i = 0; i < TestCase.CARD_ROWS; i++) {
            if (i == rowIndex) {
                int[] sourceRow = this.readIntegerItemLine();

                for (int j = 0; j < targetRow.length; j++) {
                    targetRow[j] = sourceRow[j];
                }
            }
            else {
                this.readLine();
            }
        }
    }
}
