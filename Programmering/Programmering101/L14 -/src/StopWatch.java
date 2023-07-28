import java.time.Duration;
import java.time.LocalTime;

public class StopWatch {

    private LocalTime startTime;
    private LocalTime endTime;


    public StopWatch() {

    }

    public void start() {
        startTime = LocalTime.now();

    }

    public void stop() {
        endTime = LocalTime.now();


    }

    //get start time
    public LocalTime getStartTime() {
        return startTime;
    }

    //get end time
    public LocalTime getEndTime() {
        return endTime;
    }

    //get time between start and end in secounds
    public long elapsedTime() {

        return Duration.between(startTime,endTime).toSeconds();
    }



}
