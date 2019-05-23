
public class Edge implements Comparable<Edge>{
		int destination;
		int weight;
	
		public Edge(int destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}
		
		public int getDestination() {
			return destination;
		}
		public void setDestination(int destination) {
			this.destination = destination;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}

	@Override
	public int compareTo(Edge edge) {
		return (this.weight - edge.weight);
	}
}
