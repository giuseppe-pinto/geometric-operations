package Strategy;

import Strategy.gradient.GradientCalculatorForStandardLine;
import Strategy.gradient.GradientCalculator;
import domain.Point;
import domain.line.StandardLine;

import java.util.Objects;

public class StandardConditionalStrategy implements ConditionalStrategy<StandardLine>
{

  private final GradientCalculator<StandardLine> gradientCalculator;

  public StandardConditionalStrategy()
  {
    this.gradientCalculator = new GradientCalculatorForStandardLine();
  }

  @Override
  public boolean areParallel(StandardLine firstLine, StandardLine secondLine)
  {
    return Objects.equals(gradientCalculator.calculate(firstLine),
      gradientCalculator.calculate(secondLine));
  }

  @Override
  public boolean arePerpendicular(StandardLine firstLine, StandardLine secondLine)
  {
    return false;
  }

  @Override
  public Point areIncident(StandardLine firstLine, StandardLine secondLine)
  {
    return null;
  }

}
