import excpetions.ServiceException;
import services.CalculationService;

public class Main {

    public static void main(String[] args)  {

        // Call service
        CalculationService calcService = new CalculationService();
        try {
            Boolean result = calcService.IsPlusResult(null, 1);
            System.out.println("Result is positive? " + result.toString());
        } catch (ServiceException  ex) {
            // Cause exception
            System.err.println("Cause = " + ex.getCause());

        }
    }

}