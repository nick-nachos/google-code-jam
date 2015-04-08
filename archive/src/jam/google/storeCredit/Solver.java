package jam.google.storeCredit;

import java.util.Arrays;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
    	Arrays.sort(instance.items);
    	int i = 0, j = instance.items.length - 1;
    	boolean found = false;
    	
    	while (!found & i < j) {
    		int total = instance.items[i].value + instance.items[j].value;
    		
    		if (total == instance.credit) {
    			found = true;
    		}
    		else if (total > instance.credit) {
    			j--;
    		}
    		else {
    			i++;
    		}
     	}
    	
    	int item1Position = instance.items[i].position;
    	int item2Position = instance.items[j].position;
    	
    	return this.formatSolution(item1Position, item2Position);
    }
    
    private String formatSolution(int position1, int position2) {
    	if (position1 > position2) {
    		int temp = position1;
    		position1 = position2;
    		position2 = temp;
    	}
    	
    	return String.format("%d %d", position1, position2);
    }

}
