 package gamesnake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;


import javax.swing.JPanel;
import javax.swing.Timer;
public class background extends JPanel implements Runnable   {
 private Timer timer;
 static private long time ;
 static private long minute ;
 static	int [][] bg = new int [20][20];
 static int padding = 10;
 static int WIDTH =400;
 static int HEIGHT = 400;
 static boolean isPlaying = false;
 static boolean enableTextStartGame= true;
	conran ran;
	Thread thread;
	static int CurrentLevel = 1;
	static boolean isGameOver = false;
	static int CurrentPoint = 0;
	public background() {
		ran = new conran();
		
		thread = new Thread(this);
		thread.start();
		Random R = new Random();
		int t = R.nextInt(19);
		bg[t][t]= 2;
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				time++;
				
				
			}
		});
		
		
		
	}
	public void paint(Graphics g) {
		paintBg(g);
		ran.veran(g);
		vekhung(g);		
		if(isPlaying) {
			timer.start();
			g.setColor(Color.white);
			g.setFont(g.getFont().deriveFont(18.0f));	
			g.drawString("Time: "+ minute+":"+time, 450 ,200);
		}
	    if(time == 60) {
	    	time = 0;
	    	minute++;
	    	
	    }
	// tạm dừng game	
		if(!isPlaying) {
			
			g.setColor(Color.white);
			g.setFont(g.getFont().deriveFont(16.0f));			
			g.drawString("ON SPACE TO CONTINUE", 80 ,200);
		}
    // Thua cuộc
		if(isGameOver) {
			time =0;
			g.setColor(Color.white);
			g.setFont(g.getFont().deriveFont(28.0f));
			g.drawString("Game Over", 120 ,250);
			
			
		}

		g.setColor(Color.white);
		g.setFont(g.getFont().deriveFont(28.0f));
		g.drawString("LEVEL: "+CurrentLevel, 450 ,100);
		
		g.setColor(Color.red);
		g.setFont(g.getFont().deriveFont(20.0f));
		g.drawString("Point: "+CurrentPoint, 450 ,150);
		
		
	}
	
	public void run() {
		long t=0;
		long t2=0;
		// thay đổi tốc độ
		while(true) {
			if(System.currentTimeMillis()-t2>500) {
				enableTextStartGame=!enableTextStartGame;
				t2 = System.currentTimeMillis();
			}
			
			if(isPlaying) {
				if(System.currentTimeMillis()-t>200) {
					t=System.currentTimeMillis();
				}
				ran.update();
			}		
         		repaint(); // cập nhất lại ví trí mới ;
			try {
				thread.sleep(20); // 20s 1 lần;
			} catch ( InterruptedException e) {
				
			}
		}
		
	}
	public void paintBg(Graphics g ) {
	// hình nền	
		g.fillRect(0,0, WIDTH+padding*2+200, HEIGHT+padding-10);
		
		for(int i =0; i<20;i++)		
			for(int j=0; j<20;j++) {
				g.setColor(Color.black);
				
				if(bg[i][j]==2) {
				g.setColor(Color.red);
				}
					
				g.fillRect(i*20+1, j*20+1, 18, 18);
				
				
			}
		
		
	
	}
	private void vekhung(Graphics g) {
		g.setColor(Color.orange);
		g.drawRect(0, 0 , WIDTH+padding-14, HEIGHT+padding-14);
	    g.drawRect(1, 1, WIDTH+padding*2-24, HEIGHT+padding*2-24);
	    g.drawRect(2, 2, WIDTH+padding*2-24, HEIGHT+padding*2-24);
	   
	
        g.drawRect(0, 0 , WIDTH+padding+210, HEIGHT+padding-12);
	    g.drawRect(1, 1, WIDTH+padding*2-2+200, HEIGHT+padding*2-22);
	    g.drawRect(2, 2, WIDTH+padding*2-4+200, HEIGHT+padding*2-22);
	}
}
