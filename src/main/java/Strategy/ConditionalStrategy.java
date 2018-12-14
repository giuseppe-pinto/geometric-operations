package Strategy;


import domain.Point;

public interface ConditionalStrategy<T>
{
  boolean areParallel(T firstLine, T secondLine);

  boolean arePerpendicular(T firstLine, T secondLine);

  Point areIncident(T firstLine, T secondLine);
}
