package ua.edu.ucu.smartarr;


import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] array;

    public BaseArray(Object[] input) {
        this.array = Arrays.copyOf(input, input.length);
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String operationDescription() {
        return "No operation applied";
    }

    @Override
    public int size() {
        return array.length;
    }
}
