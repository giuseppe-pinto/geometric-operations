package interceptor;

import domain.Point;
import domain.line.StandardLine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class YInterceptorCalculatorForStandardLineTest
{
  private YInterceptorCalculator<StandardLine> yInterceptorCalculator = new YInterceptorCalculatorStandard();

  @Test
  public void positiveInterceptor()
  {
    Point a = new Point(-3d, 3d);
    Point b = new Point(3d, -1d);
    assertThat(yInterceptorCalculator.calculate(new StandardLine(a, b)), is(1.0));
  }

  @Test
  public void negativeInterceptor()
  {
    Point a = new Point(1d, 1d);
    Point b = new Point(2d, 3d);
    assertThat(yInterceptorCalculator.calculate(new StandardLine(a, b)), is(-1.0));
  }

  @Test
  public void interceptOriginPoint()
  {
    Point a = new Point(-1d, 1d);
    Point b = new Point(1d, -1d);
    assertThat(yInterceptorCalculator.calculate(new StandardLine(a, b)), is(0d));
  }

  @Test(expected = RuntimeException.class)
  public void lineWithoutInterceptor()
  {
    Point a = new Point(0d, 1d);
    Point b = new Point(0d, 3d);
    yInterceptorCalculator.calculate(new StandardLine(a, b));
  }
}
