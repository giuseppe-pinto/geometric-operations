package checker;

import domain.line.GradientInterceptLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PerpendicularityOfGradientLineFormTest
{
  CheckerPerpendicularity checkerPerpendicularity = new CheckerPerpendicularity();

  @Test
  public void checkNotPerpendicularity()
  {
    assertFalse(checkerPerpendicularity.arePerpendicular(
      new GradientInterceptLine(-2.0,0d), new GradientInterceptLine(2.0,0.0)));
  }

  @Test
  public void checkPerpendicularity()
  {
    assertTrue(checkerPerpendicularity.arePerpendicular(
      new GradientInterceptLine(-2.0,0d), new GradientInterceptLine(0.5,0.0)));
  }

  @Test
  public void twoOrthogonalLines(){
    assertTrue(checkerPerpendicularity.arePerpendicular(
      new GradientInterceptLine(Double.POSITIVE_INFINITY, 12.0),
      new GradientInterceptLine(0.0,9.0)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullValueForFirstGradient()
  {
    checkerPerpendicularity.arePerpendicular(
      new GradientInterceptLine(null,0d), new GradientInterceptLine(0.5,0.0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullValueFoSecondGradient()
  {
    checkerPerpendicularity.arePerpendicular(
      new GradientInterceptLine(-2.0,0d), new GradientInterceptLine(null,0.0));
  }
}
