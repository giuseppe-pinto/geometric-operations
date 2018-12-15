package StandardForm;

import Strategy.ConditionalContext;
import Strategy.StandardConditionalStrategy;
import domain.Point;
import domain.line.StandardLine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParallelismOfStandardFormTest
{
  private ConditionalContext<StandardLine> conditionalContext;

  @Before
  public void setUp()
  {
    conditionalContext = new ConditionalContext<>();
    conditionalContext.setConditionalStrategy(new StandardConditionalStrategy());
  }

  @Test
  public void parallelismInFirstQuadrant()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(4d, 6d);
    Point c = new Point(2d, 3d);
    Point d = new Point(4d, 6d);

    assertTrue(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInFirstQuadrant()
  {
    Point a = new Point(2d, 3d);
    Point b = new Point(3d, 6d);
    Point c = new Point(0d, 3d);
    Point d = new Point(4d, 5d);

    assertFalse(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInSecondQuadrant()
  {
    Point a = new Point(-2d, 3d);
    Point b = new Point(-44d, 6d);
    Point c = new Point(-0.2d, 3d);
    Point d = new Point(-2.4d, 6d);

    assertFalse(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInSecondQuadrant()
  {
    Point a = new Point(-2d, 3d);
    Point b = new Point(-4d, 6d);
    Point c = new Point(-2.2d, 3d);
    Point d = new Point(-4.2d, 6d);

    assertTrue(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInThirdQuadrant()
  {
    Point a = new Point(-2d, -3d);
    Point b = new Point(-4d, -6d);
    Point c = new Point(-2.2d, -3d);
    Point d = new Point(-4.2d, -6d);

    assertTrue(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInThirdQuadrant()
  {
    Point a = new Point(-2d, -3d);
    Point b = new Point(-0.4d, -6d);
    Point c = new Point(-2.2d, -3d);
    Point d = new Point(-4.2d, -6d);

    assertFalse(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInFourthQuadrant()
  {
    Point a = new Point(2d, -3d);
    Point b = new Point(4d, -6d);
    Point c = new Point(2.2d, -3d);
    Point d = new Point(4.2d, -6d);

    assertTrue(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void notParallelInFourthQuadrant()
  {
    Point a = new Point(2d, -3d);
    Point b = new Point(4d, -6d);
    Point c = new Point(2.2d, -3.4d);
    Point d = new Point(4.2d, -6.5d);

    assertFalse(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismOfTwoLinesOnAbscissa()
  {
    Point a = new Point(2d, 0d);
    Point b = new Point(4d, 0d);
    Point c = new Point(2.2d, 0d);
    Point d = new Point(4.2d, 0d);

    assertTrue(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }

  @Test
  public void parallelismInTwoDifferentQuadrant()
  {
    Point a = new Point(2d, 24d);
    Point b = new Point(4d, 0.3d);
    Point c = new Point(-2d, -24d);
    Point d = new Point(-4d, -0.3d);

    assertTrue(conditionalContext
      .checkParallelism(new StandardLine(a, b), new StandardLine(c, d)));
  }
}
