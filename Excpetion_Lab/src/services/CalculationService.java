package services;

import excpetions.ServiceException;

/**
 * Created by Andrew on 12.12.2016.
 */
public class CalculationService {
    public Boolean IsPlusResult (Integer firstNumber, Integer secondNumber) throws ServiceException {
        if(firstNumber == null | secondNumber == null)
            throw new ServiceException("Numbers cannot be null!");

        Integer result = firstNumber + secondNumber;

        if (result > 0)
            return true;
        else
            return false;
    }
}
