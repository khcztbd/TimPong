package Tpong;

/*
 * Pong Tutorial - Tim Brailsford, 2015
 *
 * This tutorial shows the step by step construction of a classic 
 * "bouncing ball" program.
 *
 *   The Ball class for use with Tpong
 */
 
/*
 *  Ball represents a ball that moves and bounces off walls following
 *  its own physics (the X and Y movement changes direction when the
 *  ball bounces off the sides or top and bottom respectively).
 */

import java.awt.*;

public class Ball extends GameItem {
	
	  private static final long serialVersionUID = 56992983;
	  int RADIUS;

	   Ball(Color color, 
	        int x, 
	        int y, 
	        int radius, 
	        int winWidth, 
	        int winHeight,
	        int wallWidth)
	   {
	      super(color,x,y,radius,radius, winWidth, winHeight, wallWidth);
	      RADIUS = radius;
	      
	      // set velocity to start moving
	      Xvelocity = -5;
	      Yvelocity = -5;
	   }
	   
	   public void paint(Graphics g)
	   {
	      g.setColor(COLOR);
	      g.fillOval(0,0,WIDTH,HEIGHT); 
	   }
	   
	   public void move()
	   {

	     // NB for Pong rather than a bouncing ball program, we are only interested
	     // in the right hand side

	     if (Xpos <=WALLWIDTH) Xvelocity = 0 - Xvelocity;

	     
	     // Reverse Yvelocity if the ball hits the sides
	     if (Ypos <=20+WALLWIDTH || Ypos >= WINDOW_HEIGHT-RADIUS-WALLWIDTH) Yvelocity = 0 - Yvelocity;

	     super.setLocation(Xvelocity, Yvelocity);
	   }
}
