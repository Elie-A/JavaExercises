package nonProjects;/*
Write a function that concatenates two lists.
[a,b,c], [1,2,3] => [a,b,c,1,2,3] (without using any classes)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_16 {

    public static void main(String[] args) {
        List<Object> list1 = Arrays.asList("a", "b", "c");
        List<Object> list2 = Arrays.asList(1, 2, 3);

        List<Object> concatenatedList = concatenateLists(list1, list2);

        System.out.println("Concatenated List: " + concatenatedList);
    }

    private static List<Object> concatenateLists(List<Object> list1, List<Object> list2) {
        List<Object> result = new ArrayList<>(list1.size() + list2.size());

        result.addAll(list1);
        result.addAll(list2);

        return result;
    }
}
