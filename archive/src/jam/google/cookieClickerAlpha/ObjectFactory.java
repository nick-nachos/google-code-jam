package jam.google.cookieClickerAlpha;

import java.io.BufferedReader;

import jam.google.deployment.ProblemObjectFactory;
import jam.google.deployment.ProblemSolver;
import jam.google.deployment.TestCaseEnumerationBase;

public final class ObjectFactory implements ProblemObjectFactory<TestCase> {
    
    @Override
    public TestCaseEnumerationBase<TestCase> getTestCaseEnumeration(BufferedReader in) {
        return new TestCaseEnumeration(in);
    }

    @Override
    public ProblemSolver<TestCase> createSolver() {
        return new Solver();
    }
}
