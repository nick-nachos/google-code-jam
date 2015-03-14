package jam.google.deployment;

import java.io.BufferedReader;

public interface ProblemObjectFactory<T extends TestCaseBase> {
    
    TestCaseEnumerationBase<T> getTestCaseEnumeration(BufferedReader in);

    ProblemSolver<T> createSolver();
}
