package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operation.*;
import edu.austral.ingsis.math.value.Const;
import edu.austral.ingsis.math.value.Variable;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function sum = new Sum(new Const(1), new Variable("x", 3));
    SimpleFunctions function = new SimpleFunctions(List.of(sum));
    Double result = function.execute();
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Function div = new Div(new Const(12), new Variable("div", 4));
    final SimpleFunctions function = new SimpleFunctions(List.of(div));
    Double result = function.execute();
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function div = new Div(new Const(9), new Variable("x", 3));
    Function mult = new Mult(div, new Variable("y", 4));
    SimpleFunctions function = new SimpleFunctions(List.of(mult));
    Double result = function.execute();
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function div = new Div(new Const(27), new Variable("a", 9));
    Function pow = new Pow(div, new Variable("b", 3));
    SimpleFunctions function = new SimpleFunctions(List.of(pow));
    Double result = function.execute();

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function pow = new Pow(new Variable("z", 36), new Div(new Const(1), new Const(2)));
    SimpleFunctions function = new SimpleFunctions(List.of(pow));
    Double result = function.execute();

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function module = new Abs(new Variable("value", 8));
    Function sub = new Sub(module, new Const(8));
    SimpleFunctions function = new SimpleFunctions(List.of(sub));
    Double result = function.execute();
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Function module = new Abs(new Variable("value", 8));
    Function sub = new Sub(module, new Const(8));
    SimpleFunctions function = new SimpleFunctions(List.of(sub));
    Double result = function.execute();

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function sub = new Sub(new Const(5), new Variable("i", 2));
    Function mult = new Mult(sub, new Const(8));
    SimpleFunctions function = new SimpleFunctions(List.of(mult));
    Double result = function.execute();

    assertThat(result, equalTo(24d));
  }
}
