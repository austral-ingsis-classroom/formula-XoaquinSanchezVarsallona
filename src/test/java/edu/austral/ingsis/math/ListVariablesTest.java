package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operation.*;
import edu.austral.ingsis.math.value.Const;
import edu.austral.ingsis.math.value.Variable;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {

    final Function sum = new Sum(new Const(1), new Const(6));
    final SimpleFunctions function = new SimpleFunctions(List.of(sum));
    List<String> res = function.getVariables();
    assertThat(res, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Function div = new Div(new Const(1), new Variable("div", 1));
    final SimpleFunctions function = new SimpleFunctions(List.of(div));
    List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function div = new Div(new Const(9), new Variable("x", 1));
    Function mult = new Mult(div, new Variable("y", 1));
    SimpleFunctions function = new SimpleFunctions(List.of(mult));
    List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function div = new Div(new Const(27), new Variable("a", 1));
    Function pow = new Pow(div, new Variable("b", 1));
    SimpleFunctions function = new SimpleFunctions(List.of(pow));
    List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function pow = new Pow(new Variable("z", 1), new Div(new Const(1), new Const(2)));
    SimpleFunctions function = new SimpleFunctions(List.of(pow));
    List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function module = new Abs(new Variable("value", 1));
    Function sub = new Sub(module, new Const(8));
    SimpleFunctions function = new SimpleFunctions(List.of(sub));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function module = new Abs(new Variable("value", 1));
    Function sub = new Sub(module, new Const(8));
    SimpleFunctions function = new SimpleFunctions(List.of(sub));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function sub = new Sub(new Const(5), new Variable("i", 1));
    Function mult = new Mult(sub, new Const(8));
    SimpleFunctions function = new SimpleFunctions(List.of(mult));
    List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
