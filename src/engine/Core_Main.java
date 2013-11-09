package engine;

import static org.lwjgl.opengl.GL11.*;


import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import game.Game;

public class Core_Main {
	public static void Run()
	{
		Init();
		GameLoop();
		CleanUp();
		
	}

	private static void CleanUp() {
		// TODO Auto-generated method stub
		Display.destroy();
		Keyboard.destroy();
		System.exit(0);
	}

	private static void GameLoop() {
		// TODO Auto-generated method stub
		Game game = new Game();
		
		while(!Display.isCloseRequested() && !Core_Input.isKeyDown("ESCAPE"))
		{
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			
			game.Update();
			
			game.render();
			Display.update();
		}
	}
	
	private static void Init()
	{
		InitDisplay();
		InitKeyboard();
	}

	private static void InitKeyboard() {
		// TODO Auto-generated method stub
		try {
			Keyboard.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void InitDisplay() {
		// TODO Auto-generated method stub
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setVSyncEnabled(true);
			Display.sync(60);
			Display.setTitle("Vacilation Engine");
			Display.create();
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setTitle(String title)
	{
		Display.setTitle(title);
	}
}
