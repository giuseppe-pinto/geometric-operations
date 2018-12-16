package checker;

import domain.Point;
import domain.line.GradientInterceptLine;
import domain.line.StandardLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParallelismOfMixLineTest
{

  private CheckerParallelism checkerParallelism = new CheckerParallelism();

  @Test
  public void checkParallelism()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    StandardLine firstLine = new StandardLine(a,b);
    GradientInterceptLine secondLine = new GradientInterceptLine(1.5,30d);
    assertTrue(checkerParallelism.areParallel(firstLine, secondLine));
  }

  @Test
  public void checkParallelismWithInterceptorZero()
  {
    Point a = new Point(8d, 6d);
    Point b = new Point(6d, 4d);
    StandardLine firstLine = new StandardLine(a,b);
    GradientInterceptLine secondLine = new GradientInterceptLine(1.0,0d);
    assertTrue(checkerParallelism.areParallel(firstLine, secondLine));
  }

  @Test
  public void parallelismWithLineOnAbscissaFirstStandardLineSecondGradientLine()
  {
    Point a = new Point(2d, 0d);
    Point b = new Point(4d, 0d);
    StandardLine firstLine = new StandardLine(a,b);
    GradientInterceptLine secondLine = new GradientInterceptLine(0.0, 0d);
    assertFalse("The two line are coincident",
      checkerParallelism.areParallel(firstLine, secondLine));
  }

  @Test
  public void parallelismWithLineOnAbscissaFirstGradientLineSecondStandardLine()
  {
    GradientInterceptLine firstLine = new GradientInterceptLine(0.0, 0d);
    Point a = new Point(2d, 0d);
    Point b = new Point(4d, 0d);
    StandardLine secondLine = new StandardLine(a,b);
    assertFalse("The two line are coincident",
      checkerParallelism.areParallel(firstLine, secondLine));
  }

  @Test
  public void twoLinesNotParallel()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    StandardLine firstLine = new StandardLine(a,b);
    GradientInterceptLine secondLine = new GradientInterceptLine(3.56d, 0d);
    assertFalse(checkerParallelism.areParallel(firstLine,secondLine));
  }
}
