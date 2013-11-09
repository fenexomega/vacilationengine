package engine;

import org.lwjgl.input.Keyboard;

public class Core_Input {
	public static boolean isKeyDown(String KEY)
	{
		int key;
		switch(KEY.toUpperCase())
		{
		case "UP":
			key = Keyboard.KEY_UP; break;
		case "DOWN":
			key = Keyboard.KEY_DOWN; break;
		case "LEFT":
			key = Keyboard.KEY_LEFT; break;
		case "RIGHT":
			key = Keyboard.KEY_RIGHT; break;
		case "ESCAPE":
			key = Keyboard.KEY_ESCAPE; break;
		case "W":
			key = Keyboard.KEY_W; break;
		case "A":
			key = Keyboard.KEY_A; break;
		case "S":
			key = Keyboard.KEY_S; break;
		case "D":
			key = Keyboard.KEY_D; break;
		case "E":
			key = Keyboard.KEY_E; break;
		case "Q":
			key = Keyboard.KEY_Q; break;
		default: key = 0;
		}
		return Keyboard.isKeyDown(key);
	}
}
