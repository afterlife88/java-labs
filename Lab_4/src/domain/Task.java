package domain;

import java.io.Serializable;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Task implements Serializable {

    private Worker assignedWorker;
    private StatusOfTask statusOfTask;
    private String taskName;
    private TypeOfTask typeOfTask;
    int estimatedHours;

    public Task(String taskName, TypeOfTask typeOfTask, int estimatedHours) {
        this.taskName = taskName;
        this.statusOfTask = StatusOfTask.ToDo;
        this.typeOfTask = typeOfTask;
        this.estimatedHours = estimatedHours;
    }

    public String getTaskName() {
        return taskName;
    }

    public Worker getAssignedWorker() {
        return assignedWorker;
    }

    public void setAssignedWorker(Worker assignedWorker) {
        this.assignedWorker = assignedWorker;
    }

    public void changeTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void reduceEstimate(int hours) {
        int res = estimatedHours - hours;
        if (res < 0)
            throw new IllegalArgumentException("Hours cannot be negative");
        if (res == 0)
            statusOfTask = StatusOfTask.Done;
        estimatedHours = res;
    }

    public Boolean isAssigned() {
        if (assignedWorker == null)
            return false;
        return true;
    }

    public void changeStatusOfTask(StatusOfTask status) {
        if (status == statusOfTask)
            throw new IllegalArgumentException("Status of task already in requested position!");
        statusOfTask = status;
    }

    @Override
    public String toString() {
        return "Task: " + taskName + "\n" +
                "Type of task: " + typeOfTask.name() + "\n" +
                "Current status: " + statusOfTask.name() + "\n" +
                "Assigned to: " + assignHelper() + "\n" +
                "Hours left: " + estimatedHours;
    }

    private String assignHelper() {
        if (!this.isAssigned())
            return "Not assigned";
        return assignedWorker.toString();
    }
}
