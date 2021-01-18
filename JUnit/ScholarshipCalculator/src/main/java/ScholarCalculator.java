import Exceptions.NotSuchMarkException;

/*рассчет коэффициента для получения стипендии*/
public class ScholarCalculator implements IscholarCalculator {
    public static final double BASIC_SCHOLARSHIP = 100;


    public double calculate(double coeff) {
        return BASIC_SCHOLARSHIP * coeff;
    }

    /*метод, возвращающий стипендию в зав. от оценок*/
    @Override
    public double calculateCoeff(int averageMark) throws NotSuchMarkException {
        double coeff;
        switch (averageMark){
            case 3:
                coeff = 1;
                break;
            case 4:
                coeff = 1.5;
                break;
            case 5:
                coeff = 2;
                break;
            default:
                throw new NotSuchMarkException("There is no mark such as : " + averageMark);
        }
        return coeff;
    }

    public static void main(String[] args) throws NotSuchMarkException {
        ScholarCalculator scholarCalculator = new ScholarCalculator();
        System.out.println(scholarCalculator.calculate(2));
        System.out.println(scholarCalculator.calculate(scholarCalculator.calculateCoeff(5)));
    }



}
