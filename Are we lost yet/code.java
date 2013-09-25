

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class code {


	public static ArrayList<block> routes;
	public static ArrayList<ArrayList<block>>adjList ;
	//This list is just to run the existing dijkstra with the just the max part of range
	public static ArrayList<block> gPaths; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Scanner fileIP;

		int testCases=0;

		try {
			fileIP =new Scanner(new File("input2.txt"));

			testCases = fileIP.nextInt();

			for (int i=0;i<testCases;i++) //testcases loop
			{
				routes = new ArrayList<block>();
				adjList = new ArrayList<ArrayList<block>>();
				gPaths= new ArrayList<block>();
				//Find the shortest path and shortest max path
				int N= fileIP.nextInt(); //number of cities
				int M = fileIP.nextInt(); //number of routes
				int P= fileIP.nextInt(); //number of routes from MV to London


				for (int j=0;j<N;j++)
					adjList.add(new ArrayList<block>());

				for (int j=0;j<M;j++) // loop for input of routes
				{
					int city1 = fileIP.nextInt()-1;
					int city2 = fileIP.nextInt()-1;
					int lowRange =fileIP.nextInt();
					int highRange = fileIP.nextInt();

					routes.add(new block(j,city1,city2,lowRange,highRange));
					adjList.get(city1).add(new block(j,city1,city2,lowRange,highRange));

				}

				for (int j=0;j<P;j++) // loop for input of routes
				{
					int path = fileIP.nextInt()-1;
					gPaths.add(routes.get(path));
				}

				int badRoute=dijkcheck();

				if (badRoute==-1)
					System.out.println("Looks Good To Me");
				else
					System.out.println(badRoute);







			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no file bro");
		}







	}

	public static ArrayList<Integer> cost ;
	public static BitSet heapCheck;
	public static minGraphHeap H ;

	private static int dijkcheck()
	{
		int start = 0;
		int target = 1;

		cost= new ArrayList<Integer>();
		heapCheck = new BitSet(adjList.size());
		H= new minGraphHeap();


		for (int i=0;i<adjList.size();i++)
		{
			cost.add(-1);
		}
		heapCheck.clear();

		int flag=-1;

		Update(new node(start,0));

		for (int i=0;;i++)
		{
			if (H.peek()==null)
				break;
			node v = H.poll();
			if (v.cost!=cost.get(v.id))
				i--;
			else
			{
				flag = Update(v);
				heapCheck.clear(v.id);
			}
			if (flag!=-1)
				return flag;
		}
		return flag;
	}

	private static int Update(node v) 
	{
		System.out.println(v.id);
		for (int i=0;i<adjList.get(v.id).size();i++)
		{
			block u = adjList.get(v.id).get(i);
			if (cost.get(u.city2)==-1)
			{
				if (partOfPath(u))
				{
					cost.set(u.city2, u.lowDistance+v.cost);
					H.add(new node (u.city2,cost.get(u.city2)));
					if (!heapCheck.get(u.city2))
						heapCheck.set(u.city2);
				}
				else
				{
					cost.set(u.city2, u.highDistance+v.cost);
					H.add(new node (u.city2,cost.get(u.city2)));
					if (!heapCheck.get(u.city2))
						heapCheck.set(u.city2);
				}
			}
			else
			{
				if (partOfPath(u))
				{
					if (cost.get(u.city2)<u.lowDistance+v.cost)
					{System.out.println("f");
					return u.number;
					}
					else
					{
						cost.set(u.city2, u.lowDistance+v.cost);
						H.add(new node (u.city2,cost.get(u.city2)));
						if (!heapCheck.get(u.city2))
							heapCheck.set(u.city2);
					}
				}
				else
				{
					if (cost.get(u.city2)>u.highDistance+v.cost)
					{
						cost.set(u.city2, u.highDistance+v.cost);
						H.add(new node (u.city2,cost.get(u.city2)));
						if (!heapCheck.get(u.city2))
							heapCheck.set(u.city2);

					}
				}
			}			
		}
		return -1;		
	}

	private static boolean partOfPath (block a)
	{
		return (gPaths.contains(a));		
	}

}
