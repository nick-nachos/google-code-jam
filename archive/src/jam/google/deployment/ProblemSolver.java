package jam.google.deployment;

public interface ProblemSolver<T extends TestCaseBase> {
    
    String solve(T instance);
}
