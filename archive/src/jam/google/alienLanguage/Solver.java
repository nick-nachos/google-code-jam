package jam.google.alienLanguage;

import java.util.regex.Pattern;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
        String regexPattern = instance.pattern.replace('(', '[').replace(')', ']');
        Pattern p = Pattern.compile(regexPattern);
        int matchCount = 0;
        
        for (String word : instance.dictionary) {
        	if (p.matcher(word).matches()) {
        		matchCount++;
        	}
        }
        
        return Integer.toString(matchCount);
    }

}
