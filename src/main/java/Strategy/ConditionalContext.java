package Strategy;

import domain.Point;

public class ConditionalContext<T>
{
  private ConditionalStrategy strategy;

  public void setConditionalStrategy(ConditionalStrategy conditionalStrategy)
  {
    this.strategy = conditionalStrategy;
  }

  public boolean checkParallelism(T firstLine, T secondLine) {
    return strategy.areParallel(firstLine, secondLine);
  }

  public boolean checkPerpendicularity(T firstLine, T secondLine) {
    return strategy.arePerpendicular(firstLine, secondLine);
  }

  public Point checkIfIncident(T firstLine, T secondLine) {
    return strategy.areIncident(firstLine, secondLine);
  }
}
