package gradient;

import domain.line.GradientInterceptLine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class GradientCalculatorStrategyForGradientInterceptLine
{

  private GradientCalculatorStrategy<GradientInterceptLine>
    gradientCalculatorStrategy = new GradientCalculatorStrategyGradientInterceptLine();

  @Test
  public void calculatePositiveGradient()
  {
    assertThat(gradientCalculatorStrategy.calculate(new GradientInterceptLine(20.0,0.1)), is(20.0));
  }

  @Test
  public void calculateGradientNull()
  {
    assertNull(gradientCalculatorStrategy.calculate(new GradientInterceptLine(null,0.1)));
  }

  @Test
  public void calculateNegativeGradient()
  {
    assertThat(gradientCalculatorStrategy.calculate(new GradientInterceptLine(-20.0,0.1)), is(-20.0));
  }
}
