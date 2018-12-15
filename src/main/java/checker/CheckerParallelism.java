package checker;

import gradient.GradientCalculatorStrategy;

import java.util.Objects;

public class CheckerParallelism<T>
{
  private GradientCalculatorStrategy<T> gradientCalculatorStrategy;

  public CheckerParallelism(GradientCalculatorStrategy<T> gradientCalculatorStrategy)
  {
    this.gradientCalculatorStrategy = gradientCalculatorStrategy;
  }

  public boolean areParallel(T firstLine, T secondLine)
  {
    Double firstGradient = gradientCalculatorStrategy.calculate(firstLine);
    Double secondGradient = gradientCalculatorStrategy.calculate(secondLine);
    return (!firstGradient.equals(0d) || !secondGradient.equals(0d))
      && Objects.equals(firstGradient, secondGradient);
  }
}
