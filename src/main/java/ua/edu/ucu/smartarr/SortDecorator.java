package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;


import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator myComparator;

    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(smartArray);
        this.myComparator = myComparator;
        decoratedArray = compare();
    }

    public Object[] compare() {
        Object[] newArr = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        Arrays.sort(newArr, myComparator);
        return newArr;
    }

    @Override
    public String operationDescription() {
        return "Sorting";
    }
}
