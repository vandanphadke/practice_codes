import java.util.ArrayList;


public class PrimsMSTAlgo {
	
	public static void PrimsAlgo(GraphAdjListUndirected graph){
		int max_vertices = graph.getNoofVertices();
		ArrayList<Integer> settled = new ArrayList<Integer>();
		ArrayList<Integer> unsettled = new ArrayList<Integer>();
		int weight = 0 ; 
		//Considering 0 as the source vertex
		settled.add(0);
		for(int i = 1 ; i < 5 ; i++)
			unsettled.add(i);
		
		for(int i = 0 ; i < max_vertices - 1 ; i++){
			System.out.println("Settled" + settled);
			System.out.println("UnSettled" + unsettled);
			int min_edge = Integer.MAX_VALUE;
			int min_weight = Integer.MAX_VALUE;
			for(int src: settled){
				for(Edge edge: graph.getEdges(src)){
					if(edge.getWeight() < min_weight && unsettled.contains(edge.getDestination())){
						min_edge = edge.getDestination();
						min_weight = edge.getWeight();
					}
				}
			}
			weight+=min_weight;
			for(int k = 0 ; k < unsettled.size(); k++)
				if(unsettled.get(k) == min_edge)
					unsettled.remove(k);
			settled.add(min_edge);
		}
		System.out.println(weight);
	}
}
