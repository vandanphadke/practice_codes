package Trees;

import java.util.HashMap;

public class HorizontalSum {
	public static void getHorizontalSum(Node root){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		recurseSum(root, map, 0);
		System.out.println(map);
	}
	
	public static void recurseSum(Node root, HashMap<Integer, Integer> map, int dist){
		if(root == null)
			return; 
		
		if(map.containsKey(dist)){
			int sum = map.get(dist);
			sum = sum + root.getKey();
			map.put(dist, sum);
		}
		else{
			map.put(dist, root.getKey());
		}
		
		recurseSum(root.getLeft(), map, dist - 1);
		recurseSum(root.getRight(), map, dist + 1);
	}
}
