package edu.hw10.task2;

import java.lang.reflect.Method;

interface CacheHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
