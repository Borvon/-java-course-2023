package edu.hw11.task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorld {

    @Test
    void test() {
        try (DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value("Hello, ByteBuddy!"))
            .make()) {

            Class<?> loadedClass = dynamicType.load(HelloWorld.class.getClassLoader())
                .getLoaded();

            Constructor<?> constructor = loadedClass.getDeclaredConstructor();
            Object dynamicObject = constructor.newInstance();

            assertThat(dynamicObject.toString()).isEqualTo("Hello, ByteBuddy!");

        } catch (InvocationTargetException | IllegalAccessException | InstantiationException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
