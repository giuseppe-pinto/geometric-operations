package checker;

import domain.Point;
import domain.line.GradientInterceptLine;
import domain.line.StandardLine;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CheckerParallelismMixLineTest
{
  @Test
  public void parallelismInFirstQuadrant()
  {
    Point a = new Point(2d, 4d);
    Point b = new Point(4d, 6d);
    StandardLine firstLine = new StandardLine(a,b);
    GradientInterceptLine secondLine = new GradientInterceptLine(1.0,0d);
    CheckerParallelism checkerParallelism = new CheckerParallelism();
    assertTrue(checkerParallelism.areParallel(firstLine, secondLine));
  }
}
