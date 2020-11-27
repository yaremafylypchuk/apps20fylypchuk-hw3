package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;


import java.util.ArrayList;
import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
        decoratedArray = action();

    }

    public Object[] action() {
        Object[] newArr = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        ArrayList<Object> res = new ArrayList<>();
        for (Object o : newArr) {
            res.add(this.function.apply(o));
        }
        return res.toArray();
    }

    @Override
    public String operationDescription() {
        return "Applying function";
    }
}
