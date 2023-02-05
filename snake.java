package gamesnake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.lang.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class snake extends JPanel implements Runnable {
	
 static	int [][] bg = new int [20][20];
 static int padding = 10;
 static int WIDTH =400;
 static int HEIGHT = 400;
 static boolean isPlaying = false;
 static boolean enableTextStartGame= true;
	conran ran;
	Thread thread;
	static boolean isGameOver = false;
	public snake() {
		
		ran = new conran();
		
	//	Data.loadImage();
		
		thread = new Thread(this);
		thread.start();
		
		
		bg[4][7]=2;
		
	}
	public void paint(Graphics g) {
		paintBg(g);
		ran.veran(g);
		vekhung(g);
		Image image = null;
//		try {
//			image = ImageIO.read(new File("res/ran.jpg"));
//            g.drawImage(image, 0, 0, null);		
//		
//		}catch(Exception e) {
//			
//		}
		if(!isPlaying) {
			g.setColor(Color.white);
			g.setFont(g.getFont().deriveFont(16.0f));
			g.drawString("Khánh Không Cho chơi phải bấm SPACE", 60 ,200);
		}
		if(isGameOver) {
			g.setColor(Color.white);
			g.setFont(g.getFont().deriveFont(28.0f));
			g.drawString("Game Over", 120 ,250);
		}
	}
	public void run() {
		long t=0;
		long t2=0;
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
		
		g.fillRect(0, 0, WIDTH+padding*2, HEIGHT+padding*2);
		
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
		g.drawRect(0, 0 , WIDTH+padding*2, HEIGHT+padding*2);
	    g.drawRect(1, 1, WIDTH+padding*2-2, HEIGHT+padding*2-2);
	    g.drawRect(2, 2, WIDTH+padding*2-4, HEIGHT+padding*2-4);
	
	}
}
