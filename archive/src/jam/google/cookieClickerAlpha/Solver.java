package jam.google.cookieClickerAlpha;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {
    
    @Override
    public String solve(TestCase instance) {
        double cookieRate = 2.0;
        double totalTime = 0.0;
        boolean nextFarmRequired;

        do {
            double currentRequiredTime = instance.getCookieTarget() / cookieRate;
            double timeCostOfNextFarm = instance.getFarmCost() / cookieRate;
            double requiredTimeWithNextFarm = timeCostOfNextFarm + instance.getCookieTarget() / (cookieRate + instance.getFarmGain());

            if (requiredTimeWithNextFarm < currentRequiredTime) {
                cookieRate += instance.getFarmGain();
                totalTime += timeCostOfNextFarm;
                nextFarmRequired = true;
            } 
            else {
                totalTime += currentRequiredTime;
                nextFarmRequired = false;
            }
        } 
        while (nextFarmRequired);

        return String.format("%.7f", totalTime);
    }
}
