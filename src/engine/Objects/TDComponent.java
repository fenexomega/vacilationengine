package engine.Objects;


public abstract class TDComponent
{
	protected float x, y, z;
	protected float rx, ry, rz;

	public TDComponent(float x, float y, float z, float rx, float ry, float rz)
	{

		this.x = x;
		this.y = y;
		this.z = z;
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
	}

	public void Render()
	{

	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public float getZ()
	{
		return z;
	}

	public void setZ(float z)
	{
		this.z = z;
	}

	public float getRx()
	{
		return rx;
	}

	public void setRx(float rx)
	{
		this.rx = rx;
	}

	public float getRy()
	{
		return ry;
	}

	public void setRy(float ry)
	{
		this.ry = ry;
	}

	public float getRz()
	{
		return rz;
	}

	public void setRz(float rz)
	{
		this.rz = rz;
	}

}
