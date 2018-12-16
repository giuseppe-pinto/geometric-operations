package checker;

import domain.Point;
import domain.line.GradientInterceptLine;
import domain.line.StandardLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PerpendicularityOfMixLineTest
{
  private CheckerPerpendicularity checkerPerpendicularity = new CheckerPerpendicularity();

  @Test
  public void checkPerpendicularity()
  {
    Point a = new Point(2d, 6d);
    Point b = new Point(4d, 8d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(
        new StandardLine(a,b),
        new GradientInterceptLine(-1.0,1.0)));
  }

  @Test
  public void checkNotPerpendicular()
  {
    Point a = new Point(2d, 6d);
    Point b = new Point(4d, 8d);

    assertFalse(checkerPerpendicularity
      .arePerpendicular(
        new StandardLine(a,b),
        new GradientInterceptLine(1.0,1.0)));
  }

  @Test
  public void perpendicularityForBisectorLines()
  {
    Point a = new Point(1d, 1d);
    Point b = new Point(-1d, -1d);

    assertTrue(checkerPerpendicularity
      .arePerpendicular(
        new StandardLine(a,b),
        new GradientInterceptLine(-1.0,0.0)));
  }


  @Test(expected = IllegalArgumentException.class)
  public void nullValueForAPointOfALine()
  {
    Point a = new Point(null, 6d);
    Point b = new Point(4d, 8d);

    checkerPerpendicularity
      .arePerpendicular(
        new StandardLine(a,b),
        new GradientInterceptLine(1.0,1.0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullValueForGradientOfALine()
  {
    Point a = new Point(0d, 6d);
    Point b = new Point(4d, 8d);

    checkerPerpendicularity
      .arePerpendicular(
        new StandardLine(a,b),
        new GradientInterceptLine(null,1.0));
  }




}
