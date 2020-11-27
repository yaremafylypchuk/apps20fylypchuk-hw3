package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        LinkedHashSet<Object> decoratedSet = new LinkedHashSet<>(Arrays.asList(
                smartArray.toArray()));
        decoratedArray = decoratedSet.toArray();
    }


    @Override
    public Object[] toArray() {
        return decoratedArray;
    }

    @Override
    public String operationDescription() {
        return "Removing dublicates";
    }

    @Override
    public int size() {
        return decoratedArray.length;
    }
}
