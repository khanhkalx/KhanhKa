package gamesnake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
public class framescreen extends JFrame {
     
	snake Snake;
	
	public framescreen() {
    	 Snake = new snake(); // gọi tên lớp;
    	 add(Snake);
    	 this.addKeyListener(new handler());
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     public static void main(String as[]) {
    	 framescreen f = new framescreen();
    	 f.setVisible(true); // chạy chương trình nếu đúng
    	 f.setSize(500,500); // kích thước bảng;
    	
    	
     }
     private class handler implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
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
