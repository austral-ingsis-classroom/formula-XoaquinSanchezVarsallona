package edu.austral.ingsis.math.value;

import java.util.List;

public class Const implements Value {
  private final int value;

  public Const(int value) {
    this.value = value;
  }

  @Override
  public double execute() {
    return value;
  }

  @Override
  public List<String> getVariables() {
    return List.of();
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
