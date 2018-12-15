package checker;

import gradient.GradientCalculatorStrategy;

import java.util.Objects;

public class CheckerIncidence<T>
{
  private GradientCalculatorStrategy<T> gradientCalculatorStrategy;

  public CheckerIncidence(GradientCalculatorStrategy<T> gradientCalculatorStrategy)
  {
    this.gradientCalculatorStrategy = gradientCalculatorStrategy;
  }

  public boolean areIncident(T firstLine, T secondLine){
    return !Objects.equals(gradientCalculatorStrategy.calculate(firstLine),
      gradientCalculatorStrategy.calculate(secondLine));
  }
}
