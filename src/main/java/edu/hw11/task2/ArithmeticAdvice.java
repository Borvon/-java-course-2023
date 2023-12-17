package edu.hw11.task2;

import net.bytebuddy.asm.Advice;

public class ArithmeticAdvice {

    private ArithmeticAdvice() {

    }

    @SuppressWarnings("ParameterAssignment")
    @Advice.OnMethodEnter
    static void replaceWithMultiplication(
        @Advice.Argument(value = 0, readOnly = false) int a,
        @Advice.Argument(value = 1, readOnly = false) int b
    ) {
        a *= b;
        b = 0;
    }
}
