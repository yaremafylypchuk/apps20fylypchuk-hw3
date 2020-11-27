package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final MyPredicate myPredicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.myPredicate = myPredicate;
        decoratedArray = filter();
    }

    public Object[] filter() {
        Object[] newArr = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        ArrayList<Object> temp = new ArrayList<>();
        for (Object o : newArr) {
            if (myPredicate.test(o)) {
                temp.add(o);
            }
        }
        return temp.toArray();
    }


    @Override
    public Object[] toArray() {
        return decoratedArray;
    }

    @Override
    public String operationDescription() {
        return "Filter decorator. Filters array by the given predicate.";
    }

    @Override
    public int size() {
        return decoratedArray.length;
    }
}
