/**
 * @author PrestonWitzel
*/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	GamePanel gp;
	public String keyTyped;
	public boolean wPress = false;
	public boolean aPress = false;
	public boolean sPress = false;
	public boolean dPress = false;
	public boolean typing = false;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		handleKey(keyCode, true);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		handleKey(keyCode, false);
		
	}
	
	public void handleKey(int keyCode, boolean condition) {
		System.out.println(String.valueOf(KeyEvent.getKeyText(keyCode)).toLowerCase());
		if(condition) {
            keyTyped = String.valueOf(KeyEvent.getKeyText(keyCode)).toLowerCase();
        } else if(!condition) {
            keyTyped = "none";
        }

		if(keyCode == KeyEvent.VK_W) {
			wPress = condition;
		}
		if(keyCode == KeyEvent.VK_A) {
			aPress = condition;
		}
		if(keyCode == KeyEvent.VK_S) {
			sPress = condition;
		}
		if(keyCode == KeyEvent.VK_D) {
			dPress = condition;
		}
	}

}
