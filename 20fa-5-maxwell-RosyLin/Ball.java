import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import Maxwell.Ball;

public class Ball 
{
	private Maxwell game;
	int x, y;
	int vx, vy;
	double oldx, oldy;
	
   public Ball(Maxwell game) 
   {
   	this.game= game;
   }
  				
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
		if (game.isDoorThere())
		{
			
		}
		// Check bounces off each edge of screen
		if (x < 0)
			vx *= -1;
		if (x > 740)
			vx *= -1;
		if (y < 0)
			vy *= -1;
		if (y > 490)
			vy *= -1;
	}
}

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
        g.fillOval( (int)(x-2), (int)(y-2), 5, 5 );
    }
}

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
        g.setColor( Color.blue );
        g.fillOval( (int)(x-2), (int)(y-2), 5, 5 );
    }
}


public class Animator implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for (int i = 0; i < redCount; i++) 
		{
			redBalls[i].move(0.1);
		}
		for (int i = 0; i < blueCount; i++) 
		{
			blueBalls[i].move(0.1);
		}		
	game.repaint();
	}
}