import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {
    final int FPS = 60;

    public final int screenWidth = 1000;
    public final int screenHeight = 500;

    Thread gameThread;
    GameStates state = GameStates.MENU;

    public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		this.setFocusable(true);

		startGame();
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null) {
            update();
            repaint();

            try {
                Thread.sleep(1000/FPS);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        switch(state) {
            case MENU:

                break;
			case GAMEPLAY:
				break;
			case INVENTORY:
				break;
			case PAUSE:
				break;
			case SHOP:
				break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(150,150,150));
        g2.fillRect(0, 0, screenWidth, screenHeight);
        switch(state) {
            case MENU:

                break;
			case GAMEPLAY:
				break;
			case INVENTORY:
				break;
			case PAUSE:
				break;
			case SHOP:
				break;
        }
        g2.dispose();
    }
}
