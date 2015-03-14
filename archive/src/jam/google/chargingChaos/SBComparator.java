package jam.google.chargingChaos;

import java.util.Comparator;

public class SBComparator implements Comparator<StringBuilder> {

    @Override
    public int compare(StringBuilder o1, StringBuilder o2) {
        return o1.toString().compareTo(o2.toString());
    }

}
