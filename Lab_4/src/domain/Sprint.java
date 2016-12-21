package domain;

import exceptions.TaskNotFoundExcpetion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Sprint {

    private LocalDate endDate;
    private ArrayList<Task> tasksForSprint;
    private LocalDate startDate;
    private Backlog backlog;
    private int remainingWork;

    public Sprint(LocalDate startDate, LocalDate endDate, Backlog backlog) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasksForSprint = new ArrayList<>();
        this.backlog = backlog;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void addTaskToSprint(Task task) throws TaskNotFoundExcpetion {
        if (backlog.findTask(task) == null)
            throw new TaskNotFoundExcpetion("Task not found in backlog!");
        tasksForSprint.add(task);
        remainingWork += task.estimatedHours;
    }

    public void reduceRemainingWork(int hours) {
        remainingWork -= hours;
    }

    public ArrayList<Task> getTasksForCurrentSprint() {
        return tasksForSprint;
    }

    @Override
    public String toString() {
        return "Sprint remaining work hours: " + remainingWork + "\n" +
                "Start date: " + startDate.format(DateTimeFormatter.ISO_DATE) + "\n" +
                "End date: " + endDate.format(DateTimeFormatter.ISO_DATE) + "\n" +
                "Tasks left: " + tasksForSprint.size() + "\n";
    }
}
