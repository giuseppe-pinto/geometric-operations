package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.GradientInterceptLine;
import domain.line.StandardLine;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IncidentPointForMixLineTest
{
  private IncidentPointCalculator incidentPointCalculator;

  @Before
  public void setUp()
  {
    CheckerIncidence checkerIncidence = new CheckerIncidence();
    incidentPointCalculator = new IncidentPointCalculator(checkerIncidence);
  }

  @Test
  public void incidentPointInOriginForBisectorLines()
  {
    Point a = new Point(1d, 1d);
    Point b = new Point(-1d, -1d);

    assertThat(incidentPointCalculator
      .calculate(new StandardLine(a,b), new GradientInterceptLine(-1.0,0.0)), is(new Point(0.0,0.0)));
  }

  @Test
  public void checkIncidentAndPoint()
  {
    Point a = new Point(0d, 0d);
    Point b = new Point(2d, 2d);

    assertThat(incidentPointCalculator
      .calculate(new StandardLine(a,b), new GradientInterceptLine(-2.0,3.0)), is(new Point(1.0,1.0)));

  }

  @Test(expected = IllegalArgumentException.class)
  public void nullValueForAPoint()
  {
    Point a = new Point(null, 0d);
    Point b = new Point(2d, 2d);

    incidentPointCalculator
      .calculate(new StandardLine(a,b), new GradientInterceptLine(-2.0,3.0));

  }

  @Test(expected = IllegalArgumentException.class)
  public void nullValueForGradient()
  {
    Point a = new Point(0.0, 0d);
    Point b = new Point(2d, 2d);

    incidentPointCalculator
      .calculate(new StandardLine(a,b), new GradientInterceptLine(null,3.0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkNotIncident()
  {
    Point a = new Point(0d, 0d);
    Point b = new Point(2d, 2d);

    incidentPointCalculator
      .calculate(new StandardLine(a,b), new GradientInterceptLine(1.0,0.0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void incidentPointForParallelLines()
  {
    Point a = new Point(2d, 6d);
    Point b = new Point(4d, 8d);
    incidentPointCalculator
      .calculate(new StandardLine(a,b), new GradientInterceptLine(1.0,10.0));
  }





}
