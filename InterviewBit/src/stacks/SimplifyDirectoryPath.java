package stacks;

import java.util.Stack;

/**
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * Examples:
 *
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Note that absolute path always begin with ‘/’ ( root directory )
 * Path will not have whitespace characters.
 *
 */
public class SimplifyDirectoryPath {

    public static void main(String[] args){
        System.out.println(getSimplifiedDirectoryPath("/a/./b/../../c/"));
        System.out.println(getSimplifiedDirectoryPath("/home"));
    }


    public static String getSimplifiedDirectoryPath(String path){
        String[] pathArr = path.split("/");
        Stack<String> dirStack = new Stack<>();
        for (int i = 1; i < pathArr.length; ++i) {
            String directory = pathArr[i];
            if(directory.equals("..")){
                if (!dirStack.isEmpty())
                    dirStack.pop();
            }
            else if (directory.equals(".") || directory.equals("")){
                continue;
            }
            else {
                dirStack.push(directory);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (dirStack.isEmpty())
            return "/";
        else {
            while (!dirStack.isEmpty()){
                sb.insert(0, dirStack.pop());
                sb.insert(0, "/");
            }

            return sb.toString();
        }
    }

}
