package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.GradientInterceptLine;
import gradient.GradientCalculatorStrategy;
import gradient.GradientCalculatorStrategyGradientInterceptLine;
import interceptor.YInterceptorCalculator;
import interceptor.YInterceptorCalculatorGradientInterceptor;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IncidentPointCalculatorGradientInterceptorTest
{

  private IncidentPointCalculator<GradientInterceptLine> incidentPointCalculator;
  private CheckerIncidence<GradientInterceptLine> checkerIncidence;
  private GradientCalculatorStrategy<GradientInterceptLine> gradientCalculator;
  private YInterceptorCalculator<GradientInterceptLine> yInterceptorCalculator;

  @Before
  public void setUp()
  {
    gradientCalculator = new GradientCalculatorStrategyGradientInterceptLine();
    checkerIncidence = new CheckerIncidence<>(gradientCalculator);
    yInterceptorCalculator = new YInterceptorCalculatorGradientInterceptor();
    incidentPointCalculator = new IncidentPointCalculatorGradientInterceptorLine(
      checkerIncidence,
      yInterceptorCalculator,
      gradientCalculator);
  }

  @Test
  public void interceptorInFirstQuadrant()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(1.0,0d);
    GradientInterceptLine secondLine = new GradientInterceptLine(-2.0,3.0);
    assertThat(incidentPointCalculator.calculate(firstLine, secondLine), is(new Point(1.0,1.0)));
  }

  @Test
  public void interceptorInFourthQuadrant()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(-1.0/4,-3.0/2);
    GradientInterceptLine secondLine = new GradientInterceptLine(-1.0/2.0,1.0);
    assertThat(incidentPointCalculator.calculate(firstLine, secondLine), is(new Point(10.0,-4.0)));
  }

  @Test(expected = RuntimeException.class)
  public void interceptorForParallelLines()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(5.0,0d);
    GradientInterceptLine secondLine = new GradientInterceptLine(5.0,3.0);
    incidentPointCalculator.calculate(firstLine,secondLine);
  }

  @Test
  public void interceptorOnAbscissa()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(1.0,1.0);
    GradientInterceptLine secondLine = new GradientInterceptLine(-2.0,-2.0);
    assertThat(incidentPointCalculator.calculate(firstLine,secondLine), is(new Point(-1.0, 0.0)));
  }


}
