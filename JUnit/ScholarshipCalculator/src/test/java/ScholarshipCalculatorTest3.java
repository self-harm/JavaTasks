import Exceptions.NotSuchMarkException;
import org.junit.*;

public class ScholarshipCalculatorTest3 {
    private static ScholarCalculator scholarCalculator;

    @BeforeClass
    public static void beforeClass() throws Exception {
        scholarCalculator = new ScholarCalculator();
    }

    @Test
    public void coeffForFive() throws NotSuchMarkException {
        double expected = 2;
        double actual = scholarCalculator.calculateCoeff(5);
        Assert.assertEquals("Coef mark for 5 is wrong: ",expected, actual, 0);
    }

    @Test
    public void coeffForFour() throws NotSuchMarkException {
        double expected = 1.5;
        double actual = scholarCalculator.calculateCoeff(4);
        Assert.assertEquals("Coef mark for 4 is wrong: ",expected, actual, 0);
    }

    @Test
    public void coeffForThree() throws NotSuchMarkException {
        double expected = 1;
        double actual = scholarCalculator.calculateCoeff(3);
        Assert.assertEquals("Coef mark for 3 is wrong: ",expected, actual, 0);
    }

    /*тест для определения альтернативного сценария: когда указали несуществующую оценку
    *
    * тест завершится успешно лишь в том случае если случится исключительная ситуация и выкинется Exception*/
    @Test(expected = NotSuchMarkException.class)
    public void coeffForAnother() throws NotSuchMarkException {
        double expected = 1;
        double actual = scholarCalculator.calculateCoeff(15);
        Assert.assertEquals("There is no such a mark: ",expected, actual, 0);
    }
}
