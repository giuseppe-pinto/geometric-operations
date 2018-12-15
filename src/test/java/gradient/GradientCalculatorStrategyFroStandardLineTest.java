package gradient;

import domain.Point;
import domain.line.StandardLine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GradientCalculatorStrategyFroStandardLineTest
{
  private GradientCalculatorStrategy<StandardLine> gradientCalculatorStrategy =
    new GradientCalculatorStrategyStandardLine();

  @Test
  public void calculateGradientInFirstQuadrant()
  {
    Point a = new Point(2d, 2d);
    Point b = new Point(4d, 4d);
    assertThat(gradientCalculatorStrategy.calculate(new StandardLine(a,b)), is(1d));
  }

  @Test
  public void calculateGradientInSecondQuadrant()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(-4d, 1.5d);
    assertThat(gradientCalculatorStrategy.calculate(new StandardLine(a,b)), is(0.25));
  }

  @Test
  public void calculateGradientInThirdQuadrant()
  {
    Point a = new Point(-2.2d, -3d);
    Point b = new Point(-4d, -1.5d);

    assertThat(gradientCalculatorStrategy.calculate(new StandardLine(a,b)), is(-0.833));
  }

  @Test
  public void calculateGradientInFourthQuadrant()
  {
    Point a = new Point(0.2d, -0.1d);
    Point b = new Point(4.3d, -3.5d);

    assertThat(gradientCalculatorStrategy.calculate(new StandardLine(a,b)), is(-0.829));
  }

  @Test
  public void pointWithZeroInOrdinate()
  {
    Point a = new Point(1d, 0d);
    Point b = new Point(2d, 0d);

    assertThat(gradientCalculatorStrategy.calculate(new StandardLine(a,b)), is(0d));
  }

  @Test
  public void invalidPointForCalculateGradient()
  {
    Point a = new Point(0d, -0.1d);
    Point b = new Point(0d, -3.5d);

    assertThat(gradientCalculatorStrategy.calculate(new StandardLine(a,b)), is(Double.POSITIVE_INFINITY));
  }
}