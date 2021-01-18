import Exceptions.NotSuchMarkException;
import org.junit.*;

public class ScholarCalculatorTest2 {
    private ScholarCalculator scholarCalculator;

    /*аннотация @Before задан момент создания объекта класса перед каждым тестом
    * следующий метод выполняет инициализацию поля scholarshipCalculator*/
    @Before
    public void initScholarshipCalculator(){
        scholarCalculator = new ScholarCalculator();
    }

    @After
    public void clearScholarshipCalculator(){
        scholarCalculator = null;
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
}
