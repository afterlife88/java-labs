package domain;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Programmer extends Worker {

    private TypeOfProgrammer typeOfProgrammer;

    public Programmer(String firstName, String secondName, TypeOfProgrammer typeOfProgrammer) {
        super(firstName, secondName);

        this.typeOfProgrammer = typeOfProgrammer;
    }

    public TypeOfProgrammer getTypeOfProgrammer() {
        return typeOfProgrammer;
    }



}
