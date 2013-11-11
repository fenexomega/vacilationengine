package engine.Objects;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera extends TDComponent
{

	private float fov, aspect, zNear, zFar;
	private boolean canMove;

	public Camera(float x, float y, float z, float rx, float ry, float rz,
			float fov, float aspect, float zNear, float zFar, boolean canMove)
	{
		super(x, y, z, rx, ry, rz);
		this.fov = fov;
		this.aspect = aspect;
		this.zNear = zNear;
		this.zFar = zFar;
		this.canMove = canMove;
		// TODO Auto-generated constructor stub
	}

	public Camera(float fov, float aspect, float zNear, float zFar)
	{
		super(0, 0, 0, 0, 0, 0);
		this.fov = fov;
		this.aspect = aspect;
		this.zNear = zNear;
		this.zFar = zFar;
		canMove = false;
	}

	private void initPespective()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, aspect, zNear, zFar);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_DEPTH_TEST);
	}

	public void usePespective()
	{
		initPespective();
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 1, 0);
		glRotatef(rz, 0, 0, 1);
		glTranslatef(x, y, z);
	}

	public float getFov()
	{
		return fov;
	}

	public void setFov(float fov)
	{
		this.fov = fov;
	}

	public float getAspect()
	{
		return aspect;
	}

	public void setAspect(float aspect)
	{
		this.aspect = aspect;
	}

	public float getzNear()
	{
		return zNear;
	}

	public void setzNear(float zNear)
	{
		this.zNear = zNear;
	}

	public float getzFar()
	{
		return zFar;
	}

	public void setzFar(float zFar)
	{
		this.zFar = zFar;
	}

	public void moveY(float amt)
	{
		if (!canMove)
			return;
		y += amt;
	}

	public void setMovable(boolean bool)
	{
		canMove = bool;
	}

	public void rotateY(float amt)
	{
		if (!canMove)
			return;
		ry += amt;
	}

	public void move(float amt, float dx)
	{
		if (!canMove)
			return;
		z += amt * Math.sin(Math.toRadians(ry + 90 * dx));
		x += amt * Math.cos(Math.toRadians(ry + 90 * dx));
	}

	public void moveTo(float x, float y, float z, float rx, float ry, float rz)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
	}

}
