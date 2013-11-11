package engine;

import static org.lwjgl.opengl.GL11.*;
import game.Game;

public class MainComponent
{

	private static boolean isRunning = false;
	private static Game game;
	public static final double FRAME_CAP = 5000.0;
	public static final double frameTime = 1.0/FRAME_CAP;
	private static boolean render;

	public static void Start()
	{
		game = new Game();
		Init();
		Run();

	}

	private static void CleanUp()
	{
		// TODO Auto-generated method stub
		Window.destroy();
		Input.destroy();
		System.exit(0);
	}

	private static void Run()
	{
		// TODO Auto-generated method stub
		
		isRunning = true;

		long lastTime = Time.getTime();
		double unprocessedTime = 0;
		
		while (isRunning)
		{
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			long frameCounter = 0;
			int frames = 0;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double) Time.SECOND;
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			
			Input.update();
			game.Update();
			
			while(unprocessedTime > frameTime)
			{
				render = true;
				
				unprocessedTime -= frameTime;
				frameCounter += passedTime;
				if (Window.isCloseRequested())
					stop();
				Time.setDelta(frameTime);
				
				if(frameCounter >= Time.SECOND)
				{
					frames = 0;
					frameCounter = 0;
				}
				frames++;
			}
			if(render)
			{
				Render();
				render = false;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		CleanUp();
	}

	private static void stop()
	{
		// TODO Auto-generated method stub
		if (!isRunning)
			return;
		isRunning = false;
	}

	private static void Render()
	{

		game.render();
		Window.update();

	}

	private static void Init()
	{
		Window.Init();
		Input.Init();
	}

}
