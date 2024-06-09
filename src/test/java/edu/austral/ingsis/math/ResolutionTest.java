package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operation.*;
import edu.austral.ingsis.math.value.Const;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Function sum = new Sum(new Const(1), new Const(6));
    final SimpleFunctions function = new SimpleFunctions(List.of(sum));
    Double result = function.execute();
    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Function div = new Div(new Const(12), new Const(2));
    final SimpleFunctions function = new SimpleFunctions(List.of(div));
    Double result = function.execute();
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Function div = new Div(new Const(9), new Const(2));
    Function mult = new Mult(div, new Const(3));
    final SimpleFunctions function = new SimpleFunctions(List.of(mult));
    Double result = function.execute();
    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Function div = new Div(new Const(27), new Const(6));
    Function pow = new Pow(div, new Const(2));
    final SimpleFunctions function = new SimpleFunctions(List.of(pow));
    Double result = function.execute();

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function div = new Div(new Const(1), new Const(2));
    Function mult = new Pow(new Const(36), div);
    SimpleFunctions function = new SimpleFunctions(List.of(mult));
    Double result = function.execute();
    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function abs = new Abs(new Const(136));
    SimpleFunctions function = new SimpleFunctions(List.of(abs));
    Double result = function.execute();
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function abs = new Abs(new Const(-136));
    SimpleFunctions function = new SimpleFunctions(List.of(abs));
    Double result = function.execute();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function sub = new Sub(new Const(5), new Const(5));
    Function mult = new Mult(sub, new Const(8));
    SimpleFunctions function = new SimpleFunctions(List.of(mult));
    Double result = function.execute();

    assertThat(result, equalTo(0d));
  }
}
