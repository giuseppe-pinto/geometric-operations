package StandardForm;

import Strategy.ConditionalContext;
import Strategy.StandardConditionalStrategy;
import domain.Point;
import domain.line.StandardLine;
import org.junit.Before;
import org.junit.Test;

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

    StandardLine firstLine = new StandardLine(a, b);
    StandardLine secondLine = new StandardLine(c, d);

    assertTrue(conditionalContext.checkParallelism(firstLine, secondLine));
  }
}
