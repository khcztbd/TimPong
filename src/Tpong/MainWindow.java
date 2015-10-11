package Tpong;

/*
 * Pong Tutorial - Tim Brailsford, 2015
 * 
 * MainWindow is the game window
 */

import java.awt.*;
import java.awt.event.*;

public class MainWindow extends Frame implements Runnable {
	
	private static final long serialVersionUID = 57230183;
	
    // The timerThread must be declared, but initially set to null
    private Thread timerThread = null;
    Ball myBall;
    Paddle myPaddle;
    
    int HEIGHT = 480;
    int WIDTH = 640;
    int WALLWIDTH = 15;
    
    int DELAY = 12;
    int SCORE = 0;  
    
    class WindowListener extends WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            endGame(); // execute game over sequence
        }
    }

    class KeyboardListener extends KeyAdapter
    {
       public void keyPressed(KeyEvent e)
       {
          if (e.getKeyCode()==KeyEvent.VK_UP) myPaddle.moving_UP=true;
          if (e.getKeyCode()==KeyEvent.VK_DOWN) myPaddle.moving_DOWN=true;
        }
       
        public void keyReleased(KeyEvent e)
       {
          myPaddle.moving_UP=false;
          myPaddle.moving_DOWN=false;
        }
       
    }

    public MainWindow()
    {
        setLayout(null);
        setSize(WIDTH,HEIGHT);
        setBackground(Color.blue);
        setTitle("TimPong");
        
        myBall = new Ball(Color.yellow,560,240,20,WIDTH,HEIGHT,WALLWIDTH);
        myPaddle = new Paddle(Color.yellow,590,HEIGHT/2-35,10,70,HEIGHT,WALLWIDTH);
        
        add(myBall);
        add(myPaddle);
        
        WindowListener myWindowListener = new WindowListener();
        addWindowListener(myWindowListener); 
        
        KeyboardListener myKeyboardListener = new KeyboardListener();
        addKeyListener(myKeyboardListener); 
        
    }   
    
    public void paint(Graphics g)
    {
       // Draw walls
       g.setColor(Color.white);
       g.fillRect(0,0,WALLWIDTH, HEIGHT);
       g.fillRect(0,0,WIDTH, WALLWIDTH+20);
       g.fillRect(0,HEIGHT-WALLWIDTH,WIDTH,WALLWIDTH);
    }
    
    private boolean detectHit()
    {
       boolean detect = false;
       if (myBall.Xpos >= myPaddle.Xpos-myPaddle.WIDTH)
       {
          if ((myBall.Ypos >= myPaddle.Ypos) &&
                 (myBall.Ypos <= myPaddle.Ypos+myPaddle.HEIGHT))
           detect = true;
       }
       return detect;
    }
    
    private boolean detectMiss()
    {
       boolean detect = false;
       if (myBall.Xpos >= WIDTH -30) detect = true;
       return detect;
    }
    
    private void endGame()
    {
       System.out.println("Score: "+SCORE);
       System.out.println("Game Over");
       System.exit(0);
    }
 
    public void start()
    {
       if (timerThread == null) // if the timer thread doesn't exist, create it
       {
          timerThread = new Thread(this);
          timerThread.start();
       }
    } 
   
    public void run()
    {
         Thread myThread = Thread.currentThread();
         
         while (timerThread == myThread)
         {
            if (detectHit())
            {
               myBall.Xvelocity = 0 - myBall.Xvelocity;
               SCORE++;
               System.out.println("Pong!  [Score: "+SCORE+"]");
            }
            
            if (detectMiss()) endGame();
         
            myBall.move();
            myPaddle.move();
            try {
                  Thread.sleep(DELAY);
                } catch (InterruptedException e) { } 
          }       
     }
}
