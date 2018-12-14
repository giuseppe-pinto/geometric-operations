package Strategy;

import domain.line.GradientInterceptLine;
import domain.line.StandardLine;

import java.util.function.Function;

public class GradientCalculator<T> implements Function<T, Double>
{
  @Override
  public Double apply(T line)
  {
    if(line instanceof StandardLine) {
      StandardLine standardLine = (StandardLine)line;
      double numerator = standardLine.getA().getOrdinate() - standardLine.getB().getOrdinate();
      double denominator = standardLine.getA().getAbscissa() - standardLine.getB().getAbscissa();
      return numerator/denominator;
    }
    else {
      return ((GradientInterceptLine) line).getGradient();
    }
  }
}
