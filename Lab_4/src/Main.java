import domain.*;
import exceptions.TaskNotFoundExcpetion;
import serialization.SerializationService;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Main {
    public static void main(String[] args) throws TaskNotFoundExcpetion {
        Programmer firstProgrammer = new Programmer("Ivan", "Zavertkin", TypeOfProgrammer.FrontEnd);
        QualityAssuranceEngineer firstQa = new QualityAssuranceEngineer("Sasha", "Say");


        Company company = new Company("Epam");
        company.addWorkerToCompany(firstProgrammer);
        company.addWorkerToCompany(firstQa);

        ArrayList<Worker> teamForProject = new ArrayList<>();
        teamForProject.add(firstProgrammer);
        teamForProject.add(firstQa);

        Project projectX = new Project(teamForProject);

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


        pm.removeWorkerFromProject(firstProgrammer);


//        for (Task obj : firstSprint.getTasksForCurrentSprint()){
//            System.out.println(obj + "\n");
//        }

        for (Worker worker : projectX.getWorkersOnProject()){
            System.out.println(worker.toString());
        }
//        SerializationService<Sprint> serializationService = new SerializationService<>();
//
//        serializationService.serialize(firstSprint, "C:\\Projects\\1.txt");
//
//        Sprint deSerializedSprint = serializationService.deSerialize("C:\\Projects\\1.txt");
//
//        System.out.println("Deserialized object: \n" + deSerializedSprint.toString());
    }
}
