/**
 * @author PrestonWitzel
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
	final int scale = 3;
	final int FPS = 60;
	
	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public int screenHeight = tileSize * maxScreenRow;

    public String map = "";

    Thread gameThread;
    public Inventory i = new Inventory();
    public GameStates state = GameStates.MENU;
    public MouseHandler mh = new MouseHandler(this);
    public KeyHandler kh = new KeyHandler(this);
    public TextBox myTextBox = new TextBox(this, 100, 100, 100, "Enter Name...",2,Color.BLUE, Color.WHITE, Color.GRAY);
    Player player = new Player(this, kh);
    public TileManager tm = new TileManager(this);

    public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
        this.addKeyListener(kh);
		this.setFocusable(true);
        this.addMouseListener(mh);
        this.addMouseMotionListener(mh);

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
        myTextBox.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(150,150,150));
        g2.fillRect(0, 0, screenWidth, screenHeight);
        myTextBox.draw(g2);
        g2.dispose();
    }
}
