import excpetions.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.CalculationService;

/**
 * Created by Andrew on 12.12.2016.
 */
public class CalculationServiceUnitTests {

    CalculationService calculationService;
    @Before
    public void setup() {

        calculationService = new CalculationService();
    }

    @Test
    public void IsPlusResult_ThrowServiceException_WhenRequestedWithNullArguments() throws ServiceException {
        // Arrange
        Integer firstArgument = null;
        Integer secondArgument = 2;

        // Act
        try {
            calculationService.IsPlusResult(firstArgument, secondArgument);
        }catch (ServiceException ex){
            // Asset
            Assert.assertNotNull(ex);
            Assert.assertEquals(ex.getMessage(), "Numbers cannot be null!");
        }
    }
    @Test
    public void IsPlusResult_ReturnTrue_WhenResultIsPositive(){
        // Arrange
        Integer firstArgument = 2;
        Integer secondArgument = 5;

        // Act
        try {
            Boolean result = calculationService.IsPlusResult(firstArgument, secondArgument);
            // Assert
            Assert.assertNotNull(result);
            Assert.assertEquals(true, result);
        } catch (ServiceException ex) {
            Assert.assertNull(ex);
        }
    }
    @Test
    public void IsPlusResult_ReturnFalse_WhenResultIsNegative(){
        // Arrange
        Integer firstArgument = 2;
        Integer secondArgument = -5;

        // Act
        try {
            Boolean result = calculationService.IsPlusResult(firstArgument, secondArgument);
            // Assert
            Assert.assertNotNull(result);
            Assert.assertEquals(false, result);
        } catch (ServiceException ex) {
            Assert.assertNull(ex);
        }
    }
}
