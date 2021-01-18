import Exceptions.NotSuchMarkException;

public interface IscholarCalculator {
    double calculate(double coeff);
    double calculateCoeff(int averageMark) throws NotSuchMarkException;
}
