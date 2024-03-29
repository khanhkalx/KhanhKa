package gamesnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;

public class conran {
    private static Image snakeImage;
	private static final int GO_UP = 0;
	int dodai = 3;
	int []x;
	int []y;
	
	public static int Go_UP = 1;
	public static int Go_DOWN = -1;
	public static int Go_LEFT = 2;
	public static int Go_RIGHT = -2;
	
	int Vector = conran.Go_DOWN;
	
	long t1 =0;
	int speed =200;
	int maxLen = 10;
	boolean udAfterChangeVt = true ;
	public conran() {
		x = new int [20];
		y = new int [20];
		
		x[0] = 5;
		y[0] = 4;
		
		x[1]= 5;
		y[1]=3;
		
		x[2]=5;
		y[2]=2;
		
		
	}
	public void resetGame() {
		x = new int [20];
		y = new int [20];
		background.CurrentPoint =0;
		background.CurrentLevel = 1;
		x[0] = 5;
		y[0] = 4;
		
		x[1]= 5;
		y[1]=3;
		
		x[2]=5;
		y[2]=2;
		
		dodai =3;
		
		Vector = conran.Go_DOWN;
	}
	public void setVector(int v) {
		if(Vector != -v )
		Vector = v;
		
		
	}
	public boolean toaDoCoNamTrongThanRan(int x1, int y1) {
		for(int i =0 ; i<dodai;i++) {
			if(x[i]==x1 && y[i]==y1) return true;
			return false;
		}
		return false;
	}
	
	public Point layToaDoMoi() {
		Random r = new Random();
		int x;
		int y;
		do {
			 x = r.nextInt(19);
			 y = r.nextInt(19);
		}while(toaDoCoNamTrongThanRan(x,y));
				
		
		return new Point(x,y);
	}
	public int getSpeed() {
		int speed = 200;
		for (int i = 0; i < background.CurrentLevel; i++) {
		      speed*=0.8;
			  return speed;
		}
		return speed;
	}
	public void update() {
		if(dodai == maxLen) {
		  	background.isPlaying=false;
		//	resetGame();
		  	dodai = 3;
			background.CurrentLevel++;
			maxLen +=5;
			speed = getSpeed();
		}
		
		for(int i =1;i<dodai;i++) {
			if(x[0]==x[i] && y[0]==y[i]) {
				background.isPlaying=false;
				background.isGameOver= true;
				resetGame();
				background.CurrentLevel=1;
				background.CurrentPoint=0;
			}
		}
		
		if(System.currentTimeMillis()-t1>speed) {
			
			if(background.bg[x[0]][y[0]]==2) {
				background.CurrentPoint+=100;
				dodai++;
				background.bg[x[0]][y[0]]=0;
				background.bg[layToaDoMoi().x][layToaDoMoi().y]=2;
			}
			
			for(int i=dodai-1;i>0;i--) {
				x[i]= x[i-1];
				y[i]=y[i-1];
			}
			
			if(Vector == conran.Go_UP) y[0]--;
			if(Vector == conran.Go_DOWN) y[0]++;
			if(Vector == conran.Go_LEFT) x[0]--;
			if(Vector == conran.Go_RIGHT) x[0]++;
		
			
			if(x[0]<0 || x[0]>19 || y[0]<0 || y[0]>19) {
				background.isGameOver = true;
				background.isPlaying=false;
				resetGame();
			}
			t1 = System.currentTimeMillis();
		}
		
	}
	
	public void veran(Graphics g) {
		g.setColor(Color.red);
		
		for(int i =0; i< dodai;i++) {
			g.fillRect(x[i]*20+1, y[i]*20+1, 18, 18);
			
		}
	}
	
	
	
}
