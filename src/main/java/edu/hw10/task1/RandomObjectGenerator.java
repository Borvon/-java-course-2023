package edu.hw10.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Random;

public class RandomObjectGenerator {

    private final Random random = new Random();

    public <T> T nextObject(Class<T> clazz) {
        Constructor<T>[] constructors = (Constructor<T>[]) clazz.getDeclaredConstructors();
        Constructor<T> constructor = constructors[random.nextInt(constructors.length)];

        Class<?>[] paramTypes = constructor.getParameterTypes();
        Object[] args = new Object[paramTypes.length];
        Parameter[] parameters = constructor.getParameters();

        for (int i = 0; i < paramTypes.length; i++) {
            args[i] = getRandomValue(paramTypes[i], parameters[i]);
        }

        try {
            return constructor.newInstance(args);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getRandomValue(Class<?> type, Parameter parameter) {
        //Для примера сделал поддержку int, double, string, но можно докинуть любой тип данных
        if (type.equals(int.class) || type.equals(Integer.class)) {
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;

            if (parameter.isAnnotationPresent(Min.class)) {
                min = parameter.getAnnotation(Min.class).value();
            }

            if (parameter.isAnnotationPresent(Max.class)) {
                max = parameter.getAnnotation(Max.class).value();
            }

            return random.nextInt(min, max);
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;

            if (parameter.isAnnotationPresent(Min.class)) {
                min = parameter.getAnnotation(Min.class).value();
            }

            if (parameter.isAnnotationPresent(Max.class)) {
                max = parameter.getAnnotation(Max.class).value();
            }

            return random.nextDouble(min, max);
        } else if (type.equals(String.class)) {
            final int bound = 100;
            String randomString = "RandomString" + random.nextInt(bound);

            return parameter.isAnnotationPresent(NotNull.class) ? randomString
                :
                (random.nextBoolean() ? null : randomString);

        } else {
            return null;
        }
    }

}
