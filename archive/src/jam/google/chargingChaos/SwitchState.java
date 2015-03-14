package jam.google.chargingChaos;

import java.util.Arrays;

public final class SwitchState {

    private StringBuilder[] outlets;
    private int outletLength;
    private int switchIndex;
    private int switchCount;
    
    private SwitchState() { }
    
    public int getSwitchIndex() {
        return switchIndex;
    }
    
    public int getSwitchCount() {
        return this.switchCount;
    }
    
    public StringBuilder[] getOutlets() {
        return outlets;
    }
    
    public int getOutletLength() {
        return this.outletLength;
    }
    
    public boolean hasNext() {
        return this.switchIndex < this.getOutletLength() - 1;
    }
    
    public SwitchState getNext(boolean switched) {
        if (!this.hasNext()) {
            throw new IllegalStateException();
        }
        
        SwitchState next = new SwitchState();
        next.outlets = copy(this.getOutlets());
        next.outletLength = this.getOutletLength();
        next.switchIndex = this.getSwitchIndex() + 1;
        next.switchCount = this.getSwitchCount();
        
        if (switched) {
            next.switchCount++;
            
            for (int i = 0; i < next.getOutlets().length; i++) {
                StringBuilder outlet = next.getOutlets()[i];
                char c = outlet.charAt(next.getSwitchIndex());
                char c2 = c == '0' ? '1' : '0';
                outlet.setCharAt(next.getSwitchIndex(), c2);
            }
            
            Arrays.sort(next.getOutlets(), new SBComparator());
        }
        
        return next;
    }
    
    public boolean match(String[] devices) {
        if (this.getSwitchIndex() < 0) {
            return true;
        }
        
        for (int i = 0; i < devices.length; i++) {
            char outletBit = this.getOutlets()[i].charAt(this.getSwitchIndex());
            char deviceBit = devices[i].charAt(this.getSwitchIndex());
            
            if (outletBit != deviceBit) {
                return false;
            }
        }
        
        return true;
    }
    
    public static SwitchState createInitialState(String[] outlets, int outletLength) {
        SwitchState state = new SwitchState();
        state.outlets = copy(outlets);
        Arrays.sort(state.getOutlets(), new SBComparator());
        state.switchIndex = -1;
        state.outletLength = outletLength;
        
        return state;
    }
    
    private static <T extends CharSequence> StringBuilder[] copy(T[] items) {
        StringBuilder[] copy = new StringBuilder[items.length];
        
        for (int i = 0; i < items.length; i++) {
            copy[i] = new StringBuilder(items[i]);
        } 
        
        return copy;
    }
}
