/*
 * This class acts as a node for various graph algorithms
 */
public class node implements Comparable<node>{

	int id; // The node number that this node links to or its own node number
	
	int cost; //cost of the edge
	
	node (int id,int cost)
	{
		this.id=id;
		this.cost=cost;
	}

	@Override
	public int compareTo(node o) {
		
		return ((new Integer(cost).compareTo(new Integer(o.cost))));

	}
	
	
}
