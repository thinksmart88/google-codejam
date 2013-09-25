import java.util.Collections;
import java.util.PriorityQueue;


/*
 * This class is a datastucture for storing in a heap fashion
 * (maximum node first)
 */
public class maxGraphHeap {
PriorityQueue<node> heap = new PriorityQueue<node>(1,Collections.reverseOrder());
	
	public void add(node a)
	{
		heap.add(a);
	}
	
	public node poll()
	{
		return heap.poll();
	}
	
	public node peek()
	{
		return heap.peek();
	}

}
