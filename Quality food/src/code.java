/*
 * This qtn was surprisingly easy. All you need to do is sort and then take things
 * in a greedy fashion.
 * 
 * use my quicksort class from algo rep.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class code {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


	
		
		try {
			Scanner in = new Scanner (new File("input.txt"));
			
			
			int T = in.nextInt();
			
			for (int k=0;k<T;k++)//for each test case
			{
				BigInteger M = in.nextBigInteger();//monies
				
				BigInteger F = in.nextBigInteger();//delivery fee
				
				int N = in.nextInt();//n lines of input
				
				class item implements Comparable<item>{
					
					public BigInteger price;
					public BigInteger staleTime;

					public item(BigInteger price,
							BigInteger staleTime) {
						this.price = price;
						this.staleTime = staleTime;
					}

					@Override
					public int compareTo(item o) {
						return price.compareTo(o.price);
					}
					
				}
				
				ArrayList<item> menu = new ArrayList<item>();
				
				for (int i=0;i<N;i++)
				{
					menu.add(new item(in.nextBigInteger(),in.nextBigInteger()));
				}
				
				quickSort.sort(menu);
				
				BigInteger daysSpent = new BigInteger("0");
				
				M.subtract(F);
				
				for (int i=0; M.compareTo(new BigInteger("0"))>0;i++)
				{
					
					item buyThis = menu.get(i);
					
					BigInteger canBuy = M.divide(buyThis.price);//number of items that can be bought in total
					canBuy = canBuy.subtract(buyThis.staleTime.add(new BigInteger("1")).subtract(daysSpent)); 
					//buy just enough to not stale +1 for the same day - days already over
					
					//Now we just add all
					daysSpent = daysSpent.add(canBuy);
					M.subtract(canBuy.multiply(buyThis.price));
					
					if (i==menu.size()-1) //need to reorder
					{
						M.subtract(F); //delivery fee again
						i=-1; //reset the menu
					}
					
				}
				
				System.out.println(daysSpent); //print answer
				
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		
		}
		

		
		}

}
