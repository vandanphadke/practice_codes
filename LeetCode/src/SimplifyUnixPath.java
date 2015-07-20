import java.util.ArrayList;
import java.util.Stack;


public class SimplifyUnixPath {
	
	public static void main(String[] args) {
		String s = "/home//foo/";
		System.out.println(simplifyPath(s));
	}
	
	public static String simplifyPath(String path) {
		
		if(path.equals("/../"))
			return "/";
		
		String[] p = path.trim().split("/");
		Stack<String> st = new Stack<String>();
		Stack<String> st1 = new Stack<String>();
        for(int i = 0 ; i < p.length ; i++){
        	if(p[i].equals("") || p[i].equals("."))
        		continue;
        	else if(p[i].matches("[a-z]*")){
        		st.push(p[i]);
        	}
        	else if(p[i].equals("..")){
        		st.pop();
        	}
        } 
        while(!st.isEmpty())
        	st1.push(st.pop());

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        
        while(!st1.isEmpty()){
        	sb.append(st1.pop());
        	sb.append("/");
        }
        return (sb.toString().substring(0, sb.toString().length() - 1));
    }
}
