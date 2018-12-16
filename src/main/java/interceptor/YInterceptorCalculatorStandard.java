package interceptor;

import domain.line.StandardLine;
import gradient.GradientCalculatorStandardLine;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class YInterceptorCalculatorStandard implements YInterceptorCalculator<StandardLine>
{
  private static final int SCALE = 2;

  private final GradientCalculatorStandardLine gradientCalculatorStrategyStandardLine;

  public YInterceptorCalculatorStandard()
  {
    this.gradientCalculatorStrategyStandardLine = new GradientCalculatorStandardLine();
  }

  @Override
  public Double calculate(StandardLine line)
  {
    Double gradient = gradientCalculatorStrategyStandardLine.calculate(line);
    if (gradient.isInfinite()) throw new YInterceptorException("the line does not intersect y axis");
    return line.getA().getOrdinate() + ((-1) * getProductFor(gradient, line.getA().getAbscissa()));
  }

  private Double getProductFor(Double gradient, Double abscissa)
  {
    return roundToScale(gradient * abscissa);
  }

  private Double roundToScale(Double value) {
    return new BigDecimal(value.toString()).setScale(SCALE, HALF_UP).doubleValue();
  }

  private class YInterceptorException extends IllegalArgumentException
  {
    public YInterceptorException(String message)
    {
      super(message);
    }
  }
}
