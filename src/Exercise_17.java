/*
Write a function that combines two lists by alternatingly taking elements,
e.g. [a,b,c], [1,2,3] => [a,1,b,2,c,3].

 */

import java.util.ArrayList;
import java.util.List;

public class Exercise_17 {

    public static void main(String[] args) {
        List<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('b');
        list1.add('c');

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        List<Object> combinedList = combineLists(list1, list2);
        System.out.println(combinedList); // Output: [a, 1, b, 2, c, 3]
    }

    private static List<Object> combineLists(List<?> list1, List<?> list2) {
        List<Object> combinedList = new ArrayList<>();
        int size = Math.min(list1.size(), list2.size());

        for (int i = 0; i < size; i++) {
            combinedList.add(list1.get(i));
            combinedList.add(list2.get(i));
        }

        // Add remaining elements from the longer list, if any
        if (list1.size() > size) {
            combinedList.addAll(list1.subList(size, list1.size()));
        } else if (list2.size() > size) {
            combinedList.addAll(list2.subList(size, list2.size()));
        }

        return combinedList;
    }
}
