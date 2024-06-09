package edu.austral.ingsis.math;

import java.util.List;

public interface Function {

  double execute();

  String toString();

  List<String> getVariables();
}
