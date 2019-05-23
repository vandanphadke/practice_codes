package twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwitterAdjChar {

    public static void main(String args[]){
        String[] arr={"add","boook","break"};
        List<String> list= Arrays.asList(arr);
        System.out.println(minimalOperations(list));
    }

    public static List<Integer> minimalOperations(List<String> words){
        List<Integer> res=new ArrayList<>();
        for(String word:words){
            res.add(isSalable(word));
        }
        return res;
    }

    public static Integer isSalable(String word){
        Integer res=0;
        Character prev=word.charAt(0);
        for (int i=1;i<word.length();i++){
            Character curr=word.charAt(i);
            if(prev==curr){
                res++;
                i++;
                if(i<word.length()){
                    prev=word.charAt(i);
                }
                //break;
            }
            prev=curr;
        }
        return res;
    }
}
