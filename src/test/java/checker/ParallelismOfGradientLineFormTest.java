package checker;

import domain.line.GradientInterceptLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParallelismOfGradientLineFormTest
{

  private CheckerParallelism checkerParallelism = new CheckerParallelism();

  @Test
  public void checkParallelism()
  {
    assertTrue(checkerParallelism.areParallel(
      new GradientInterceptLine(2.0,6.0),
      new GradientInterceptLine(2.0,78.0)
    ));
  }

  @Test
  public void parallelismOfTwoLinesOnAbscissa()
  {
    assertFalse("The two lines are coincident",
      checkerParallelism.areParallel(
        new GradientInterceptLine(0.0,0.0),
        new GradientInterceptLine(0.0,0.0)));
  }

  @Test
  public void checkNotParallel()
  {
    assertFalse(checkerParallelism.areParallel(
      new GradientInterceptLine(34.0,6.0),
      new GradientInterceptLine(2.0,78.0)
    ));
  }


  @Test(expected = IllegalArgumentException.class)
  public void checkNullValueForFirstGradient()
  {
    checkerParallelism.areParallel(
      new GradientInterceptLine(null,6.0),
      new GradientInterceptLine(2.0,78.0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkNullValueForSecondGradient()
  {
    checkerParallelism.areParallel(
      new GradientInterceptLine(2.0,6.0),
      new GradientInterceptLine(null,78.0));
  }



}
