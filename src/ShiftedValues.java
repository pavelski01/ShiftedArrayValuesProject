import java.util.Random;

public class ShiftedValues
{	
	static Random random = new Random();
	static int low = 1, high = 99;
	
	static
	{ random.setSeed(System.currentTimeMillis()); }
		
	static int getRandom()
	{ return random.nextInt(high - low) + low; }
	
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
	
	public static void main(String[] args)
	{
		if (args.length < 4) return;
		int Xa = Integer.parseInt(args[0]);
		int Ya = Integer.parseInt(args[1]);
		int Xp = Integer.parseInt(args[2]);
		int Yp = Integer.parseInt(args[3]);
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