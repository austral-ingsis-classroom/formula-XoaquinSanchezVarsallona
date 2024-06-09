package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operation.*;
import edu.austral.ingsis.math.value.Const;
import edu.austral.ingsis.math.value.Variable;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    String expected = "1 + 6";
    final Function sum = new Sum(new Const(1), new Const(6));
    final SimpleFunctions function = new SimpleFunctions(List.of(sum));
    String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final Function div = new Div(new Const(12), new Const(2));
    final SimpleFunctions function = new SimpleFunctions(List.of(div));
    String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final Function div = new Div(new Const(9), new Const(2));
    Function mult = new Mult(div, new Const(3));
    final SimpleFunctions function = new SimpleFunctions(List.of(mult));
    String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final Function div = new Div(new Const(27), new Const(6));
    Function pow = new Pow(div, new Const(2));
    final SimpleFunctions function = new SimpleFunctions(List.of(pow));
    String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    Function abs = new Abs(new Variable("value", 1));
    Function sub = new Sub(abs, new Const(8));
    final SimpleFunctions function = new SimpleFunctions(List.of(sub));
    String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    Function abs = new Abs(new Variable("value", 1));
    Function sub = new Sub(abs, new Const(8));
    final SimpleFunctions function = new SimpleFunctions(List.of(sub));
    String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    Function sub = new Sub(new Const(5), new Variable("i", 1));
    Function mult = new Mult(sub, new Const(8));
    final SimpleFunctions function = new SimpleFunctions(List.of(mult));
    String result = function.toString();
    assertThat(result, equalTo(expected));
  }
}
