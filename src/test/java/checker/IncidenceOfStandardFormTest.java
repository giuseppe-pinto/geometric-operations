package checker;

import domain.Point;
import domain.line.StandardLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IncidenceOfStandardFormTest
{
  private CheckerIncidence checkerIncidence = new CheckerIncidence();

  @Test
  public void incidenceOfTwoLines()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 7d);
    Point c = new Point(2d, 3d);
    Point d = new Point(1d, 5d);

    assertTrue(checkerIncidence
      .areIncident(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void twoLinesParallelAreNotIncident()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    Point c = new Point(2d, 3d);
    Point d = new Point(4d, 6d);

    assertFalse("The lines are parallel", checkerIncidence
      .areIncident(new StandardLine(a, b), new StandardLine(c, d)));

  }

  @Test
  public void twoPerpendicularLinesAreIncident()
  {
    Point a = new Point(-4d, 8d);
    Point b = new Point(-2d, 6d);
    Point c = new Point(-2d, 8d);
    Point d = new Point(-4d, 6d);

    assertTrue(checkerIncidence
      .areIncident(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void incidenceWithAlineOnAbscissaAndAlineOnOrdinate()
  {
    Point a = new Point(4d, 0d);
    Point b = new Point(2d, 0d);
    Point c = new Point(0d, 8d);
    Point d = new Point(0d, 6d);

    assertTrue(checkerIncidence
      .areIncident(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void incidenceForBisectorLines()
  {
    Point a = new Point(1d, 1d);
    Point b = new Point(-1d, -1d);
    Point c = new Point(-1d, 1d);
    Point d = new Point(1d, -1d);

    assertTrue(checkerIncidence
      .areIncident(new StandardLine(a,b), new StandardLine(c,d)));
  }



}