package game;

import org.lwjgl.opengl.Display;

import engine.Input;
import engine.Window;
import engine.Objects.Camera;

public class Player
{

	private boolean moveFront, moveBack, moveLeft, moveRight, crounch;
	private Camera camera = new Camera(70, (float) Window.getWidth()
			/ (float) Window.getHeight(), 0.3f, 1000);

	public void Update()
	{
		processInput();
		camera.usePespective();

	}

	public void canMove(boolean b)
	{
		camera.setMovable(b);
	}

	public void move(float x, float y, float z, float rx, float ry, float rz)
	{
		camera.moveTo(x, y, z, rx, ry, rz);
	}

	private void processInput()
	{
		moveFront = Input.getKeyPressed(Input.KEY_W);
		moveBack = Input.getKeyPressed(Input.KEY_S);
		moveLeft = Input.getKeyPressed(Input.KEY_A);
		moveRight = Input.getKeyPressed(Input.KEY_D);
		crounch = Input.getKeyPressed(Input.KEY_LCONTROL);


		if (moveFront)
			camera.move(0.1f, 1);
		if (moveBack)
			camera.move(-0.1f, 1);
		if (moveLeft)
			camera.move(0.1f, 0);
		if (moveRight)
			camera.move(-0.1f, 0);
		
		if(crounch)
			camera.setY(0.5f);
		else
			camera.setY(0);
		
		camera.rotateY((Input.getMousePosition().getX() - Display.getWidth()/2)/5);
		camera.rotateX(-(Input.getMousePosition().getY() - Display.getHeight()/2)/3);
		
		Input.MouseToCenter();
	}

	

	public float getX()
	{
		// TODO Auto-generated method stub
		return camera.getX();
	}

	public float getY()
	{
		// TODO Auto-generated method stub
		return camera.getY();
	}

	public float getZ()
	{
		// TODO Auto-generated method stub
		return camera.getZ();
	}

	public float getRx()
	{
		// TODO Auto-generated method stub
		return camera.getRx();
	}

	public float getRy()
	{
		// TODO Auto-generated method stub
		return camera.getRy();
	}

	public float getRz()
	{
		// TODO Auto-generated method stub
		return camera.getRz();
	}

}
