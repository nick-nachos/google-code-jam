package jam.google.deployment;

public interface IProblemSolver<T extends TestCaseBase>
{
    String solve(T instance);
}
