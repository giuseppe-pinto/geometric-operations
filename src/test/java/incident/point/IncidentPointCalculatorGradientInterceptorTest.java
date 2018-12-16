package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.GradientInterceptLine;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IncidentPointCalculatorGradientInterceptorTest
{

  private IncidentPointCalculator incidentPointCalculator;

  @Before
  public void setUp()
  {
    CheckerIncidence checkerIncidence = new CheckerIncidence();
    incidentPointCalculator = new IncidentPointCalculator(checkerIncidence);
  }

  @Test
  public void incidentPointInFirstQuadrant()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(1.0,0d);
    GradientInterceptLine secondLine = new GradientInterceptLine(-2.0,3.0);
    assertThat(incidentPointCalculator.calculate(firstLine, secondLine), is(new Point(1.0,1.0)));
  }

  @Test
  public void incidentPointInFourthQuadrant()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(-1.0/4,-3.0/2);
    GradientInterceptLine secondLine = new GradientInterceptLine(-1.0/2.0,1.0);
    assertThat(incidentPointCalculator.calculate(firstLine, secondLine), is(new Point(10.0,-4.0)));
  }

  @Test(expected = RuntimeException.class)
  public void incidentPointForParallelLines()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(5.0,0d);
    GradientInterceptLine secondLine = new GradientInterceptLine(5.0,3.0);
    incidentPointCalculator.calculate(firstLine,secondLine);
  }

  @Test
  public void incidentPointOnAbscissa()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(1.0,1.0);
    GradientInterceptLine secondLine = new GradientInterceptLine(-2.0,-2.0);
    assertThat(incidentPointCalculator.calculate(firstLine,secondLine), is(new Point(-1.0, 0.0)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void incidentPointForLinesWithNullGradient()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(null,0.0);
    GradientInterceptLine secondLine = new GradientInterceptLine(null,-2.0);
    incidentPointCalculator.calculate(firstLine,secondLine);
  }
}