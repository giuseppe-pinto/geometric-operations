package refactoring;

import domain.Point;
import domain.line.GradientInterceptLine;
import domain.line.StandardLine;

public class TestForChecker
{

  public static void main(String[] args)
  {
    CheckerParallelismContext<StandardLine, GradientInterceptLine> checkerParallelismContext;
    checkerParallelismContext = new CheckerParallelismContext<>();

    checkerParallelismContext.apply(
      new StandardLine(new Point(1.0,2.0), new Point(2.0,3.0)),
      new GradientInterceptLine(3.0,0.0));



  }

}
