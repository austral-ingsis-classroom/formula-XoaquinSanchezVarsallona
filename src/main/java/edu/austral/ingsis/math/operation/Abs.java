package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;

public class Abs implements Operators {
  private final Function value;

  public Abs(Function value) {
    this.value = value;
  }

  @Override
  public double execute() {
    return Math.abs(value.execute());
  }

  @Override
  public List<String> getVariables() {
    return new ArrayList<>(value.getVariables());
  }

  public String toString() {
    return "|" + value.toString() + "|";
  }
}
