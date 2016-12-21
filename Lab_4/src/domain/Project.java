package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Project  implements Serializable {

    private ArrayList<Worker> workersOnProject;
    private Backlog backlog;

    public Project(ArrayList<Worker> workersOnProject) {
        this.workersOnProject = workersOnProject;
        backlog = new Backlog();
    }

    public void removeFromProject (Worker worker){
        workersOnProject.remove(worker);
    }
    public ArrayList<Worker> getWorkersOnProject() {
        return workersOnProject;
    }

    public Backlog getBacklog() {
        return backlog;
    }
}
