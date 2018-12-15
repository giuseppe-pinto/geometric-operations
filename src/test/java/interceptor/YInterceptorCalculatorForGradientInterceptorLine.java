package interceptor;

import domain.line.GradientInterceptLine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class YInterceptorCalculatorForGradientInterceptorLine
{

  private YInterceptorCalculator<GradientInterceptLine> yInterceptorCalculator = new
    YInterceptorCalculatorGradientInterceptor();

  @Test
  public void positiveIntercept()
  {
    assertThat(yInterceptorCalculator.calculate(new GradientInterceptLine(20.0, 3.0)), is(3.0));
  }

  @Test
  public void negativeIntercept()
  {
    assertThat(yInterceptorCalculator.calculate(new GradientInterceptLine(20.0, -53.0)), is(-53.0));
  }

  @Test
  public void nullIntercept()
  {
    assertNull(yInterceptorCalculator.calculate(new GradientInterceptLine(20.0, null)));
  }

  @Test
  public void zeroIntercept()
  {
    assertThat(yInterceptorCalculator.calculate(new GradientInterceptLine(20.0, 0d)), is(0.0));
  }
}
