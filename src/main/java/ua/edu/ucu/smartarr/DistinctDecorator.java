package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        decoratedArray = removeDublicates();
    }
    private Object[] removeDublicates(){
        Object[] newArr = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        ArrayList<Object> res = new ArrayList<>();
        for (Object o : newArr) {
            for (int j = 1; j < newArr.length; j++) {
                if (!o.equals(newArr[j]) && !res.contains(o)) {
                    res.add(o);
                }
            }
        }
        return res.toArray();
    }

    @Override
    public String operationDescription() {
        return "Removing dublicates";
    }
}
