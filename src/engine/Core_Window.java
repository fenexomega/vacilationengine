package engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Core_Window {
	private static boolean fullscreen = false;
	private static int Width = 1024;
	private static int Height = 768;
	private static String title = "Vacilation Engine";
	
	
	public static void Init()
	{
		try {
			Display.setDisplayMode(new DisplayMode(Width, Height));
			Display.setVSyncEnabled(true);
			Display.sync(60);
			Display.setTitle(title);
			
			Display.create();
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Init(int Width, int Height,String title,int fps)
	{
		try {
			Display.setDisplayMode(new DisplayMode(Width, Height));
			Display.setVSyncEnabled(true);
			Display.sync(fps);
			Display.setTitle(title);
			Display.create();
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Core_Window.title = title;
	}

	
	
	public static void ToggleFullScreen()
	{
		fullscreen = !fullscreen;
		try {
			Display.setFullscreen(fullscreen);
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getWidth() {
		return Width;
	}

	public static void setWidth(int width) {
		Width = width;
	}

	public static int getHeight() {
		return Height;
	}

	public static void setHeight(int height) {
		Height = height;
	}
	
	
}
