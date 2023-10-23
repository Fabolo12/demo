package com.jr.module2.lesson4;

public class Pair<K, V> {
    private final K key;

    private final V value;

    Pair(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }
}

class Triple<K, V, T> extends Pair<K, V> {
    private final T delta;

    Triple(final K key, final V value, final T delta) {
        super(key, value);
        this.delta = delta;
    }

    T getDelta() {
        return delta;
    }
}

class PairCopy<K, V> extends Pair<K, V> {

    PairCopy(final K key, final V value) {
        super(key, value);
    }
}

class StringKeyValue<V> extends Pair<String, V> {

    StringKeyValue(final String key, final V value) {
        super(key, value);
    }
}

class StringInteger extends Pair<String, Integer> {

    StringInteger(final String key, final Integer value) {
        super(key, value);
    }
}

class TripleDelta<T> extends Pair<String, Integer> {

    private final T delta;

    TripleDelta(final String key, final Integer value, final T delta) {
        super(key, value);
        this.delta = delta;
    }
}

interface Copy<S> {
    S copy();
}

class Foo implements Copy<String> {
    @Override
    public String copy() {
        return null;
    }
}
