package refactoring;

import domain.line.GradientInterceptLine;
import domain.line.StandardLine;

import java.util.Objects;
import java.util.function.BiFunction;

public class CheckerParallelismContext<T,U> implements BiFunction<T,U,Boolean>
{
  /*
 * Utilizzando questo tipo di checker cade il condetto di Line come interface.
 * Potendo quindi utilizzare solo le classi specifiche. In questo modo è il checker che si
 * occupa di instanziare il calculator giusto in base ai generics che gli arrivano in ingresso.
 *
 * */

  @Override
  public Boolean apply(T firstLine, U secondLine){

    if(firstLine.equals(secondLine)){
      return false;
    }

    Double firstGradient = firstLine instanceof StandardLine ?
      new CalculatorGradientStrategyStandard().calculate((StandardLine) firstLine) :
      new CalculatorGradientStrategyInterceptor().calculate((GradientInterceptLine) firstLine);

    Double secondGradient = secondLine instanceof StandardLine ?
      new CalculatorGradientStrategyStandard().calculate((StandardLine) secondLine) :
      new CalculatorGradientStrategyInterceptor().calculate((GradientInterceptLine) secondLine);

    return areNotCoincident(firstGradient, secondGradient)
      && Objects.equals(firstGradient, secondGradient);
  }

  private boolean areNotCoincident(Double firstGradient, Double secondGradient)
  {
    return !firstGradient.equals(0d) || !secondGradient.equals(0d);
  }

}
