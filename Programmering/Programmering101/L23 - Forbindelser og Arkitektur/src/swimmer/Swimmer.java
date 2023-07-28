package swimmer;

import java.util.ArrayList;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    public Swimmer(String name, ArrayList<Double> lapTimes, TrainingPlan trainingPlan) {
        this.name = name;
        this.lapTimes = lapTimes;
        this.trainingPlan = trainingPlan;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        double laptime = 10;
        for (double svimmer : getLapTimes())
            if (svimmer < laptime) {
                laptime = svimmer;
            }
        return laptime;
    }

    /**
     * Return how many training hours the swimmer has each week.
     */
    public int allTrainingHours(){
        return trainingPlan.getWeeklyWaterHours();
    }
}
