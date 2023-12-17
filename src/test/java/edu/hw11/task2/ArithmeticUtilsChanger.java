package edu.hw11.task2;

import edu.hw11.task1.HelloWorld;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static net.bytebuddy.dynamic.loading.ByteArrayClassLoader.load;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticUtilsChanger {

    @Test
    void test() {
        //Перед отправкой увидел в беседе более адекватный вариант (через redefine), но так как сам до него не додумался, оставлю то что есть
        try (DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum"))
            .intercept(Advice.to(ArithmeticAdvice.class))
            .make()) {

            Class<?> loadedClass = dynamicType
                .load(ArithmeticUtils.class.getClassLoader())
                .getLoaded();

            Constructor<?> constructor = loadedClass.getDeclaredConstructor();
            Object instance = constructor.newInstance();

            Method sumMethod = loadedClass.getDeclaredMethod("sum", int.class, int.class);

            assertThat((int) sumMethod.invoke(instance, 4, 5)).isEqualTo(20);

        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
