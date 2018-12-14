import Strategy.GradientCalculator;
import domain.Point;
import domain.line.GradientInterceptLine;
import domain.line.StandardLine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GradientCalculatorTest
{

  private GradientCalculator gradientCalculator = new GradientCalculator();

  @Test
  public void calculateGradientWithGradientInterceptLine()
  {
    GradientInterceptLine line = new GradientInterceptLine(2d,2d);
    assertThat(gradientCalculator.apply(line), is(2d));
  }

  @Test
  public void calculateGradientForStandardLine()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    StandardLine line = new StandardLine(a,b);
    assertThat(gradientCalculator.apply(line), is(1.5));
  }

}