package checker;

import domain.Point;
import domain.line.StandardLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PerpendicularityOfStandardFormTest
{
  CheckerPerpendicularity checkerPerpendicularity = new CheckerPerpendicularity();

  @Test
  public void perpendicularityInFirstQuadrant()
  {
    Point a = new Point(4d, 8d);
    Point b = new Point(2d, 6d);
    Point c = new Point(2d, 8d);
    Point d = new Point(4d, 6d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void notPerpendicularInFirstQuadrant()
  {
    Point a = new Point(4d, 8d);
    Point b = new Point(2d, 6d);
    Point c = new Point(4d, 8d);
    Point d = new Point(2d, 6d);

    assertFalse(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }


  @Test
  public void perpendicularityInSecondQuadrant()
  {
    Point a = new Point(-4d, 8d);
    Point b = new Point(-2d, 6d);
    Point c = new Point(-2d, 8d);
    Point d = new Point(-4d, 6d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void notPerpendicularInSecondQuadrant()
  {
    Point a = new Point(-4d, 8d);
    Point b = new Point(-2d, 6d);
    Point c = new Point(-4d, 8d);
    Point d = new Point(-2d, 6d);

    assertFalse(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void perpendicularityInThirdQuadrant()
  {
    Point a = new Point(-4d, -8d);
    Point b = new Point(-2d, -6d);
    Point c = new Point(-2d, -8d);
    Point d = new Point(-4d, -6d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void notPerpendicularInThirdQuadrant()
  {
    Point a = new Point(-4d, -8d);
    Point b = new Point(-2d, -6d);
    Point c = new Point(-4d, -8d);
    Point d = new Point(-2d, -6d);

    assertFalse(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void perpendicularityInFourthQuadrant()
  {
    Point a = new Point(4d, -8d);
    Point b = new Point(2d, -6d);
    Point c = new Point(2d, -8d);
    Point d = new Point(4d, -6d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void notPerpendicularInFourthQuadrant()
  {
    Point a = new Point(4d, -8d);
    Point b = new Point(2d, -6d);
    Point c = new Point(4d, -8d);
    Point d = new Point(2d, -6d);

    assertFalse(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void perpendicularityWIthZeroInAbscissa()
  {

    Point a = new Point(0d, -8d);
    Point b = new Point(0d, -6d);
    Point c = new Point(0d, -8d);
    Point d = new Point(0d, -6d);

   assertFalse(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void perpendicularityWithAlineOnAbscissa()
  {

    Point a = new Point(4d, 0d);
    Point b = new Point(2d, 0d);
    Point c = new Point(2d, 8d);
    Point d = new Point(4d, 6d);

    assertFalse(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void perpendicularityWithAlineOnAbscissaAndAlineOnOrdinate()
  {
    Point a = new Point(4d, 0d);
    Point b = new Point(2d, 0d);
    Point c = new Point(0d, 8d);
    Point d = new Point(0d, 6d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }

  @Test
  public void perpendicularityForBisectorLines()
  {
    Point a = new Point(1d, 1d);
    Point b = new Point(-1d, -1d);
    Point c = new Point(-1d, 1d);
    Point d = new Point(1d, -1d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(new StandardLine(a,b), new StandardLine(c,d)));
  }
}