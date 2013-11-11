package engine.Objects;

import static org.lwjgl.opengl.GL11.*;

public class Cube extends TDComponent
{

	private float r, g, b;
	private float size;

	public Cube(float x, float y, float z, float r, float g, float b, float size)
	{
		super(x, y, z, 0, 0, 0);
		this.r = r;
		this.g = g;
		this.b = b;
		this.size = size;
	}

	public static void RenderWireFrame(float x, float y, float z, float r,
			float g, float b, float size)
	{
		glPushMatrix();
		{
			glTranslatef(x, y - size, z);
			glColor3f(r, g, b);
			glScalef(size, size, size);
			glBegin(GL_LINE_LOOP);
			{
				// front face
				glVertex3f(-1, -1, 1);
				glVertex3f(-1, 1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, -1, 1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{
				// back face

				glVertex3f(-1, -1, -1);
				glVertex3f(-1, 1, -1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{
				// bottom face
				glVertex3f(-1, -1, 1);
				glVertex3f(1, -1, 1);
				glVertex3f(1, -1, -1);
				glVertex3f(-1, -1, -1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{

				// left face
				glVertex3f(-1, 1, 1);
				glVertex3f(-1, 1, -1);
				glVertex3f(-1, -1, -1);
				glVertex3f(-1, -1, 1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{

				// right face
				glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);
				glVertex3f(1, -1, 1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{

				// up face
				glVertex3f(-1, 1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);
				glVertex3f(-1, 1, -1);

			}
			glEnd();
		}
		glPopMatrix();
	}

	public void Render()
	{
		glPushMatrix();
		{
			glColor3f(r, g, b);
			glTranslatef(x, y - size, z);
			glScalef(size, size, size);
			glBegin(GL_QUADS);
			{
				// front face
				glVertex3f(-1, -1, 1);
				glVertex3f(-1, 1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, -1, 1);

				// back face

				glVertex3f(-1, -1, -1);
				glVertex3f(-1, 1, -1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);

				// left face
				glVertex3f(-1, 1, 1);
				glVertex3f(-1, 1, -1);
				glVertex3f(-1, -1, -1);
				glVertex3f(-1, -1, 1);

				// right face
				glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);
				glVertex3f(1, -1, 1);

				// bottom face
				glVertex3f(-1, -1, 1);
				glVertex3f(1, -1, 1);
				glVertex3f(1, -1, -1);
				glVertex3f(-1, -1, -1);

				// up face
				glVertex3f(-1, 1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);
				glVertex3f(-1, 1, -1);

			}
			glEnd();

			glColor3f(0, 0, 0);
			glBegin(GL_LINE_LOOP);
			{
				// front face
				glVertex3f(-1, -1, 1);
				glVertex3f(-1, 1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, -1, 1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{
				// back face

				glVertex3f(-1, -1, -1);
				glVertex3f(-1, 1, -1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{
				// bottom face
				glVertex3f(-1, -1, 1);
				glVertex3f(1, -1, 1);
				glVertex3f(1, -1, -1);
				glVertex3f(-1, -1, -1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{

				// left face
				glVertex3f(-1, 1, 1);
				glVertex3f(-1, 1, -1);
				glVertex3f(-1, -1, -1);
				glVertex3f(-1, -1, 1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{

				// right face
				glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);
				glVertex3f(1, -1, 1);

			}
			glEnd();

			glBegin(GL_LINE_LOOP);
			{

				// up face
				glVertex3f(-1, 1, 1);
				glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);
				glVertex3f(-1, 1, -1);

			}
			glEnd();
		}
		glPopMatrix();
	}

}
