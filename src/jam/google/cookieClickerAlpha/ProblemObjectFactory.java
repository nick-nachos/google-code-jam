package jam.google.cookieClickerAlpha;

import java.io.BufferedReader;

import jam.google.deployment.IProblemObjectFactory;
import jam.google.deployment.IProblemSolver;
import jam.google.deployment.TestCaseEnumerationBase;

public final class ProblemObjectFactory implements
        IProblemObjectFactory<TestCase> {
    
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
