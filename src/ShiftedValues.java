import java.util.Random;

public class ShiftedValues
{	
	static Random random = new Random();
	static int low = 1, high = 99;
	
	static
	{ random.setSeed(System.currentTimeMillis()); }
		
	static int getRandom()
	{ return random.nextInt(high - low + 1) + low; }
	
	static void printArray(int _array[][], int _Xa, int _Ya)
	{
		int temp;
		for (int i = 0; i < _Xa; i++)
			for (int j = 0; j < _Ya; j++)
			{
				temp = _array[i][j];
				if (temp < 10) System.out.print("0");
				System.out.print(temp + " ");
				if (j == _Ya - 1) System.out.println();
			}
		System.out.println();
	}
	
	public static void main(String[] _args)
	{
		int Xa, Ya, Xp, Yp;
		try
		{
			if (_args.length < 4) throw new IllegalArgumentException();
			Xa = Integer.parseInt(_args[0]);
			Ya = Integer.parseInt(_args[1]);
			Xp = Integer.parseInt(_args[2]);
			Yp = Integer.parseInt(_args[3]);
			if ((Xp > Xa - 1) || (Yp > Ya - 1)) 
				throw new IllegalArgumentException();
			System.out.println(
				"Custom values: Xa = " + Xa + ", Ya = " + Ya +
					", Xp = " + Xp + ", Yp = " + Yp + "\n"
			);
		}
		catch (IllegalArgumentException _iaEX) 
		{
			Xa = Ya = 5;
			Xp = Yp = 2;
			System.out.println("Default values: Xa = 5, Ya = 5, Xp = 2, Yp = 2\n");
		}
		int[][] array = new int[Xa][Ya];
		for (int i = 0; i < Xa; i++)
			for (int j = 0; j < Ya; j++)
				array[i][j] = getRandom();		
		printArray(array, Xa, Ya);
		for (int c = 0; c < Yp; c++) array[Xp][c] = array[Xp][c + 1];
		for (int c = Ya - 1; c > Yp; c--) array[Xp][c] = array[Xp][c - 1];
		for (int c = 0; c < Xp; c++) array[c][Yp] = array[c + 1][Yp];
		for (int c = Xa - 1; c > Xp; c--) array[c][Yp] = array[c - 1][Yp];
		array[Xp][Yp] = 0;		
		printArray(array, Xa, Ya);		
	}
}
