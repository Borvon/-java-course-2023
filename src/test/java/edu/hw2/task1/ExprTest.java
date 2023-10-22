package edu.hw2.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ExprTest {
    @Test
    @DisplayName("((2+4)*(-1))^2+1 = 37")
    void test() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        assertThat(res.evaluate()).isEqualTo(37);
    }
}
