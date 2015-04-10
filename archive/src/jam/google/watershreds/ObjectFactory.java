package jam.google.watershreds;

import java.io.BufferedReader;
import java.util.Enumeration;

import jam.google.deployment.ProblemObjectFactory;
import jam.google.deployment.ProblemSolver;

public class ObjectFactory implements ProblemObjectFactory<TestCase> {

    @Override
    public Enumeration<TestCase> getTestCaseEnumeration(BufferedReader in) {
        return new TestCaseEnumeration(in);
    }

    @Override
    public ProblemSolver<TestCase> createSolver() {
        return new Solver();
    }

}
