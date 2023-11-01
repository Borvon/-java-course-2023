package edu.hw2.task1;

//Task1
public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr value) implements Expr {
        @Override
        public double evaluate() {
            return -value.evaluate();
        }
    }

    public record Exponent(Expr value, int power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(value.evaluate(), power);
        }
    }

    public record Addition(Expr firstSummand, Expr secondSummand) implements Expr {
        @Override
        public double evaluate() {
            return firstSummand.evaluate() + secondSummand.evaluate();
        }

    }

    public record Multiplication(Expr multiplicand, Expr multiplier) implements Expr {
        @Override
        public double evaluate() {
            return multiplicand.evaluate() * multiplier.evaluate();
        }
    }
}
