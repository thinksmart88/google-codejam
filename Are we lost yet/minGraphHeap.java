import java.util.PriorityQueue;

/*
 * This class is a datastucture for storing nodes of a graph in a heap fashion
 * Minimum node first
 */
public class minGraphHeap {
	PriorityQueue<node> heap = new PriorityQueue<node>();
	
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
