package checker;

import domain.Point;
import domain.line.GradientInterceptLine;
import domain.line.StandardLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IncidenceOfMixLine
{
  private CheckerIncidence checkerIncidence = new CheckerIncidence();

  @Test
  public void checkIncidence()
  {
    GradientInterceptLine gradientInterceptLine = new GradientInterceptLine(1.0,0.0);
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    StandardLine standardLine = new StandardLine(a,b);
    assertTrue(checkerIncidence.areIncident(gradientInterceptLine,standardLine));
  }

  @Test
  public void checkNotIncidence()
  {
    GradientInterceptLine gradientInterceptLine = new GradientInterceptLine(1.0,0.0);
    Point a = new Point(2d, 4d);
    Point b = new Point(4d, 6d);
    StandardLine standardLine = new StandardLine(a,b);
    assertFalse(checkerIncidence.areIncident(gradientInterceptLine,standardLine));
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkNullValueForStandardLine()
  {
    GradientInterceptLine gradientInterceptLine = new GradientInterceptLine(1.0,0.0);
    Point a = new Point(2d, null);
    Point b = new Point(4d, 6d);
    StandardLine standardLine = new StandardLine(a,b);
    checkerIncidence.areIncident(gradientInterceptLine,standardLine);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkNullValueForGradientLine()
  {
    GradientInterceptLine gradientInterceptLine = new GradientInterceptLine(null,0.0);
    Point a = new Point(2d, 4d);
    Point b = new Point(4d, 6d);
    StandardLine standardLine = new StandardLine(a,b);
    checkerIncidence.areIncident(gradientInterceptLine,standardLine);
  }

}
