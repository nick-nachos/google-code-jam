package jam.google.watershreds;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
    	Map map = instance.map;
    	char maxNotation = 'a';
    	map.getCell(0, 0).setNotation(maxNotation);
    	
    	for (int row = 0; row < map.getRowCount(); row++) {
    		for (int col = 0; col < map.getColumnCount(); col++) {
    			Cell current = map.getCell(row, col);
    			DrainPath path = new DrainPath();
    			path.add(current);
    			boolean sinkFound = false;
    			
    			while (!sinkFound) {
    				Cell lowestNeighbour = current.getLowestNeighbour();
    				
    				if (lowestNeighbour == null) {
    					break;
    				}
    				
    				if (lowestNeighbour.altitude < current.altitude) {
    					current = lowestNeighbour;
    					path.add(lowestNeighbour);
    				}
    				else {
    					sinkFound = true;
    					char notation = path.getNotation() == 0 ? ++maxNotation : path.getNotation();
    					
    					for (Cell c : path) {
    						c.setNotation(notation);
    					}
    				}
    			}
    		}
    	}
    	
    	return this.stringlifyResult(map);
    }
    
    private String stringlifyResult(Map map) {
    	StringBuilder sb = new StringBuilder("\n");
    	
    	for (int row = 0; row < map.getRowCount(); row++) {
    		for (int col = 0; col < map.getColumnCount(); col++) {
    			sb.append(map.getCell(row, col).getNotation());
    			
    			if (col == map.getColumnCount() - 1) {
    				if (row < map.getRowCount() - 1) {
    					sb.append("\n");
    				}
    			}
    			else {
    				sb.append(" ");
    			}
    		}
    	}
    	
    	return sb.toString();
    }
    
}
