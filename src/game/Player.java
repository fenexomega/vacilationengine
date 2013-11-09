package game;

import org.lwjgl.opengl.Display;

import engine.Core_Input;
import engine.Objects.Camera;

public class Player {
	
	private boolean moveFront,moveBack,moveLeft,moveRight;
	private boolean rotateLeft,rotateRight;
	private Camera camera = new Camera(70,(float) Display.getWidth()/(float) Display.getHeight(), 0.3f, 1000);
	
	
	
	
	public void Update()
	{
		processInput();
		camera.usePespective();
		
	}
	
	public void canMove(boolean b)
	{
		camera.setMovable(b);
	}
	
	public void move(float x, float y, float z,float rx, float ry, float rz)
	{
		camera.moveTo(x, y, z, rx, ry, rz);
	}
	
	
	
	private void processInput()
	{
		moveFront = Core_Input.isKeyDown("W");
		moveBack = Core_Input.isKeyDown("S");
		moveLeft = Core_Input.isKeyDown("A");
		moveRight = Core_Input.isKeyDown("D");
		
		rotateLeft = Core_Input.isKeyDown("LEFT");
		rotateRight = Core_Input.isKeyDown("RIGHT");
		
		if(moveFront)
			camera.move(0.1f,1);
		if(moveBack)
			camera.move(-0.1f,1);
		if(moveLeft)
			camera.move(0.1f,0);
		if(moveRight)
			camera.move(-0.1f,0);
		if(rotateLeft)
			camera.rotateY(-1f);
		if(rotateRight)
			camera.rotateY(1f);
	}
	
	public boolean isKeyDown(String string)
	{
		return Core_Input.isKeyDown(string);
	}
	
	public float getX() {
		// TODO Auto-generated method stub
		return camera.getX();
	}
	
	public float getY() {
		// TODO Auto-generated method stub
		return camera.getY();
	}
	
	public float getZ() {
		// TODO Auto-generated method stub
		return camera.getZ();
	}



	public float getRx() {
		// TODO Auto-generated method stub
		return camera.getRx();
	}
	public float getRy() {
		// TODO Auto-generated method stub
		return camera.getRy();
	}
	public float getRz() {
		// TODO Auto-generated method stub
		return camera.getRz();
	}


}
