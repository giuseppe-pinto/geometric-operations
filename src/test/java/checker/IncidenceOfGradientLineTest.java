package checker;

import domain.line.GradientInterceptLine;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IncidenceOfGradientLineTest
{
  private CheckerIncidence checkerIncidence = new CheckerIncidence();

  @Test
  public void incidenceForBisectorLines()
  {
    assertTrue(checkerIncidence
      .areIncident(new GradientInterceptLine(1.0, 0d), new GradientInterceptLine(-1.0, 0.0)));
  }

  @Test
  public void checkNotIncidence()
  {
    assertFalse(checkerIncidence
      .areIncident(new GradientInterceptLine(13.0, 0d), new GradientInterceptLine(13.0, 0.0)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void incidenceWithNullValueAsGradient()
  {
    checkerIncidence.areIncident(new GradientInterceptLine(0.0,0.0), new GradientInterceptLine(null,0.0));
  }

}
