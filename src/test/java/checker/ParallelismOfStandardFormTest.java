package checker;

import gradient.GradientCalculatorStrategy;
import gradient.GradientCalculatorStrategyStandardLine;
import domain.Point;
import domain.line.StandardLine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParallelismOfStandardFormTest
{
  private CheckerParallelism<StandardLine> checkerParallelism;

  @Before
  public void setUp()
  {
    GradientCalculatorStrategy<StandardLine> gradientCalculatorStrategy =
      new GradientCalculatorStrategyStandardLine();
    checkerParallelism = new CheckerParallelism<>(gradientCalculatorStrategy);
  }

  @Test
  public void parallelismInFirstQuadrant()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    Point c = new Point(2d, 3d);
    Point d = new Point(4d, 6d);

    assertTrue(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInFirstQuadrant()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(3d, 6d);
    Point c = new Point(0d, 3d);
    Point d = new Point(4d, 5d);

    assertFalse(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInSecondQuadrant()
  {
    Point a = new Point(-2d, 3d);
    Point b = new Point(-44d, 6d);
    Point c = new Point(-0.2d, 3d);
    Point d = new Point(-2.4d, 6d);

    assertFalse(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInSecondQuadrant()
  {
    Point a = new Point(-2d, 3d);
    Point b = new Point(-4d, 6d);
    Point c = new Point(-2.2d, 3d);
    Point d = new Point(-4.2d, 6d);

    assertTrue(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInThirdQuadrant()
  {
    Point a = new Point(-2d, -3d);
    Point b = new Point(-4d, -6d);
    Point c = new Point(-2.2d, -3d);
    Point d = new Point(-4.2d, -6d);

    assertTrue(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInThirdQuadrant()
  {
    Point a = new Point(-2d, -3d);
    Point b = new Point(-0.4d, -6d);
    Point c = new Point(-2.2d, -3d);
    Point d = new Point(-4.2d, -6d);

    assertFalse(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInFourthQuadrant()
  {
    Point a = new Point(2d, -3d);
    Point b = new Point(4d, -6d);
    Point c = new Point(2.2d, -3d);
    Point d = new Point(4.2d, -6d);

    assertTrue(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInFourthQuadrant()
  {
    Point a = new Point(2d, -3d);
    Point b = new Point(4d, -6d);
    Point c = new Point(2.2d, -3.4d);
    Point d = new Point(4.2d, -6.5d);

    assertFalse(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismOfTwoLinesOnAbscissa()
  {
    Point a = new Point(2d, 0d);
    Point b = new Point(4d, 0d);
    Point c = new Point(2.2d, 0d);
    Point d = new Point(4.2d, 0d);
    assertFalse("Two parallel line are never incident",
      checkerParallelism.areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInTwoDifferentQuadrant()
  {
    Point a = new Point(2d, 24d);
    Point b = new Point(4d, 0.3d);
    Point c = new Point(-2d, -24d);
    Point d = new Point(-4d, -0.3d);

    assertTrue(checkerParallelism
      .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismOfTwoLineOnOrdinate()
  {
    Point a = new Point(0d, 2d);
    Point b = new Point(0d, 4d);
    Point c = new Point(0d, -2d);
    Point d = new Point(0d, -4d);
    assertFalse("The values of Gradients are -Infinity and +Infinity ",
      checkerParallelism
        .areParallel(new StandardLine(a, b), new StandardLine(c, d)));
  }

}
