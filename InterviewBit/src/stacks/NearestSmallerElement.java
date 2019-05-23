package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element
 * A[i] in the array such that the element has an index smaller than i.
 *
 * More formally,
 *
 * G[i] for an element A[i] = an element A[j] such that
 *     j is maximum possible AND
 *     j < i AND
 *     A[j] < A[i]
 *
 * Elements for which no smaller element exist, consider next smaller element as -1.
 *
 * Example:
 *
 * Input : A : [4, 5, 2, 10, 8]
 * Return : [-1, 4, -1, 2, 2]
 *
 * Example 2:
 *
 * Input : A : [3, 2, 1]
 * Return : [-1, -1, -1]
 */
public class NearestSmallerElement {

    public List<Integer> getNearestElement(List<Integer> numbers){
        Stack<Integer> smallerStack = new Stack<>();
        List<Integer> results = new ArrayList<>();

        for (int number: numbers){
            while (!smallerStack.isEmpty() && smallerStack.peek() > number)
                smallerStack.pop();

            if (smallerStack.isEmpty()) results.add(-1);
            else    results.add(smallerStack.peek());

            smallerStack.push(number);
        }

        return results;
    }
}
