package gamesnake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
public class framescreen extends JFrame {
     
	background Snake;
	private static ArrayList<User> users;
	public framescreen() {
    	 Snake = new background(); // gọi tên lớp;
    	 add(Snake);
    	 this.addKeyListener(new handler());
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 
    	 
     }
     public static void main(String as[]) {
    	 framescreen f = new framescreen();
//    	 framescreen t = new framescreen();
//    	 t.setVisible(true);
    	 f.setVisible(true); // chạy chương trình nếu đúng
    	 f.setSize(640,440); // kích thước bảng;
    	 f.setTitle("Rắn Săn Mồi");
    	
    	
     }
     private class handler implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode()== KeyEvent.VK_SPACE) {
				background.isPlaying = !background.isPlaying;
				if(background.isGameOver) {
					background.isGameOver = !background.isGameOver;
                    Snake.ran.resetGame();				
				}
			}
			
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				 Snake.ran.setVector(conran.Go_UP);
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {
				Snake.ran.setVector(conran.Go_DOWN);
			}
			if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				Snake.ran.setVector(conran.Go_LEFT);
			}
			if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				Snake.ran.setVector(conran.Go_RIGHT);
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}
    	 
     }

    
     
     
}
