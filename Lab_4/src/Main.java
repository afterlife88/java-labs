import domain.*;
import exceptions.TaskNotFoundExcpetion;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by extra on 21.12.2016.
 */
public class Main {
    public static void main(String[] args) throws TaskNotFoundExcpetion {
        Programmer firstProgrammer = new Programmer("Ivan", "Zavertkin", TypeOfProgrammer.FrontEnd);
        QualityAssuranceEngineer firstQa = new QualityAssuranceEngineer("Sasha", "Say");


        ArrayList<Worker> team = new ArrayList<>();
        team.add(firstProgrammer);
        team.add(firstQa);

        Project projectX = new Project(team);

        ProjectManager pm = new ProjectManager("Andrew", "Iasko", projectX);

        Task mainPageTask = new Task("New main page", TypeOfTask.Feature, 11);
        Task newBugWithSlider = new Task("Need to fix slider on our clients widget", TypeOfTask.Bug, 3);

        pm.addTaskToBackLog(mainPageTask);
        pm.addTaskToBackLog(newBugWithSlider);

        pm.assignTaskToWorker(firstProgrammer, mainPageTask);
        Sprint firstSprint = pm.startSprint(LocalDate.now(), LocalDate.now().plusMonths(1));

        firstSprint.addTaskToSprint(mainPageTask);
        firstSprint.addTaskToSprint(newBugWithSlider);
        firstProgrammer.changeStatus(mainPageTask, StatusOfTask.InProgress);
        firstProgrammer.reduceEstimation(firstSprint, mainPageTask, 2);

//        System.out.println("Backlog: \n");
//        for (Task obj : projectX.getBacklog().getListOfTasks()) {
//            System.out.println(obj + "\n");
//        }

        System.out.println("Sprint #1: \n" + firstSprint.toString() + "\nTasks on this sprint: \n");
        for (Task obj : firstSprint.getTasksForCurrentSprint()){
            System.out.println(obj + "\n");
        }


    }
}
