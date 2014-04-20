package jam.google.deployment;

public abstract class TestCaseBase
{
    private int seqNum;
    
    public TestCaseBase(int seqNum)
    {
        this.seqNum = seqNum;
    }
    
    public final int getSeqNum()
    {
        return this.seqNum;
    }
}
