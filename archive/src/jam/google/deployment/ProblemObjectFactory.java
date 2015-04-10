package jam.google.deployment;

import java.io.BufferedReader;
import java.util.Enumeration;

public interface ProblemObjectFactory<T extends TestCaseBase> {
    
    Enumeration<T> getTestCaseEnumeration(BufferedReader in);

    ProblemSolver<T> createSolver();
}
