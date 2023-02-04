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
	conran ran;
	Thread thread;
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
		
		Image image = null;
		try {
			image = ImageIO.read(new File("res/ran.jpg"));
            g.drawImage(image, 0, 0, null);		
		
		}catch(Exception e) {
			
		}
	}
	public void run() {
		while(true) {
			ran.update();
			repaint(); // cập nhất lại ví trí mới ;
			try {
				thread.sleep(20); // 20s 1 lần;
			} catch ( InterruptedException e) {
				
			}
		}
		
	}
	public void paintBg(Graphics g ) {
		
		g.fillRect(0, 0, 400, 400);		
		for(int i =0; i<20;i++)
			for(int j=0; j<20;j++) {
				g.setColor(Color.black);
				
				if(bg[i][j]==2) {
				g.setColor(Color.red);
				}
					
				g.fillRect(i*20+1, j*20+1, 18, 18);
			}
	
	}
}
