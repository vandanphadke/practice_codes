import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class NodeLevel {
    String number;
    int level;

    public NodeLevel(String no, int l){
        this.number = no;
        this.level = l;
    }
}

public class OpenTheLock {

    public static int openLock(String[] deadends, String target) {
        Set<String> deadEndsSet = new HashSet<>();
        for (String deadend : deadends) {
            deadEndsSet.add(deadend);
        }

        Queue<NodeLevel> bfsQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        bfsQueue.add(new NodeLevel("0000", 0));
        visited.add("0000");
        String newStr = "";

        while(!bfsQueue.isEmpty()){

            NodeLevel current = bfsQueue.poll();
            String combination = current.number;
            int currentLevel = current.level;
            //System.out.println(combination + "  " + currentLevel);
            if (combination.equals(target))
                return current.level;
            else if (deadEndsSet.contains(combination))
                continue;
            else {
                for (int i = 3; i >= 0; --i){
                    char no = combination.charAt(i);
                    if (no != '9'){
                        newStr = combination.substring(0, i) + (char)(no + 1) + combination.substring(i+1);
                    }
                    else {
                        newStr = combination.substring(0, i) + '0' + combination.substring(i+1);
                    }
                    if (!visited.contains(newStr)){
                        bfsQueue.add(new NodeLevel(newStr, currentLevel + 1));
                        visited.add(newStr);
                    }

                    if (no != '0'){
                        newStr = combination.substring(0, i) + (char)(no - 1) + combination.substring(i+1);
                    }
                    else {
                        newStr = combination.substring(0, i) + '9' + combination.substring(i+1);
                    }
                    if (!visited.contains(newStr)){
                        bfsQueue.add(new NodeLevel(newStr, currentLevel + 1));
                        visited.add(newStr);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        String[] ends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(ends, target));
    }
}
