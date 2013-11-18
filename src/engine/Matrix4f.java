package engine;

public class Matrix4f
{
	private float[][] matrix;
	
	public Matrix4f(int size)
	{
		matrix = new float[size][size];
	}
	
	public Matrix4f initIdentity()
	{
		for(int x = 0; x < matrix.length; x++)
		{
			for(int y = 0; y < matrix.length; y++)
			{
				if(x == y)
					matrix[x][y] = 1;
				else
					matrix[x][y] = 0;
			}
		}
		return this;
	}
	
	public Matrix4f mul(Matrix4f r)
	{
		Matrix4f result = new Matrix4f(r.getMatrix().length);
		float sum;
		
		for(int x = 0; x < matrix.length; x++)
		{
			sum = 0;
			for(int y = 0; y < matrix.length; y++)
			{
				for(int z = 0; z < matrix.length; z++)
					sum += matrix[x][z] * r.get(z,y);
				result.set(x,y,sum);
			}
		}
		
		return result;
	}
	
	public float[][] getMatrix()
	{
		return matrix;
	}

	public void setMatrix(float[][] matrix)
	{
		this.matrix = matrix;
	}
	
	public void set(int x, int y , float value)
	{
		this.matrix[x][y] = value;
	}
	
	public float get(int x, int y)
	{
		return matrix[x][y];
	}
	
	public String toString()
	{
		String s = "";
		for(int x = 0; x < matrix.length; x++)
		{
			for(int y = 0; y < matrix.length; y++)
			{
				s += " | " + matrix[x][y];
			}
			s += " |\n";
		}
		
		return s;
	}
/*	public static void main(String[] args)
	{
		Matrix4f m = new Matrix4f(2);
		Matrix4f m2 = new Matrix4f(2);
		m.initIdentity();
		System.out.println(m.toString());
		
		m.set(0, 0, 1); m.set(1, 0, 2);
		m.set(0, 1, 3); m.set(1, 1, 4);
		System.out.println(m.toString());
		
		m2.set(0, 0, 4); m2.set(1, 0, 3);
		m2.set(0, 1, 2); m2.set(1, 1, 1);
		
		m.mul(m2);
		System.out.println(m.toString());

		
	}*/
}


