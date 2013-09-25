import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


public class code {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Scanner fileIP;
		
		try{
			fileIP = new Scanner(new File("input2.txt"));
			
			int C = fileIP.nextInt();//input number of test cases
			
			int N=0;
			int K=0;
			int T=0;
			BigInteger B = new BigInteger("0");
			
			BigInteger x[];
			int v[];
			
			int numOfSwaps=0;
			
			
			for (int i=0;i<C;i++)
			{
				numOfSwaps = 0;
				N=fileIP.nextInt();
				K=fileIP.nextInt();
				
				B=fileIP.nextBigInteger();
				
				T=fileIP.nextInt();
				
				x=new BigInteger[N];
				v=new int[N];
				
				//System.out.println(B);
				
				for (int j=0;j<N;j++)
					x[j]=fileIP.nextBigInteger();
				
				for (int j=0;j<N;j++)
					v[j]=fileIP.nextInt();
				
				int done = 0; //Number of chicks that went through
				int j=N-1;
				
				while (done<K)
				{
					int time=B.subtract(x[j]).divide(new BigInteger(Integer.toString(v[j]))).intValue();
					//System.out.println(time);
					if (time>T)
					{
						numOfSwaps+= K-done; //pick up this chick and let K-done chicks through
					}
					else
						done++;
					j--;
					if (j<0)
						break;
					
					
					
				}
				
				//System.out.println("over");
				if (done >= K)
					System.out.println(numOfSwaps);
				else
					System.out.println("IMPOSSIBLE");
				
					
			}
			
		}
		catch (IOException e){System.out.println("File not found");}

	}

}
