import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;

public class Maxwell extends JFrame
{
	Timer tick;
	int ticks = 0;
	double delta = 0.05;
	redBall[] redBalls;
	blueBall[] blueBalls;
	int redCount;
	int blueCount;
	
	public class Ball 
    {
    	int x, y;
    	int vx, vy;
    	double oldx, oldy;
    				
    	public Ball() 
    	{
    		x = (int) (Math.random() * 400 + 100); // [100, 500)
    		y = (int) (Math.random() * 400 + 100);

    		vx = (int) (Math.random() * 100 - 50); // [-50, 50)
    		vy = (int) (Math.random() * 100 - 50);
    	}

    	public Ball(int xClick, int yClick) 
    	{
    		x = xClick;
    		y = yClick;

    		vx = (int) (Math.random() * 100 - 50); // [-50, 50)
    		vy = (int) (Math.random() * 100 - 50);
    	}
    	public double getx()
    	{
    		return x;
    	}
    	
    	public void move(double delta) 
    	{
    		oldx = x;
    		oldy = y;
    		x += vx * delta;
    		y += vy * delta;
    		stayOnScreen();
    	}

    	public void stayOnScreen() 
    	{
    		if (gamePanel.isDoorThere())
    		{
    			if (x < 5)
        			vx *= -1;
        		if (x > 725)
        			vx *= -1;
        		if (y < 5)
        			vy *= -1;
        		if (y > 410)
        			vy *= -1;
        		
     			if ((x > 352) && (x < 377))
    				vx *= -1;
    		}
    		else if (!gamePanel.isDoorThere())
    		{
    			if (x < 5)
        			vx *= -1;
        		if (x > 725)
        			vx *= -1;
        		if (y < 5)
        			vy *= -1;
        		if (y > 410)
        			vy *= -1;
        		
     			if ((x > 352) && (x < 382))
     			{
     				if ((y < 150) || (y > 270))
     					vx *= -1;
     			}
    		}
    	}
    	public void drawMe( Graphics g ) { }
    }//END Ball

    public class redBall extends Ball
    {
    	redBall() 
    	{
            super();
        }

        redBall(int x, int y) {
            super(x, y);
        }

        public void drawMe ( Graphics g )
        {
            g.setColor( Color.RED );
            g.fillOval( (int)(x-2), (int)(y-2), 10, 10 );
        }
    }//END redBall

    public class blueBall extends Ball
    {
    	blueBall() {
            super();
        }

        blueBall(int x, int y) {
            super(x, y);
        }

        public void drawMe ( Graphics g )
        {
            g.setColor( Color.BLUE );
            g.fillOval( (int)(x-2), (int)(y-2), 10, 10 );
        }
    }//END blueBalls

    public void addBalls()
    {
        // Creates a fast ball in each room
    	int redAdded = redCount++;
        redBalls[redAdded] = new redBall(200, 300);
        int blueAdded = blueCount++;
        blueBalls[blueAdded] = new blueBall(210, 300);

        // Creates a slow ball in each room
        redAdded = redCount++;
        redBalls[redAdded] = new redBall(500, 300);
        blueAdded = blueCount++;
        blueBalls[blueAdded] = new blueBall(510, 300);
    }//END addBalls
    
    public void moveBalls()
    {
		for (int i = 0; i < redCount; i++) 
		{
			redBalls[i].move(6*delta);
			//redBalls[i].drawMe();
		}
		for (int i = 0; i < blueCount; i++) 
		{
			blueBalls[i].move(2*delta);
		}
    }
    
    public void resetBalls()
    {
    	redCount = 0;
		blueCount = 0;
		redBalls = new redBall[1000];
		blueBalls = new blueBall[1000];
		addBalls();
    }
    
    public double[] getTemp()
    {
    	double tempLeft = 0.0;
    	double tempRight = 0.0;
    	
    	int redLeft = 0;
    	int blueLeft = 0;
    	int redRight = 0;
    	int blueRight = 0;
    	
  		for (int i = 0; i < redCount; i++)
  		{
  			if (redBalls[i].getx() <= 362)
  				redLeft++;
  			else if (redBalls[i].getx() > 362)
  				redRight++;
  		}
  		
  		for (int i = 0; i < blueCount; i++)
  		{
  			if (blueBalls[i].getx() <= 362)
  				blueLeft++;
  			else if (blueBalls[i].getx() > 362)
  				blueRight++;
  		}
    	tempLeft = redLeft *10 + blueLeft*3;
    	tempRight = redRight *10 + blueRight*3;
    	
    	double[] temperatures = new double[2];
    	temperatures[0] = tempLeft;
    	temperatures[1] = tempRight;
    	
    	return temperatures;
    }


	JFrame window = new JFrame("Maxwell's Demon");
	
    JPanel topPanel;
    JLabel tempLeft;
    JLabel tempRight;
    
    JPanel midPanel;
    //GameDisplay game;
    Game gamePanel;
        
    JPanel bottomPanel;
    JButton addButton = new JButton("add");
    JButton resetButton = new JButton("reset");;
    
    
    public Maxwell() 
    {
    	//create panels and buttons
    	topPanel = new JPanel();
    	topPanel.setBackground(Color.orange);
    	//topPanel.setPreferredSize(new Dimension(700,50));
    	tempLeft = new JLabel("Left Temp: ",SwingConstants.LEFT);
    	tempRight = new JLabel("Right Temp: ",SwingConstants.RIGHT);

    	topPanel.add(tempLeft);
    	topPanel.add(tempRight);
    	topPanel.setLayout(new GridLayout(1,2));
    	window.add(topPanel, BorderLayout.NORTH);
    	
       	gamePanel = new Game();
    	window.add(gamePanel);
    	
    	//bottom
    	bottomPanel = new JPanel();
    	setBackground(Color.orange);
    	window.add(bottomPanel, BorderLayout.PAGE_END);
    	
		bottomPanel.add(resetButton);
    	bottomPanel.add(addButton);
    	bottomPanel.setLayout(new GridLayout(1,2));
    		
    	//**********************************
    	//Animator a = new Animator();
    	//************************************
    	
    	class ButtonListener implements ActionListener 
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) 
    		{
    			if ( e.getActionCommand().equals("add")) 
    			{
    				addBalls();
    			}
    			else if ( e.getActionCommand().equals("reset")) 
    			{
    				resetBalls();
    			}
    		} // end void actionPerformed
        } // end class ButtonListener
    	
    	ButtonListener b = new ButtonListener();
		resetButton.addActionListener(b);
		addButton.addActionListener(b);
		resetButton.setActionCommand("reset");
		addButton.setActionCommand("add");
		
		
		//create initial state of game
		redCount = 0;
		blueCount = 0;
		redBalls = new redBall[1000];
		blueBalls = new blueBall[1000];
		addBalls();
		
		//mouseListener to open/close door
		gamePanel.addMouseListener(new MouseAdapter()
		{
            public void mousePressed( MouseEvent m ) 
            {
                //wallTimes++;
                gamePanel.openDoor();
                gamePanel.repaint();
            }
            public void mouseReleased( MouseEvent m) 
            {
                gamePanel.closeDoor();
                gamePanel.repaint();
            }
        });
		
		//tick
		Timer tick = new Timer(100, new Animator());
		tick.start();
		
		window.setSize(750,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
    }//END Maxwell
    
    public class Game extends JPanel 
    {	
    	boolean doorAppear = true;
        
        public void openDoor() 
        {
            doorAppear = false;
        }
        
        public void closeDoor() 
        {
            doorAppear = true;
        }
        
        public boolean isDoorThere()
        {
        	return doorAppear;
        }
		
	    public void paintComponent(Graphics g)
	    {
	    	super.paintComponent(g);
   
	        g.setColor(Color.pink);
	        g.fillRect(0, 0, 735, 420);
	        	
	        g.setColor(Color.black);
	        g.fillRect(362, 0, 10, 150);
	         
	        g.setColor(Color.black);
	        g.fillRect(362, 270, 10, 150);

	        if(doorAppear)
	        {
	        	g.setColor(Color.green);
	            g.fillRect(362, 150, 10, 120);
	        }
	         
	        for (int i = 0; i < redCount; i++) 
	        {
	        	redBalls[i].drawMe(g);
			}
	        
	        for (int i = 0; i < blueCount; i++) 
	        {
	        	blueBalls[i].drawMe(g);
			}
	        
	    }//END paintComponent()
    }///END Game
    
    public class Animator implements ActionListener
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			moveBalls();

			gamePanel.repaint();
		}
    }

    public static void main(String[] args) 
    {
		new Maxwell();
		//int resolution = Toolkit.getDefaultToolkit().getScreenResolution();
		//System.out.println("the !!!!! is : " + resolution);
	}
}


