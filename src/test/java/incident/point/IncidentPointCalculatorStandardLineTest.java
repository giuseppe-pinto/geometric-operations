package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.StandardLine;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IncidentPointCalculatorStandardLineTest
{

  private IncidentPointCalculator incidentPointCalculator;

  @Before
  public void setUp()
  {
    CheckerIncidence checkerIncidence = new CheckerIncidence();
    incidentPointCalculator = new IncidentPointCalculator(checkerIncidence);
  }

  @Test
  public void incidentPointOnFirstQuadrant()
  {
    Point a = new Point(0d, 0d);
    Point b = new Point(2d, 2d);
    Point c = new Point(0d, 3d);
    Point d = new Point(1d, 1d);

    assertThat(incidentPointCalculator
      .calculate(new StandardLine(a,b), new StandardLine(c,d)), is(new Point(1.0,1.0)));
  }

  @Test
  public void incidentPointInFourthQuadrant()
  {
    Point a = new Point(2d, 0d);
    Point b = new Point(6d, -2d);
    Point c = new Point(2d, -2d);
    Point d = new Point(6d, -3d);

    assertThat(incidentPointCalculator
      .calculate(new StandardLine(a,b), new StandardLine(c,d)), is(new Point(10.0,-4.0)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void incidentPointForParallelLines()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    Point c = new Point(4d, 6d);
    Point d = new Point(8d, 12d);
    incidentPointCalculator.calculate(new StandardLine(a,b), new StandardLine(c,d));
  }

  @Test
  public void incidentPointInOriginForBisectorLine()
  {
    Point a = new Point(1d, 1d);
    Point b = new Point(-1d, -1d);
    Point c = new Point(-1d, 1d);
    Point d = new Point(1d, -1d);

    assertThat(incidentPointCalculator
      .calculate(new StandardLine(a,b), new StandardLine(c,d)), is(new Point(0.0,0.0)));
  }
}
