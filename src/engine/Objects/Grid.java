package engine.Objects;

import static org.lwjgl.opengl.GL11.*;

public class Grid
{
	int lines = 100;
	float z, x;

	public void Render()
	{

		z = -lines;
		x = -lines;
		for (int i = -lines; i < lines; z = i++)
		{
			glPushMatrix();
			{
				glColor3f(0.5f, 0, 1);
				glBegin(GL_LINE_STRIP);
				{
					glVertex3f(-lines, -1, z);
					glVertex3f(lines, -1, z);
				}
				glEnd();
			}
			glPopMatrix();
		}
		for (int i = -lines; i < lines; x = i++)
		{
			glPushMatrix();
			{
				glColor3f(1, 0, 0.5f);
				glBegin(GL_LINE_STRIP);
				{
					glVertex3f(x, -1, lines);
					glVertex3f(x, -1, -lines);
				}
				glEnd();
			}
			glPopMatrix();
		}

	}
}
