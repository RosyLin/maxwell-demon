import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import responsive.Bounce.Ball;

import java.lang.Math.*;

public class Maxwell extends JFrame
{
	Ball[] balls;
	int ballCount;
	
	JFrame window = new JFrame("Maxwell's Demon");;
	
    JPanel topPanel;
    JLabel tempLeft;
    JLabel tempRight;
    
    JPanel midPanel;
    //GameDisplay game;
    
    JPanel bottomPanel;
    JButton addButton = new JButton("add");
    JButton resetButton = new JButton("reset");;
    
    class ButtonListener implements ActionListener 
    {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if ( e.getActionCommand().equals("reset")) 
			{
				
			}
			else
			{
				
			}
		}//END void actionPerformed
		
    }//END class ButtonListener
    
    public Maxwell() 
    {
    	window.setSize(750, 500);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//create panels and buttons
    	topPanel = new JPanel();
    	topPanel.setBackground(Color.orange);
    	tempLeft = new JLabel("Left Temp: ",SwingConstants.LEFT);
    	tempRight = new JLabel("Right Temp: ",SwingConstants.RIGHT);
    	
    	window.add(topPanel, BorderLayout.NORTH);
    	topPanel.setLayout(new GridLayout(1,2));
    	topPanel.add(tempLeft);
    	topPanel.add(tempRight);
    	
    	//middle
    	midPanel = new JPanel();
    	midPanel.setBackground(Color.gray);
    	window.add(midPanel, BorderLayout.CENTER);
    	
    	paintDoor game = new paintDoor();
    	window.add(game);
    	
    	//bottom
    	bottomPanel = new JPanel();
    	setBackground(Color.orange);
    	window.add(bottomPanel, BorderLayout.SOUTH);
    	
		bottomPanel.setLayout(new GridLayout(1,2));
    	bottomPanel.add(resetButton);
    	bottomPanel.add(addButton);
    	
    	ButtonListener b = new ButtonListener();
		resetButton.addActionListener(b);
		addButton.addActionListener(b);
		resetButton.setActionCommand("reset");
		addButton.setActionCommand("add");
    	
		//mouseListener to open/close door
		window.addMouseListener(new MouseAdapter()
		{
            public void mousePressed( MouseEvent m ) 
            {
                //wallTimes++;
                game.openDoor();
                game.repaint();
            }
            public void mouseReleased( MouseEvent m) 
            {
                game.closeDoor();
                game.repaint();
            }
        });

		window.setVisible(true);
    }
    
    public class paintDoor extends JComponent 
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
        
        public void paint(Graphics g) 
        {
        	g.setColor(Color.black);
            g.fillRect(362, 0, 10, 150);
            
            g.setColor(Color.black);
            g.fillRect(362, 275, 10, 150);
            
            if(doorAppear)
            {
            	g.setColor(Color.green);
                g.fillRect(362, 150, 10, 125);
            }
        }    
    }//END Maxwell()
    
    public class Ball 
    {

		int x, y;
		int vx, vy;
		double oldx, oldy;
		
		public Ball() {
			x = (int) (Math.random() * 400 + 100); // [100, 500)
			y = (int) (Math.random() * 400 + 100);

			vx = (int) (Math.random() * 100 - 50); // [-50, 50)
			vy = (int) (Math.random() * 100 - 50);
		}

		public Ball(int xClick, int yClick) {
			x = xClick;
			y = yClick;

			vx = (int) (Math.random() * 100 - 50); // [-50, 50)
			vy = (int) (Math.random() * 100 - 50);
		}
    }
    
    
    public static void main(String[] args) 
    {
		new Maxwell();
	}
}

