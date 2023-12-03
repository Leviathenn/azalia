/**
 * @author PrestonWitzel
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldX, worldY;
	public int speed;
	public String direction = "down";
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public boolean collisionOn = false;
	public boolean waterCollision = false;
	public boolean showSolidArea = false;
	public int health = 100;
	
	public void draw(Graphics2D g2) {
		
	}
	
	public void update() {
		
	}
}
