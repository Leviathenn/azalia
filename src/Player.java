/**
 * @author PrestonWitzel, Leviathan
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler kh;

	public int invCurrent = 0;
	public long useTimer = 0;

	public Player(GamePanel gp, KeyHandler kh) {
		this.gp = gp;
		this.kh = kh;

		setDefaultValues();

	}

	public void setDefaultValues() {
		//this.worldX = gp.tm.spawnPointX;
		//this.worldY = gp.tm.spawnPointY;
		this.worldX = 0;
        this.worldY = 0;
        this.speed = 2;

		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		showSolidArea = false;

		getEntityImage();
	}

	public void getEntityImage() {
		try {
			this.up1 = ImageIO.read(this.getClass().getResourceAsStream("/player/up1.png"));
			this.up2 = ImageIO.read(this.getClass().getResourceAsStream("/player/up2.png"));
			this.down1 = ImageIO.read(this.getClass().getResourceAsStream("/player/down1.png"));
			this.down2 = ImageIO.read(this.getClass().getResourceAsStream("/player/down2.png"));
			this.left1 = ImageIO.read(this.getClass().getResourceAsStream("/player/left1.png"));
			this.left2 = ImageIO.read(this.getClass().getResourceAsStream("/player/left2.png"));
			this.right1 = ImageIO.read(this.getClass().getResourceAsStream("/player/right1.png"));
			this.right2 = ImageIO.read(this.getClass().getResourceAsStream("/player/right2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (kh.wPress || kh.aPress || kh.sPress || kh.dPress && !kh.typing) {
			if (kh.wPress) {
				direction = "up";

			}
			else if (kh.aPress) {
				direction = "left";

			}
			else if (kh.sPress) {
				direction = "down";

			}
			else if (kh.dPress) {
				direction = "right";

			}

			collisionOn = false;
			waterCollision = false;
			gp.cc.checkTile(this);
	
			if(waterCollision) {
				this.speed = 2;
			} else if(!waterCollision) {
				this.speed = 3;
			}

			if (collisionOn == false) {
				switch (direction) {
				case "up":
					this.worldY -= this.speed;
					break;
				case "down":
					this.worldY += this.speed;
					break;
				case "left":
					this.worldX -= this.speed;
					break;
				case "right":
					this.worldX += this.speed;
					break;
				}
			}

			spriteCounter++;
			if (spriteCounter > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
		

	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}

			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}

			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}

			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}

			break;
		}
		
		

		if (!waterCollision) {
			g2.drawImage(image, (gp.screenWidth / 2) - (gp.tileSize / 2), (gp.screenHeight / 2) - (gp.tileSize / 2),
					gp.tileSize, gp.tileSize, null);
		} else if (waterCollision) {
			g2.drawImage(image, (gp.screenWidth / 2) - (gp.tileSize / 2), (gp.screenHeight / 2) - (gp.tileSize / 2),
					((gp.screenWidth / 2) - (gp.tileSize / 2)) + gp.tileSize,
					((gp.screenHeight / 2) - (gp.tileSize)) + gp.tileSize, 0, 0, 0 + 16, 0 + 8, null);
		}
		
		if(showSolidArea) {
			g2.setColor(Color.red);
			g2.setStroke(new BasicStroke(3));
			g2.drawRect(((gp.screenWidth / 2) - (gp.tileSize / 2)) + solidArea.x, ((gp.screenHeight / 2) - (gp.tileSize / 2)) + solidArea.y, solidArea.width, solidArea.height);

		}
		
		
		
	}

}
