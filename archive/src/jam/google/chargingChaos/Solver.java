package jam.google.chargingChaos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    @Override
    public String solve(TestCase instance) {
        Queue<SwitchState> q = new LinkedList<SwitchState>();
        int switchesRequired = Integer.MAX_VALUE;
        String[] devices = instance.getDevices();
        Arrays.sort(devices);
        q.add(SwitchState.createInitialState(instance.getOutlets(), instance.getL()));
        
        while (!q.isEmpty()) {
            SwitchState st = q.remove();
            
            if (!st.match(devices)) {
                continue;
            }
            
            if (st.hasNext()) {
                q.add(st.getNext(false));
                q.add(st.getNext(true));
            }
            else {
                if (switchesRequired > st.getSwitchCount()) {
                    switchesRequired = st.getSwitchCount();
                }
            }
        }
        
        if (switchesRequired < Integer.MAX_VALUE) {
            return Integer.toString(switchesRequired);
        }
        else {
            return "NOT POSSIBLE";
        }
        
        /*
        StringBuffer[] outlets = toStringBufferArray(instance.getOutlets());
        StringBufferComparator cmp = new StringBufferComparator();
        Arrays.sort(outlets, cmp);
        Arrays.sort(devices);
        
        for (int switchIndex = 0; switchIndex < instance.getL(); switchIndex++) {
            boolean match = this.isMatch(outlets, devices, switchIndex, instance.getN());
            
            if (!match) {
                switchesRequired++;
                this.turnSwitch(outlets, switchIndex);
                Arrays.sort(outlets, cmp);
                match = this.isMatch(outlets, devices, switchIndex, instance.getN());
            }
            
            if (!match) {
                return "NOT POSSIBLE";
            }
        }
        
        return Integer.toString(switchesRequired);
        */
    }
    
    /*
    private boolean isMatch(StringBuffer[] outlets, String[] devices, int switchIndex, int n) {
        for (int j = 0; j < n; j++) {
            char outletBit = outlets[j].charAt(switchIndex);
            char deviceBit = devices[j].charAt(switchIndex);
            
            if (outletBit != deviceBit) {
                return false;
            }
        }
        
        return true;
    }
    
    private void turnSwitch(StringBuffer[] outlets, int switchIndex) {
        for (StringBuffer outlet : outlets) {
            if (outlet.charAt(switchIndex) == '0') {
                outlet.setCharAt(switchIndex, '1');
            }
            else {
                outlet.setCharAt(switchIndex, '0');
            }
        }
    }
    
    private static StringBuffer[] toStringBufferArray(String[] items) {
        StringBuffer[] newItems = new StringBuffer[items.length];
        
        for (int i = 0; i < items.length; i++) {
            newItems[i] = new StringBuffer(items[i]);
        }
        
        return newItems;
    }
    
    private static final class StringBufferComparator implements Comparator<StringBuffer> {

        @Override
        public int compare(StringBuffer o1, StringBuffer o2) {
            return o1.toString().compareTo(o2.toString());
        }
        
    }
    */
}
