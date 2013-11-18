package game;

import java.util.ArrayList;
import java.util.List;

import engine.Input;
import engine.RenderUtil;
import engine.Objects.Cube;
import engine.Objects.Grid;
import engine.Objects.Pyramid;
import engine.Objects.TDComponent;

public class Game
{
	List<TDComponent> cubes = new ArrayList<TDComponent>();
	Player player = new Player();
	boolean showFrame = true;
	boolean canBuild = true;
	boolean debug = true;
	Grid grid = new Grid();
	float cubex, cubey, cubez;

	public Game()
	{
		cubes.add(new Cube(-2, 0, -10, 1, 0, 0, 0.5f));
		cubes.add(new Pyramid(2, 0, -10, 0, 1, 0));
		player.canMove(true);
		Input.MouseToggleDesappear();
		

	}

	public void Update()
	{
		cubex = (float) (-player.getX() - 4f * Math.cos(Math.toRadians(player.getRy() + 90)) * Math.cos(Math.toRadians(player.getRx())));
		cubey =  0;
		cubez = (float) (-player.getZ() - 4f * Math.sin(Math.toRadians(player.getRy() + 90)) * Math.cos(Math.toRadians(player.getRx())));
		

		player.Update();
		if (canBuild)
		{
			if (Input.getMouseDown(0))
			{				
				cubes.add(new Cube( cubex, cubey,cubez, 1, 1, 1, 0.5f));
			}
		}
		if (Input.getKeyDown(Input.KEY_Q))
		{

			if (canBuild)
			{
				showFrame = !showFrame;
				canBuild = false;
			} else
			{
				showFrame = !showFrame;
				canBuild = true;
			}


		}

		if (Input.getKeyDown(Input.KEY_F6))
		{

			Input.MouseToggleDesappear();
			debug = !debug;


		}

	}

	public void render()
	{
		
		
		if (debug)
			grid.Render();
		for (TDComponent component : cubes)
			component.Render();
		if (showFrame)
			Cube.RenderWireFrame(cubex, cubey,cubez, 1, 1, 1, 0.5f);
	}

}
