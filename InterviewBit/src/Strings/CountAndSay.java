package Strings;

/**
 *
 */
public class CountAndSay {

    public String generateSequence(int n){
        if (n == 1) return "1";
        if (n == 2) return "11";

        String current = "11";

        for (int i = 3; i <=n ;++i){
            char[] currentArr = current.toCharArray();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < currentArr.length; ++j){
                if (currentArr[j] == currentArr[j-1]){
                    ++count;
                }
                else {
                    sb.append(count);
                    sb.append(currentArr[j-1]);
                    count=1;
                }
            }
            sb.append(count);
            sb.append(currentArr[currentArr.length-1]);
            current = sb.toString();
        }
        return current;
    }


}
