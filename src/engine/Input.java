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
	public static final int KEY_RCONTROL = Keyboard.KEY_RCONTROL ;
	public static final int KEY_LCONTROL = Keyboard.KEY_LCONTROL ;
	public static final int KEY_ESCAPE = Keyboard.KEY_ESCAPE ;

	
	
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
