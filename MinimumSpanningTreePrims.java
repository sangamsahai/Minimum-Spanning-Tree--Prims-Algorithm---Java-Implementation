import java.util.ArrayList;
import java.util.Arrays;




public class MinimumSpanningTreePrims {

	
	
	Graph graph;//this will contain the graph
	int[] valueArray;// This will contain the cost to reach that node .
	int[] parentArray;//This will contain the parent through which we reached this node
	boolean isInFringe[];//This will contain if the node is in the fringe or not
	
	public void getMinimumSpanningTree()
	{
		Vertex startingVertex=graph.adjLists[0];//This will be the starting vertex.This can actually be any vertex of the graph.
		//But I am with the vertex at the Index zero
		
		
		valueArray[0]=0;//Step 1 - setting value=0 for the starting vertex
		isInFringe[0]=false;//removing the first starting node from the fringe
		
		while(isFringeEmpty()==false)	
		{
			Neighbour nbr=startingVertex.adjList;
		//updating the parent and the value array
		while(nbr!=null)
		{
			if((isInFringe[nbr.vertexNum]==true) && valueArray[nbr.vertexNum]>=nbr.weight){
			valueArray[nbr.vertexNum]=nbr.weight;
			parentArray[nbr.vertexNum]=getIndexForName(startingVertex.name);
			}
			nbr=nbr.next;
		}
		
		int indexOfMinumumValueInFringe=getindexOfMinumumValueInFringe();
		printEdge(indexOfMinumumValueInFringe);//printing the edge.. fore example - from A --> B
		isInFringe[indexOfMinumumValueInFringe]=false;
		startingVertex=graph.adjLists[indexOfMinumumValueInFringe];
	}
		
		
	}//end of getMinimumSpanningTree
	
	
	public int getIndexForName(String vertexName)
	{
		for(int i=0;i<graph.adjLists.length;i++)
		{
			if(graph.adjLists[i].name.equals(vertexName))return i;
		}
		return -1;
	}
	
	
	public int getindexOfMinumumValueInFringe()
	{
		int minimumValue=Integer.MAX_VALUE;
		int index_minimumValue=-99;
		for(int i=0;i<valueArray.length;i++)
		{
			
			if((valueArray[i]<minimumValue) && (isInFringe[i]==true))
			{
				minimumValue=valueArray[i];
				index_minimumValue=i;
			}
			
		}
		return index_minimumValue;
	}
	
	public void printEdge(int indexOfMinumumValueInFringe)
	{
		String startOfEdge=graph.adjLists[(parentArray[indexOfMinumumValueInFringe])].name;
		String endOfEdge=graph.adjLists[indexOfMinumumValueInFringe].name;
		System.out.println(startOfEdge+"  --> "+endOfEdge);
	}
	
	
	
	
	public boolean isFringeEmpty()
	{
		for(int i=0;i<isInFringe.length;i++)
		{
			if(isInFringe[i]==true)return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String path="C:\\Users\\sangam\\Desktop\\graph.txt";
		MinimumSpanningTreePrims minimumSpanningTreePrims=new MinimumSpanningTreePrims();
		minimumSpanningTreePrims.graph=new Graph(path);
		int noOfVertex=minimumSpanningTreePrims.graph.adjLists.length;
		minimumSpanningTreePrims.valueArray=new int[noOfVertex];
		minimumSpanningTreePrims.parentArray=new int[noOfVertex];
		minimumSpanningTreePrims.isInFringe=new boolean[noOfVertex];
		Arrays.fill(minimumSpanningTreePrims.isInFringe, true);//Initially all the nodes will be in fringe
		Arrays.fill(minimumSpanningTreePrims.valueArray, Integer.MAX_VALUE);//MAX_VALUE is being out in place of infinity
		Arrays.fill(minimumSpanningTreePrims.parentArray, -99);//All the elements will initially contain -99 initially
		
		minimumSpanningTreePrims.getMinimumSpanningTree();
		
	}
	
	
}
