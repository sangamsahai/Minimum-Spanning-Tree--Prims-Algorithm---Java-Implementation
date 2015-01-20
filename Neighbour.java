
public class Neighbour {

	public int vertexNum;
	public Neighbour next;
	public int weight ;
	
	public Neighbour(int vnum,Neighbour nbr,int weightOfEdge)
	{
		this.vertexNum=vnum;
		this.next=nbr;
		this.weight=weightOfEdge;
	}
}
