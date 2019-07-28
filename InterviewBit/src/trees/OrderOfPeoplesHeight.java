package trees;

import java.util.*;

/**
 * You are given the following :
 *
 * A positive number N
 * Heights : A list of heights of N persons standing in a queue
 * Infronts : A list of numbers corresponding to each person (P)
 * that gives the number of persons who are taller than P and standing in front of P
 * You need to return list of actual order of persons’s height
 *
 * Consider that heights will be unique
 *
 * Example
 *
 * Input :
 * Heights: 5 3 2 6 1 4
 * InFronts: 0 1 2 0 3 2
 * Output :
 * actual order is: 5 3 2 1 6 4
 * So, you can see that for the person with height 5, there is no one taller
 * than him who is in front of him, and hence Infronts has 0 for him.
 *
 * For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.
 *
 * You can do similar inference for other people in the list.
 */
public class OrderOfPeoplesHeight {
    static class Person {
        int height;
        int inFront;

        public Person(int height, int inFront) {
            this.height = height;
            this.inFront = inFront;
        }
    }

    public static ArrayList<Integer> getCorrectOrder(List<Integer> heights, List<Integer> inFront){
        Person[] people = new Person[heights.size()];
        for (int i = 0; i < people.length; ++i){
            people[i] = new Person(heights.get(i), inFront.get(i));
        }
        Arrays.sort(people, Comparator.comparingInt(p -> p.height));
        Person[] temp = new Person[people.length];
        for (Person person : people){
            int count = 0;
            for (int i = 0; i < people.length; ++i){
                if (count == person.inFront){
                    while (i < people.length && temp[i] != null){
                        ++i;
                    }
                    temp[i] = person;
                    break;
                }
                if (temp[i] == null){
                    ++count;
                }
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        for (Person p : temp)
            results.add(p.height);
        return results;
    }

    public ArrayList<Integer> EditorialSolution(ArrayList<Integer> heights,
                                                ArrayList<Integer> infronts) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int i=0; i<heights.size(); i++) {
            map.put(heights.get(i), infronts.get(i));
        }

        boolean sorted = false;
        while(sorted == false) {
            int height = map.lastKey();
            int taller = map.get(height);
            map.remove(height);


            if (result.isEmpty()){
                result.add(height);
            } else if (taller == 0) {
                result.add(0,height);
            } else {
                result.add(taller,height);
            }
            if (map.isEmpty()) sorted = true;
        }

        return result;
    }

    public static void main(String[] args){
        List<Integer> heights = Arrays.asList(5, 3, 2, 6, 1, 4);
        List<Integer> infront = Arrays.asList(0, 1, 2, 0, 3, 2);
        System.out.println(getCorrectOrder(heights, infront));
    }
}
