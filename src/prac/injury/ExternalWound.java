package prac.injury;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExternalWound extends Injury {
    String hospitalName;

    public ExternalWound() {
        super();
    }

    ExternalWound(String hospitalName) {
        super();
        this.hospitalName = hospitalName;
    }

    // 외상 종류 출력 및 선택
    public void externalWoundList() {
        ExternalWounds[] externalWoundArr = ExternalWounds.values();
        int cost;
        String costStr;
        for(ExternalWounds externalWound : externalWoundArr) {
            cost = externalWound.getWoundCost();
            costStr = String.format("%,d", cost);
            System.out.printf(" %d. %s (+ ₩" + costStr + ")", externalWound.getWoundNumber(), externalWound.getWoundName());
            System.out.println();
        }
    }

}
