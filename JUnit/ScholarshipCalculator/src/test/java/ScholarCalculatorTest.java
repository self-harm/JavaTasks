import org.junit.Assert;
import org.junit.Test;

public class ScholarCalculatorTest {
    /*пишем название класса такое же и в конце добавляем 'Test'
    * также перед каждым классом пишем аннотацию @Test*/
    @Test
    public void testCalculate() {
        /*создаем объкт основного класса*/
        IscholarCalculator scholarCalculator = new ScholarCalculator();

        double basicScholarship = ScholarCalculator.BASIC_SCHOLARSHIP;
        double coeff = 1.1;

        /*expected - то, что мы ожидаем*/
        /*actual - то, что происходит на самом деле: выполнение метода нашим объектом класса*/
        double expected = basicScholarship * coeff;
        double actual = scholarCalculator.calculate(coeff);

        /*проверка на совпадение с погрешностью delta = 0,01*/
        Assert.assertEquals(expected, actual, 0.01);
    }
}