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
    public Object[] filter(){
        Object[] newArr = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        ArrayList<Object> res = new ArrayList<>();
        for (Object o : newArr) {
            if (myPredicate.test(o)) {
                res.add(o);
            }
        }
        return res.toArray();
    }



    @Override
    public String operationDescription() {
        return "Filter decorator. Filters array by the given predicate.";
    }
}
