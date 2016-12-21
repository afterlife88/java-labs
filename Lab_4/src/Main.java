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
        // Creating basic workers
        Programmer frontEndDev = new Programmer("Ivan", "Zavertkin", TypeOfProgrammer.FrontEnd);
        Programmer backEndDev = new Programmer("Andrew", "Volodin", TypeOfProgrammer.Backend);
        Programmer fullstack = new Programmer("Andrew", "Volodin", TypeOfProgrammer.FullStack);

        QualityAssuranceEngineer qa = new QualityAssuranceEngineer("Sasha", "Say");
        QualityAssuranceEngineer uiTester = new QualityAssuranceEngineer("Andrew", "Ryabchun");

        // Creating company and adding workers for it
        Company company = new Company("Epam");
        company.addWorkerToCompany(frontEndDev);
        company.addWorkerToCompany(qa);
        company.addWorkerToCompany(backEndDev);
        company.addWorkerToCompany(fullstack);
        company.addWorkerToCompany(uiTester);

        // Creating team for concrete project
        ArrayList<Worker> teamForProject = new ArrayList<>();
        teamForProject.add(frontEndDev);
        teamForProject.add(qa);
        teamForProject.add(backEndDev);
        teamForProject.add(fullstack);
        teamForProject.add(uiTester);

        // Creating project
        Project projectX = new Project(teamForProject, "Project X");

        // Creating pm
        ProjectManager pm = new ProjectManager("Andrew", "Iasko", projectX);

        // Creating tasks
        Task mainPageTask = new Task("New main page", TypeOfTask.Feature, 11);
        Task newBugWithSlider = new Task("Need to fix slider on our clients widget", TypeOfTask.Bug, 3);
        Task backEndTask = new Task("Implement user service", TypeOfTask.Feature, 5);
        Task newWidget = new Task("Implement payment widget", TypeOfTask.Feature, 12);

        // Adding tasks to backlog
        pm.addTaskToBackLog(mainPageTask);
        pm.addTaskToBackLog(newBugWithSlider);
        pm.addTaskToBackLog(backEndTask);
        pm.addTaskToBackLog(newWidget);

        // Assigning them
        pm.assignTaskToWorker(frontEndDev, newBugWithSlider);
        pm.assignTaskToWorker(frontEndDev, mainPageTask);
        pm.assignTaskToWorker(backEndDev, backEndTask);
        pm.assignTaskToWorker(fullstack, newWidget);

        // Planing the sprint
        Sprint firstSprint = pm.startSprint(LocalDate.now(), LocalDate.now().plusMonths(1));

        // Adding tasks to first sprint
        firstSprint.addTaskToSprint(mainPageTask);
        firstSprint.addTaskToSprint(newBugWithSlider);
        firstSprint.addTaskToSprint(backEndTask);
        firstSprint.addTaskToSprint(newWidget);

        // In process of development, reducing estimation and making task in progress by dev
        frontEndDev.changeStatus(mainPageTask, StatusOfTask.InProgress);
        frontEndDev.reduceEstimation(firstSprint, mainPageTask, 2);

        System.out.println("Sprint #1: \n" + firstSprint.toString() + "\nTasks on this sprint: \n");
        for (Task obj : firstSprint.getTasksForCurrentSprint()) {
            System.out.println(obj + "\n");
        }

        // Removing worker from project
        pm.removeWorkerFromProject(frontEndDev);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Current workers on project (after removing our front-end dev): " + projectX.toString() + "\n");
        for (Worker worker : projectX.getWorkersOnProject()) {
            System.out.println(worker.toString());
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("Tasks that left after developer leave: \n");
        for (Task obj : firstSprint.getTasksForCurrentSprint()) {
            System.out.println(obj + "\n");
        }

        // Serialization and and deserializating demo
        SerializationService<Sprint> serializationService = new SerializationService<>();

        serializationService.serialize(firstSprint, "C:\\Projects\\1.txt");

        Sprint deSerializedSprint = serializationService.deSerialize("C:\\Projects\\1.txt");

        System.out.println("-------------------------------------------------------------");
        System.out.println("DEMO: Deserialized object: \n" + deSerializedSprint.toString());
    }
}
