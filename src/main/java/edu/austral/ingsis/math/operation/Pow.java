package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;

public class Pow implements Operators {
  private final Function left;
  private final Function right;

  public Pow(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public double execute() {
    return Math.pow(left.execute(), right.execute());
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>(left.getVariables());
    variables.addAll(right.getVariables());
    return variables;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (left instanceof Operators && !(left instanceof Abs)) {
      sb.append("(");
      sb.append(left.toString());
      sb.append(")");
    } else sb.append(left.toString());

    sb.append(" ^ ");

    if (right instanceof Operators && !(right instanceof Abs)) {
      sb.append("(");
      sb.append(right.toString());
      sb.append(")");
    } else sb.append(right.toString());
    return sb.toString();
  }
}
