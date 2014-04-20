package jam.google.deployment;

import java.io.BufferedReader;

public interface IProblemObjectFactory<T extends TestCaseBase> {
    
    TestCaseEnumerationBase<T> getTestCaseEnumeration(BufferedReader in);

    IProblemSolver<T> createSolver();
}
