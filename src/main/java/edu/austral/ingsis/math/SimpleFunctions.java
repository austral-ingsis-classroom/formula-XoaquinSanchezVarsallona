package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;

public class SimpleFunctions implements Function {
  private List<Function> functions;

  public SimpleFunctions(List<Function> functions) {
    this.functions = functions;
  }

  @Override
  public double execute() {
    double total = 0;
    for (Function function : functions) {
      total += function.execute();
    }
    return total;
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>();
    for (Function function : functions) {
      variables.addAll(function.getVariables());
    }
    return variables;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (Function function : functions) {
      builder.append(function.toString());
    }
    return builder.toString();
  }
}
