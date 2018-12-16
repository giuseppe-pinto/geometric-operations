package gradient;

import domain.Point;
import domain.line.StandardLine;
import java.math.BigDecimal;
import java.util.Optional;

import static java.math.RoundingMode.HALF_UP;

public class GradientCalculatorStandardLine implements GradientCalculator<StandardLine>
{
  private static final int SCALE = 3;

  @Override
  public Double calculate(StandardLine line)
  {
    if(line.getA()==null || line.getB()==null ){
      throw new GradientCalculatorStandardLineException("The points must not be null");
    }
    Double numerator = getNumeratorForGradient(line.getA(), line.getB());
    Double denominator = getDenominatorForGradient(line.getA(), line.getB());
    Double gradient = numerator / denominator;
    return gradient.isInfinite() ? gradient : roundToScale(gradient);
  }

  private double getDenominatorForGradient(Point a, Point b)
  {
    return Optional.ofNullable(a.getAbscissa())
      .orElseThrow(() -> new GradientCalculatorStandardLineException("The point A doesn't have abscissa"))
      - Optional.ofNullable(b.getAbscissa())
      .orElseThrow(() -> new GradientCalculatorStandardLineException("The point B doesn't have abscissa"));
  }

  private double getNumeratorForGradient(Point a, Point b)
  {
    return Optional.ofNullable(a.getOrdinate())
      .orElseThrow(() -> new GradientCalculatorStandardLineException("The Point A doesn't have ordinate"))
      - Optional.ofNullable(b.getOrdinate())
      .orElseThrow(() -> new GradientCalculatorStandardLineException("The Point B doesn't have ordinate "));
  }



  private Double roundToScale(Double value) {
    return new BigDecimal(value.toString()).setScale(SCALE, HALF_UP).doubleValue();
  }

  private class GradientCalculatorStandardLineException extends IllegalArgumentException
  {
    GradientCalculatorStandardLineException(String message)
    {
      super(message);
    }
  }
}