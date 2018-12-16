package gradient;

import domain.line.StandardLine;
import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class GradientCalculatorStandardLine implements GradientCalculator<StandardLine>
{
  private static final int SCALE = 3;

  @Override
  public Double calculate(StandardLine line)
  {
    Double numerator = line.getA().getOrdinate() - line.getB().getOrdinate();
    Double denominator = line.getA().getAbscissa() - line.getB().getAbscissa();
    Double gradient = numerator / denominator;
    return gradient.isInfinite() ? gradient : roundToScale(gradient);
  }

  private Double roundToScale(Double value) {
    return new BigDecimal(value.toString()).setScale(SCALE, HALF_UP).doubleValue();
  }

}