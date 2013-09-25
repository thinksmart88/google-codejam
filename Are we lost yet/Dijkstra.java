/*
 * This code is used to run Dijskstra's shortest path algorithm between two points. 
 * The alternate function runs for the longest path
 * The node class and graphHeap class is required for this class to run
 * 
 * use function runDijkstra for Dijstra
 * use function reverseDijkstra for max length dijsktra
 * 
 * Note that cost of any edge cannot be negative
 * 
 * @author : Ibrahim Naik
 */

import java.util.ArrayList;
import java.util.BitSet;

/*
 * adjacenyList is an arraylist of an arraylist. Each block is a node. This function runs
 * for shortest path.
 */
public class Dijkstra {

	ArrayList<ArrayList<node>> adjacenyList;
	int start;
	int target;
	ArrayList<Integer> cost;
	BitSet heapCheck;
	minGraphHeap H ;

	public Dijkstra(ArrayList<ArrayList<node>> adjacenyList, int start, int target)
	{
		this.adjacenyList = new ArrayList<ArrayList<node>>();
		this.adjacenyList.addAll(adjacenyList);
		this.start=start;
		this.target=target;
		cost = new ArrayList<Integer>();
		heapCheck = new BitSet(adjacenyList.size());
		for (int i=0;i<adjacenyList.size();i++)
		{
			cost.add(-1);
		}
		heapCheck.clear();
	}

	public int runDijkstra()
	{


		H = new minGraphHeap();

		Update(new node(start,0));

		for (int i=0;;i++)
		{
			if (H.peek()==null)
				break;
			node v = H.poll();
			if (v.cost!=cost.get(v.id))
				i--;
			else
				Update(v);
		}

		return (cost.get(target)) ;
	}

	private void Update(node v) 
	{
		for (int i=0;i<adjacenyList.get(v.id).size();i++)
		{
			node u = adjacenyList.get(v.id).get(i);
			if (cost.get(u.id)==-1)
			{
				cost.set(u.id, u.cost+v.cost);
				u.cost += v.cost;
				H.add(u);
				if (!heapCheck.get(u.id))
				{
					heapCheck.set(u.id);
				}
			}
			else
			{
				if (cost.get(u.id)>(u.cost+v.cost))
				{
					cost.set(u.id, u.cost+v.cost);
					u.cost += v.cost;
					H.add(u);
					if (!heapCheck.get(u.id))
					{
						heapCheck.set(u.id);
					}
				}
			}			
		}		
	}
}
