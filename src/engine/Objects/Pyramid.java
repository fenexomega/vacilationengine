package engine.Objects;

import static org.lwjgl.opengl.GL11.GL_LINE_LOOP;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Pyramid extends TDComponent {
	private float r,g,b;
	public Pyramid(float x, float y, float z,float r, float g, float b) {
		super(x, y, z, 0,0,0);
		
		this.r = r;
		this.g = g;
		this.b = b;
		// TODO Auto-generated constructor stub
	}
	
	public void Render()
	{

		glPushMatrix();
		{
			glColor3f(r, g, b);
			glTranslatef(x,y,z);
			glRotatef(rx, 1, 0, 0);
			glRotatef(ry, 0, 1, 0);
			glRotatef(rz, 0, 0, 1);
			glBegin(GL_QUADS);
			{
				glVertex3f(-1,-1,-1);
				glVertex3f(-1,-1, 1);
				glVertex3f( 1,-1, 1);
				glVertex3f(1,-1,-1);
			}
			glEnd();
			
			glBegin(GL_TRIANGLES);
			{
				glVertex3f(-1, -1, 1);
				glVertex3f( 1, -1, 1);
				glVertex3f(0,1, 0);
				
				glVertex3f(-1, -1, -1);
				glVertex3f( 1, -1, -1);
				glVertex3f(0,1, 0);
				
				glVertex3f(-1, -1, -1);
				glVertex3f(-1, -1,  1);
				glVertex3f(0,1, 0);
				
				glVertex3f( 1, -1, -1);
				glVertex3f( 1, -1,  1);
				glVertex3f(0,1, 0);
			}
			glEnd();
			
			glColor3f(0, 0, 0);
			glBegin(GL_LINE_LOOP);
			{
				glVertex3f(-1, -1, 1);
				glVertex3f( 1, -1, 1);
				glVertex3f(0,1, 0);
				
				glVertex3f(-1, -1, -1);
				glVertex3f( 1, -1, -1);
				glVertex3f(0,1, 0);
				
				glVertex3f(-1, -1, -1);
				glVertex3f(-1, -1,  1);
				glVertex3f(0,1, 0);
				
				glVertex3f( 1, -1, -1);
				glVertex3f( 1, -1,  1);
				glVertex3f(0,1, 0);
			}
			glEnd();
		
			
			
		}
		glPopMatrix();
	}
}
