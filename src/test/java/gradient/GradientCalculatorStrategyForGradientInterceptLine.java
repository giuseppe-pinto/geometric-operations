package gradient;

import domain.line.GradientInterceptLine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class GradientCalculatorStrategyForGradientInterceptLine
{

  private GradientCalculator<GradientInterceptLine>
    gradientCalculator = new GradientCalculatorStrategyGradientInterceptLine();

  @Test
  public void calculatePositiveGradient()
  {
    assertThat(gradientCalculator.calculate(new GradientInterceptLine(20.0,0.1)), is(20.0));
  }

  @Test
  public void calculateGradientNull()
  {
    assertNull(gradientCalculator.calculate(new GradientInterceptLine(null,0.1)));
  }

  @Test
  public void calculateNegativeGradient()
  {
    assertThat(gradientCalculator.calculate(new GradientInterceptLine(-20.0,0.1)), is(-20.0));
  }
}
