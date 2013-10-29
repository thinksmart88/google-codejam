/*
 * This class does quick sort on any comparable object
 * Don't be a retard and pass any NON COMPARABLE objects
 * 
 * @author: Ibrahim Naik
 * 
 * Call sort(Arraylist of w/e). It returns void and makes changes.
 * 
 */

import java.util.ArrayList;


public class quickSort 
{
	
	
	
	/*
	 * Dont call this function
	 */
	public static <T extends Comparable<T>> void doSort (ArrayList<T> listOfObjects,int start,int end)
	{
		if (start ==end || start>end ) //end case if only 1 element
			return;
		else
		{
			int size = end-start+1;
			int pivot = (int) (Math.random()*size-1)+start; //pivot selection
			T pivotElement = listOfObjects.get(pivot);
			
			int i=start;
			for (int j=end;i<=j;) //loopy loop
			{
				if ((listOfObjects.get(i).compareTo(pivotElement)<0)||(listOfObjects.get(i).compareTo(pivotElement)==0))
					{
					i++;
					continue;
					}
				if ((listOfObjects.get(j).compareTo(pivotElement)>0)||(listOfObjects.get(j).compareTo(pivotElement)==0))
				{
					j--;
					continue;
				}
				
				//If the code reached here we have a element smaller than pivot at i and
				//greater than pivot at j. Its swapping time.
				
				T temp = listOfObjects.get(i);
				listOfObjects.set(i, listOfObjects.get(j));
				listOfObjects.set(j, temp);
				i++;
				j--;

				
				
			}
			//Place the pivot at its spot
			if (pivot<i)
			{
				T temp = listOfObjects.get(i-1);		
			listOfObjects.set(i-1, pivotElement);
			listOfObjects.set(pivot, temp);			
			pivot = i-1;
			}
			else
			{
				T temp = listOfObjects.get(i);		
			listOfObjects.set(i, pivotElement);
			listOfObjects.set(pivot, temp);			
			pivot = i;
			}
			

			
			
			//Inception time
			doSort (listOfObjects,start,pivot-1);
			doSort (listOfObjects,pivot+1,end);
						
		}
	}
	
	/*
	 * Call this function
	 */
	public static <T extends Comparable <T>> void sort (ArrayList<T> listOfObjects)
	{
		doSort(listOfObjects, 0, listOfObjects.size()-1);		
	}
}
