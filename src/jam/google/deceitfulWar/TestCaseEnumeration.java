package jam.google.deceitfulWar;

import java.io.BufferedReader;

import jam.google.deployment.TestCaseEnumerationBase;

public final class TestCaseEnumeration extends TestCaseEnumerationBase<TestCase>
{
    public TestCaseEnumeration(BufferedReader in)
    {
        super(in);
    }

    @Override
    protected TestCase readNextTestCase(int testCaseSeqNum)
    {
        int n = this.readIntegerLine();
        double[] naomi = new double[n];
        double[] ken = new double[n];
        String[] tokens = this.readStringItemLine();
        
        for (int i = 0; i < n; i++)
        {
            naomi[i] = Double.parseDouble(tokens[i]);
        }
        
        tokens = this.readStringItemLine();
        
        for (int i = 0; i < n; i++)
        {
            ken[i] = Double.parseDouble(tokens[i]);
        }
        
        return new TestCase(testCaseSeqNum, naomi, ken);
    }

}
