package Tpong;

/*
 * Pong Tutorial - Tim Brailsford, 2015
 *
 * This tutorial shows the step by step construction of a classic 
 * "bouncing ball" program.
 *
 *   The GameItem class for use with Tpong
 */

import java.awt.*;

/*
 *  GameItem represents any individual moveable element in the game 
 *  (such as a ball or a padle).
 */

public class GameItem extends Panel {
	
	   private static final long serialVersionUID = 56334921;

	   int HEIGHT;
	   int WIDTH;
	   int WINDOW_HEIGHT;
	   int WINDOW_WIDTH;
	   int WALLWIDTH;
	   
	   Color COLOR;
	      
	   int Xpos;
	   int Ypos;
	   
	   int Xvelocity = 0;
	   int Yvelocity = 0;
	   
	   GameItem(Color color, 
	            int x, 
	            int y, 
	            int width, 
	            int height, 
	            int winWidth, 
	            int winHeight,
	            int wallWidth)
	   {
	      Xpos = x;
	      Ypos = y;
	      HEIGHT = height;
	      WIDTH = width;
	      
	      WINDOW_WIDTH = winWidth;
	      WINDOW_HEIGHT = winHeight;
	      
	      WALLWIDTH = wallWidth;
	      
	      COLOR = color;
	                  
	      setBounds(Xpos,Ypos,height, width); 
	   }

	   public void setLocation(int Xchange, int Ychange)
	   {
	     // update X and Y positions
	   	    Xpos= Xpos + Xchange;
	        Ypos = Ypos + Ychange;
	     
	     // draw the ball
	     setBounds(Xpos,Ypos,WIDTH,HEIGHT);   
	   } 	
}
