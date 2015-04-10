package jam.google.reverseWords;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
    	StringBuilder sb = new StringBuilder();
    	int index = 0;
    	
    	for (int i = instance.line.length() - 1; i > -1; --i) {
    		char c = instance.line.charAt(i);
    		
    		if (c == ' ') {
    			sb.append(c);
    			index = sb.length();
    			continue;
    		}
    		
    		sb.insert(index, c);
    	}
    	
    	return sb.toString();
    }

}
