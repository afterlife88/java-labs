package domain;

import java.util.ArrayList;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Company {
    private String companyName;

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    private ArrayList<Worker> workers;

    public String getCompanyName() {
        return companyName;
    }

    public Company(String companyName) {
        this.companyName = companyName;
        workers = new ArrayList<>();
    }

    public void addWorkerToCompany(Worker worker) {
        workers.add(worker);
    }



}
