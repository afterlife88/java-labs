package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Backlog implements Serializable {


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

    public Task findTask(Task task) {
        Task foundTask = null;
        for (Task item : listOfTasks) {
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

//    public ArrayList<Task> getUserTasks(Worker worker) {
//        ArrayList<Task> userTasks = null;
//        userTasks.addAll(listOfTasks.stream().filter(task -> task.getAssignedWorker() == worker).collect(Collectors.toList()));
//        return userTasks;
//    }

    public void unassignTasksForWorker(Worker worker){
        for(Task task : listOfTasks){
            task.setAssignedWorker(null);
        }
    }
}
