
import java.util.Scanner;

    public class Warshall{

    	private int distmatrix[ ][ ];
    	private int numberofvertices;
    	public static final int Infinity = 999;

    public Warshall(int numberofvertice){
    	distmatrix= new int[numberofvertices + 1][numberofvertice +1];
    	this.numberofvertices= numberofvertices;
    }

    public void warshall(int adjacencymatrix[][]){
    	for (int source=1; source<= numberofvertices; source++){
    		for ( int destination = 1; destination <= numberofvertices; destination++){	
    			adjacencymatrix [source][destination]=adjacencymatrix[source][destination];
    		}
    	}
    	for(int interm=1; interm<= numberofvertices; interm++){
    		for(int source=1; source<= numberofvertices; source++){
    			for (int destination=1; destination<= numberofvertices; destination++){
    				if(distmatrix[source][interm]+distmatrix[interm] [destination]< distmatrix[source][destination])
    					distmatrix[source][destination] = distmatrix[source][interm]+ distmatrix[interm][destination];
    			}
    		}
    	}

    	for (int source=1; source<= numberofvertices; source++){
    		System.out.print("\t" + source);
    		System.out.println();
    	}
    	
    	for( int source=1; source<= numberofvertices; source++){
    		System.out.print(source + "\t");
    		for( int destination=1; destination <= numberofvertices; destination++){
    			System.out.print(distmatrix[source][destination] + "\t");
    		}    		
    		System.out.println();
    	}
    }

	public static <E> void main( String args[]){
		
	int adjacency_matrix[ ] [ ];
	int numberofvertices;
	Scanner scan= new Scanner(System.in);
	
	
	
	System.out.println("Enter the number of vertices");
	numberofvertices= scan.nextInt();
	adjacency_matrix= new int[numberofvertices+1] [numberofvertices + 1];
	System.out.println(" Enter the weighted matrix of the graph");
		for( int source=1; source <= numberofvertices; source++){
				for(int destination=1; destination<= numberofvertices; destination++){
					adjacency_matrix[source] [destination]= scan.nextInt();
						if(source==destination){
							adjacency_matrix[source][destination]=0;
							continue;
						}
						if(adjacency_matrix[source] [destination] == 0){					
							adjacency_matrix[source][destination]= Infinity;
						}
				}
		}
	System.out.println("The Transitive closure of the graph");
	Warshall warshall= new Warshall(numberofvertices);
	warshall.warshall(adjacency_matrix);
	scan.close();
	}

}
