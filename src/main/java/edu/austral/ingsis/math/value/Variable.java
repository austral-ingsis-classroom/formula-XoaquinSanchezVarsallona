package edu.austral.ingsis.math.value;

import java.util.List;

public class Variable implements Value {
  private final int value;
  private final String name;

  public Variable(String name, int value) {
    this.value = value;
    this.name = name;
  }

  @Override
  public double execute() {
    return value;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public List<String> getVariables() {
    return List.of(name);
  }
}
