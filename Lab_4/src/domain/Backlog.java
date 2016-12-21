package domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Backlog {


    private ArrayList<Task> listOfTasks;

    public Backlog() {
        listOfTasks = new ArrayList<>();
    }

    public void addTask(Task data) {
        listOfTasks.add(data);
    }

    public Task findTask(String taskName) {
        Task task = null;
        for (Task item : listOfTasks) {
            if (Objects.equals(item.getTaskName(), taskName))
                task = item;
        }
        return task;
    }
    public Task findTask (Task task){
        Task foundTask = null;
        for (Task item : listOfTasks){
            if (Objects.equals(item.getTaskName(), task.getTaskName()))
                foundTask = task;
        }
        return foundTask;
    }
    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }
    public void removeTask(Task task) {
        listOfTasks.remove(task);
    }
}
