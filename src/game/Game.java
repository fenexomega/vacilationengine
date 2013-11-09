package game;

import java.util.ArrayList;
import java.util.List;


import engine.Objects.Cube;
import engine.Objects.Pyramid;
import engine.Objects.TDComponent;

public class Game {
	List<TDComponent> cubes = new ArrayList<TDComponent>();
	Player player = new Player();
	boolean flag = true;
	boolean showFrame = true;
	boolean canBuild = true;
	boolean flag2 = true;
	
	public Game()
	{
		cubes.add(new Cube(-2, 0,-10,1,0,0,0.5f));
		cubes.add(new Pyramid(2, 0, -10, 0, 1, 0));
		player.canMove(true);
	}
	
	public void Update()
	{
		
		player.Update();
		if(canBuild)
		{
			if(player.isKeyDown("e"))
			{	
				if(flag)
				{
					flag = false;
					cubes.add(new Cube((float) (-player.getX() - 3f * Math.cos(Math.toRadians(player.getRy() + 90))), player.getY(), (float) (-player.getZ() - 3f * Math.sin(Math.toRadians(player.getRy() + 90))), 1,1,1,0.5f));
					cubes.add(new Cube((float) (-player.getX() - 3f * Math.cos(Math.toRadians(player.getRy() + 90))), player.getY(), (float) (-player.getZ() - 3f * Math.sin(Math.toRadians(player.getRy() + 90))), 1,1,1,0.5f));
				}
			}
			else
				flag = true;
		}
		if(player.isKeyDown("q"))
		{
			if(flag2)
			{
				if(canBuild)
				{
					showFrame = !showFrame;
					canBuild = false;
				}
				else
				{
					showFrame = !showFrame;
					canBuild = true;
				}
				flag2 = false;
			}
			
		}
		else
			flag2 = true;
		
		
		
	}
	
	public void render()
	{
		for(TDComponent component : cubes)
			component.Render();
		if(showFrame)
			Cube.RenderWireFrame((float) (-player.getX() - 3f * Math.cos(Math.toRadians(player.getRy() + 90))),player.getY(), (float) (-player.getZ() - 3f * Math.sin(Math.toRadians(player.getRy() + 90))), 1f, 1f, 1f,0.5f);
	}
	
	
}
