package edu.hw10.task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<Method, Map<List<Object>, Object>> cache;

    private CacheProxy(Object target) {
        this.target = target;
        this.cache = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(Object target, Class<?> targetInterface) {
        return (T) Proxy.newProxyInstance(
            targetInterface.getClassLoader(),
            new Class<?>[] {targetInterface},
            new CacheProxy(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        CacheHandler handler = (proxyObj, proxiedMethod, proxyArgs) -> {
            Object result = proxiedMethod.invoke(target, proxyArgs);
            if (proxiedMethod.isAnnotationPresent(Cache.class)) {
                Cache cacheAnnotation = proxiedMethod.getAnnotation(Cache.class);
                if (cacheAnnotation.persist()) {
                    cache.computeIfAbsent(proxiedMethod, k -> new HashMap<>())
                        .put(Arrays.asList(proxyArgs), result);
                }
            }
            return result;
        };

        if (method.isAnnotationPresent(Cache.class)) {
            Map<List<Object>, Object> methodCache = cache.get(method);
            if (methodCache != null) {
                List<Object> key = Arrays.asList(args);
                if (methodCache.containsKey(key)) {
                    return methodCache.get(key);
                } else {
                    return handler.invoke(proxy, method, args);
                }
            } else {
                return handler.invoke(proxy, method, args);
            }
        } else {
            return handler.invoke(proxy, method, args);
        }
    }
}
