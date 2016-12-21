package domain;

/**
 * Created by Andrew on 21.12.2016.
 */
public abstract class Worker {
    private String firstName;
    private String secondName;

    protected Worker(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void reduceEstimation(Sprint sprint, Task task, int hour) {
        task.reduceEstimate(hour);
        sprint.reduceRemainingWork(hour);
    }
    public void changeStatus(Task task, StatusOfTask status) {
        task.changeStatusOfTask(status);
    }
    @Override
    public String toString() {
        return firstName + " " + secondName;
    }
}
