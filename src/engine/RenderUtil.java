package engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil
{
	public static void clearScreen()
	{
		//TODO Stencil Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	}
	
	public static void renderCrosshair()
	{
		float aux = 0.05f;
		glPushMatrix();
		{
			glColor3f(1, 1, 1);
			glBegin(GL_LINE_STRIP);
			{
				glVertex2f(-aux, 0);
				glVertex2f(aux, 0);
				
				
			}
			glEnd();
			
			glBegin(GL_LINE_STRIP);
			{
				
				
				glVertex2f(0, -aux);
				glVertex2f(0, aux);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	public static void initGraphics()
	{
		glClearColor(0,0,0,0);
		
		/*glFrontFace(GL_CW);
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);*/
		glEnable(GL_DEPTH_TEST);
		
		//TODO Depth Clamp
		glEnable(GL_FRAMEBUFFER_SRGB);
	}
}
