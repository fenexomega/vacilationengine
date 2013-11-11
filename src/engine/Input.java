package engine;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input
{
	public static final int KEY_UP = Keyboard.KEY_UP ;
	public static final int KEY_DOWN = Keyboard.KEY_DOWN ;
	public static final int KEY_LEFT = Keyboard.KEY_LEFT ;
	public static final int KEY_RIGHT = Keyboard.KEY_RIGHT ;
	public static final int KEY_A = Keyboard.KEY_A ;
	public static final int KEY_D = Keyboard.KEY_D ;
	public static final int KEY_E = Keyboard.KEY_E ;
	public static final int KEY_S = Keyboard.KEY_S ;
	public static final int KEY_Q = Keyboard.KEY_Q ;
	public static final int KEY_W = Keyboard.KEY_W ;
	public static final int KEY_F2 = Keyboard.KEY_F2 ;
	public static final int KEY_F3 = Keyboard.KEY_F3 ;
	public static final int KEY_F4 = Keyboard.KEY_F4 ;
	public static final int KEY_F5 = Keyboard.KEY_F5 ;
	public static final int KEY_F6 = Keyboard.KEY_F6 ;
	
	
	
	
	public static final int NUM_KEYCODES = 256;
	public static final int MOUSE_CODES = 5;
	private static List<Integer> currentKeys = new ArrayList<Integer>();
	private static List<Integer> downKeys = new ArrayList<Integer>();
	private static List<Integer> upKeys = new ArrayList<Integer>();
	private static List<Integer> currentMouse = new ArrayList<Integer>();
	private static List<Integer> downMouse = new ArrayList<Integer>();
	private static List<Integer> upMouse = new ArrayList<Integer>();
	
	
	public static void Init()
	{
		try
		{
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e)
		{
			e.printStackTrace();
		}
	}

	public static void update()
	{
		// TODO Mouse Methods http://www.youtube.com/watch?feature=player_detailpage&list=PLEETnX-uPtBXP_B2yupUKlflXBznWIlL5&v=pBK-lb-k-rs#t=639
		
		upKeys.clear();
		for(int i =0; i < NUM_KEYCODES; i++)
			if(!getKey(i) && currentKeys.contains(i))
				upKeys.add(i);
		
		downKeys.clear();
		for(int i = 0; i < NUM_KEYCODES; i++)
			if(getKey(i) && !currentKeys.contains(i))
				downKeys.add(i);
		
		currentKeys.clear();
		for(int i = 0; i < NUM_KEYCODES; i++)
			if(getKey(i))
				currentKeys.add(i);
		

		upMouse.clear();
		for(int i =0; i < MOUSE_CODES; i++)
			if(!getMouse(i) && currentMouse.contains(i))
				upKeys.add(i);
		
		downMouse.clear();
		for(int i = 0; i < MOUSE_CODES; i++)
			if(getMouse(i) && !currentMouse.contains(i))
				downMouse.add(i);
		
		currentMouse.clear();
		for(int i = 0; i < MOUSE_CODES; i++)
			if(getMouse(i))
				currentMouse.add(i);
		
	}

	public static boolean getKey(int keyCode)
	{
		return Keyboard.isKeyDown(keyCode);
	}

	public static boolean getKeyDown(int keyCode)
	{
		return downKeys.contains(keyCode);
	}

	public static boolean getKeyUp(int keyCode)
	{
		return upKeys.contains(keyCode);
	}
	
	public static boolean getKeyPressed(int keyCode)
	{
		return currentKeys.contains(keyCode);
	}
	
	public static boolean getMouse(int mouseButton)
	{
		return Mouse.isButtonDown(mouseButton);
	}
	
	public static boolean getMouseDown(int mouseButton)
	{
		return downMouse.contains(mouseButton);
	}
	
	public static void destroy()
	{
		// TODO Auto-generated method stub
		Keyboard.destroy();
		Mouse.destroy();
	}
	
	public static Vector2f getMousePosition()
	{
		return new Vector2f(Mouse.getX(),Mouse.getY());
	}
	
	public static void MouseToggleDesappear()
	{
		Mouse.setGrabbed(!Mouse.isGrabbed());
	}
	
	public static void MouseToCenter()
	{
		Mouse.setCursorPosition(Window.getWidth()/2, Window.getHeight()/2);
	}
}
// public static boolean isKeyDown(String KEY)
// {
// int key;
// switch (KEY.toUpperCase())
// {
// case "UP":
// key = Keyboard.KEY_UP;
// break;
// case "DOWN":
// key = Keyboard.KEY_DOWN;
// break;
// case "LEFT":
// key = Keyboard.KEY_LEFT;
// break;
// case "RIGHT":
// key = Keyboard.KEY_RIGHT;
// break;
// case "ESCAPE":
// key = Keyboard.KEY_ESCAPE;
// break;
// case "W":
// key = Keyboard.KEY_W;
// break;
// case "A":
// key = Keyboard.KEY_A;
// break;
// case "S":
// key = Keyboard.KEY_S;
// break;
// case "D":
// key = Keyboard.KEY_D;
// break;
// case "E":
// key = Keyboard.KEY_E;
// break;
// case "Q":
// key = Keyboard.KEY_Q;
// break;
// case "F6":
// key = Keyboard.KEY_F6;
// break;
// case "ENTER":
// key = Keyboard.KEY_RETURN;
// break;
// case "ALT":
// key = Keyboard.KEY_LMENU;
// break;
// default:
// key = 0;
// }
// return Keyboard.isKeyDown(key);
// }
