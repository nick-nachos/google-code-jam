package jam.google.magicTrick;

import java.io.BufferedReader;

import jam.google.deployment.IProblemObjectFactory;
import jam.google.deployment.IProblemSolver;
import jam.google.deployment.TestCaseEnumerationBase;

public class ProblemObjectFactory implements IProblemObjectFactory<TestCase> {
    
    @Override
    public TestCaseEnumerationBase<TestCase> getTestCaseEnumeration(
            BufferedReader in) {
        return new TestCaseEnumeration(in);
    }

    @Override
    public IProblemSolver<TestCase> createSolver() {
        return new ProblemSolver();
    }
}
