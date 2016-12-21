package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Project implements Serializable {

    private ArrayList<Worker> workersOnProject;
    private Backlog backlog;
    private String projectName;

    public Project(ArrayList<Worker> workersOnProject, String projectName) {
        this.workersOnProject = workersOnProject;
        this.projectName = projectName;
        backlog = new Backlog();
    }

    public void removeFromProject(Worker worker) {
        workersOnProject.remove(worker);
    }

    public ArrayList<Worker> getWorkersOnProject() {
        return workersOnProject;
    }

    public Backlog getBacklog() {
        return backlog;
    }

    @Override
    public String toString() {
        return projectName;
    }
}
