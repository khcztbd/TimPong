package Tpong;

/*
 * Pong Tutorial - Tim Brailsford, 2015
 *
 * This tutorial shows the step by step construction of a classic 
 * "bouncing ball" program.
 *
 *   The Paddle class for use with Tpong
 */

import java.awt.*;

public class Paddle extends GameItem {
	
	   int PADDLE_SPEED = 6;
	   boolean moving_UP = false;
	   boolean moving_DOWN = false;
	   
	 
	   public Paddle(Color color, 
	                 int x, 
	                 int y, 
	                 int width, 
	                 int height, 
	                 int winHeight, 
	                 int wallWidth)
	   {
	     super(color,x,y,width,height,0,winHeight,wallWidth);
	     
	      moving_UP = false;
	      moving_DOWN = false;
	      
	   }
	    
	   public void paint(Graphics g)
	   {
	     setBackground(COLOR);     
	   }
	   

	   public void move()
	   {
	      int Xchange=0;
	      int Ychange=0;   
	             
	      if (moving_UP && Ypos>20+WALLWIDTH) Ychange=-PADDLE_SPEED;
	   	  if (moving_DOWN  && Ypos<WINDOW_HEIGHT-HEIGHT-WALLWIDTH) Ychange=PADDLE_SPEED; 

	      super.move(Xchange, Ychange);
	     
	   }
}
