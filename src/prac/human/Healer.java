package prac.human;

public class Healer extends Human {
    String type;
    int cost;
    int minProbability;
    int maxProbability;

    public Healer() {
        super();
    }

    Healer(String type, int cost, int minProbability, int maxProbability) {
        super();
        this.type = type;
        this.cost = cost;
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
    }

    public void healerList(Healer[] healers) {
        int num = 1;
        for(Healer healer : healers) {
            String type = healer.getType();
            String cost = String.format("%,d", healer.getCost());
            int minProbability = healer.getMinProbability();
            int maxProbability = healer.getMaxProbability();
            System.out.printf(" %d. %s \t(+ ₩ %s) (성공 확률 : %d ~ %d%%)", num, type, cost, minProbability, maxProbability);
            System.out.println();
            num++;
        }
    }

    void cure() {

    }

    void totalCostCalculate() {

    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMinProbability() {
        return minProbability;
    }
    public void setMinProbability(int minProbability) {
        this.minProbability = minProbability;
    }

    public int getMaxProbability() {
        return maxProbability;
    }
    public void setMaxProbability(int maxProbability) {
        this.maxProbability = maxProbability;
    }
}
