import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string of numbers and operators,
 * return all possible results from computing
 * all the different possible ways to group
 * numbers and operators.
 *
 * The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DifferentWaysToAddParantheses {
    public List<Integer> diffWaysToCompute(String input) {
        HashMap<String, List<Integer>> memory = new HashMap();
        return numWaysRecursive(input, memory);
    }

    public List<Integer> numWaysRecursive(String input, HashMap<String, List<Integer>> mem){
        if(mem.containsKey(input))
            return mem.get(input);

        List<Integer> result = new ArrayList<Integer>();

        boolean flag = false;

        for(int i = 0; i < input.length(); ++i){
            char current = input.charAt(i);
            if(current == '*' || current == '+' || current == '-'){
                flag = true;
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                List<Integer> leftVals = numWaysRecursive(left, mem);
                List<Integer> rightVals = numWaysRecursive(right, mem);

                for(Integer singleLeftVal: leftVals){
                    for(Integer singleRightVal: rightVals){
                        if(current == '*')
                            result.add(singleLeftVal * singleRightVal);
                        else if(current == '+')
                            result.add(singleLeftVal + singleRightVal);
                        else if(current == '-')
                            result.add(singleLeftVal - singleRightVal);

                    }
                }
            }
        }

        if(!flag)
            result.add(Integer.parseInt(input));

        mem.put(input, result);
        return result;
    }
}
