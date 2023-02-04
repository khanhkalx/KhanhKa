package gamesnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class conran {

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
	public void setVector(int v) {
		if(Vector != -v)
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
	
	public void update() {
		if(System.currentTimeMillis()-t1>500) {
			
			if(snake.bg[x[0]][y[0]]==2) {
				dodai++;
				snake.bg[x[0]][y[0]]=0;
				snake.bg[layToaDoMoi().x][layToaDoMoi().y]=2;
			}
			
			for(int i=dodai-1;i>0;i--) {
				x[i]= x[i-1];
				y[i]=y[i-1];
			}
			
			if(Vector == conran.Go_UP) y[0]--;
			if(Vector == conran.Go_DOWN) y[0]++;
			if(Vector == conran.Go_LEFT) x[0]--;
			if(Vector == conran.Go_RIGHT) x[0]++;
			
			if(x[0]<0) x[0]=19;
			if(x[0]>19) x[0] = 0;
			if(y[0]<0) y[0]=19;
			if(y[0]>19) y[0] = 0;
			
			t1 = System.currentTimeMillis();
		}
		
	}
	
	
	public void veran(Graphics g) {
		g.setColor(Color.red);
		for(int i =0; i< dodai;i++) {
			g.fillRect(x[i]*20+1, y[i]*20+1, 18, 18);
			
	//		g.drawImage(Data.imageBody, x[i]*20 , y[i]*20 ,null);
			
	//		g.drawImage(Data.imageHead, x[0]*20-6 , y[0]*20-6 ,null);
		}
	}
	
	
}
