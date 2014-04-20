package jam.google.magicTrick;

import jam.google.deployment.TestCaseBase;

public final class TestCase extends TestCaseBase
{
    public static int CARD_ROWS = 4;
    public static int CARD_COLUMNS = 4;
    
    private int[] firstRow;
    private int[] secondRow;
    
    public TestCase(int seqNum)
    {
        super(seqNum);
        this.firstRow = new int[CARD_COLUMNS];
        this.secondRow = new int[CARD_COLUMNS];
    }

    public int[] getFirstRow()
    {
        return firstRow;
    }

    public int[] getSecondRow()
    {
        return secondRow;
    }
}
