package prac.injury;

public enum InternalWounds {
    HEART(1, "심장", 3500000),
    LUNG(2, "폐", 2500000),
    LIVER(3, "간", 2000000);
    
    private final int woundNumber;
    private final String woundName;
    private final int woundCost;
    
    InternalWounds(int woundNumber, String woundName, int woundCost) {
        this.woundNumber = woundNumber;
        this.woundName = woundName;
        this.woundCost = woundCost;
    }

    public int getWoundNumber() {
        return woundNumber;
    }
    public String getWoundName() {
        return woundName;
    }
    public int getWoundCost() {
        return woundCost;
    }
}
