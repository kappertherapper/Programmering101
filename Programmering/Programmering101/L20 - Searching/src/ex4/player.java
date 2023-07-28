package ex4;

public class player {
    private String name;
    private int height;
    private int weight;
    private int scoredGoals;

    public player(String name, int height, int weight, int scoredGoals) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.scoredGoals = scoredGoals;

    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    @Override
    public String toString() {
        return "player{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", scoredGoals=" + scoredGoals +
                '}';
    }
}
