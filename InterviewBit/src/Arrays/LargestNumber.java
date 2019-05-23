package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyInt implements Comparable<MyInt> {

    int number;

    public MyInt(int no){
        this.number = no;
    }

    @Override
    public int compareTo(MyInt myInt) {
        String a = this.number + "";
        String b = myInt.number + "";
        return (a+b).compareTo(b+a);
    }

    // FAILED ATTEMPT
//    @Override
//    public int compareTo(MyInt myInt) {
//        String str1 = this.number + "";
//        String str2 = myInt.number + "";
//        int i = 0, j = 0;
//
//        while (i < str1.length() && j < str2.length()){
//            if (str1.charAt(i) != str2.charAt(j)){
//                if (str1.charAt(i) > str2.charAt(j))
//                    return 1;
//                else
//                    return -1;
//            }
//            ++i;
//            ++j;
//        }
//
//        if (i == str1.length()){
//            System.out.println(i + "  " + j);
//            while (j <= str2.length()){
//                if (str1.charAt(i - 1) > str2.charAt(j - 1))
//                    return 1;
//                else if (str1.charAt(i - 1) < str2.charAt(j - 1))
//                    return -1;
//                else
//                    ++j;
//            }
//        }
//        else {
//            while (i <= str1.length()){
//                if (str1.charAt(i - 1) > str2.charAt(j - 1))
//                    return 1;
//                else if (str1.charAt(i - 1) < str2.charAt(j - 1))
//                    return -1;
//                else
//                    ++i;
//            }
//        }
//
//        return 0;
//    }
}


public class LargestNumber {
    public static void main(String[] args){
        List<Integer> test = new ArrayList<>();
        test.add(3);test.add(30);test.add(34);test.add(5);test.add(9);
        System.out.println(getLargestNumber(test));
    }

    public static String getLargestNumber(List<Integer> nums){
        MyInt[] numArr = new MyInt[nums.size()];
        int i = 0;
        for (int num: nums){
            numArr[i] = new MyInt(num);
            ++i;
        }
        Arrays.sort(numArr);
        StringBuilder sb = new StringBuilder();
        for (int j = numArr.length-1; j >= 0; --j){
            sb.append(numArr[j].number);
        }
        return sb.toString();
    }

}
