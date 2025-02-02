package prac.injury;

public enum ExternalWounds {
    BURN(1, "화상", 20000),
    CONTUSION(2, "타박상", 15000),
    FRACTURE(3, "골절상", 10000);

    private final int woundNumber;
    private final String woundName;
    private final int woundCost;

    ExternalWounds(int woundNumber, String woundName, int woundCost) {
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
