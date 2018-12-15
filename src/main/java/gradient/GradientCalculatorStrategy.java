package gradient;

public interface GradientCalculatorStrategy<T>
{
  Double calculate(T line);
}
