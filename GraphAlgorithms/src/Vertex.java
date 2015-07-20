public class Vertex{
		private char label;
		public boolean isVisited;
		public Vertex(char l){
			label = l ; 
			this.isVisited = false;
		}
		public void visit() {
			this.isVisited = true; 
		}
		public void displayVertex(){System.out.println(label);}
		
	}
