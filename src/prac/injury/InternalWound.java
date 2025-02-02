package prac.injury;


public class InternalWound extends Injury {
    String hospitalName;

    public InternalWound() {
        super();
    }

    InternalWound(String hospitalName) {
        super();
        this.hospitalName = hospitalName;
    }

    @Override
    public void woundList() {
        InternalWounds[] internalWoundArr = InternalWounds.values();
        int cost;
        String costStr;
        for(InternalWounds internalWound : internalWoundArr) {
            cost = internalWound.getWoundCost();
            costStr = String.format("%,d", cost);
            System.out.printf(" %d. %s (+ ₩" + costStr + ")", internalWound.getWoundNumber(), internalWound.getWoundName());
            System.out.println();
        }
    }

    @Override
    public void transferToHospital() {

    }
}
