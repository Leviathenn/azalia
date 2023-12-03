/**
 * @author PrestonWitzel
 */

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public String[][] mapTileNum;
	public int spawnPointX;
	public int spawnPointY;

	public TileManager(GamePanel gp) {
		this.gp = gp;
		this.tile = new Tile[15];
		this.getTileImage();

		this.loadMap();
	}

	public void getTileImage() {
		try {
			this.tile[1] = new Tile();
			this.tile[1].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/grass.png"));

			this.tile[2] = new Tile();
			this.tile[2].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/wall.png"));
			this.tile[2].collision = true;

			this.tile[3] = new Tile();
			this.tile[3].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/water.png"));
			this.tile[3].waterCollision = true;

			this.tile[4] = new Tile();
			this.tile[4].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/earth.png"));

			this.tile[13] = new Tile();
			this.tile[13].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/tree.png"));
			this.tile[13].collision = true;
			this.tile[13].stackable = true;

			this.tile[6] = new Tile();
			this.tile[6].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/sand.png"));

			this.tile[7] = new Tile();
			this.tile[7].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/grass_pink.png"));

			this.tile[8] = new Tile();
			this.tile[8].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/tree_yellow.png"));
			this.tile[8].collision = true;
			this.tile[8].stackable = true;

			this.tile[9] = new Tile();
			this.tile[9].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/tree_pink.png"));
			this.tile[9].collision = true;
			this.tile[9].stackable = true;

			this.tile[0] = new Tile();
			this.tile[0].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/flowers.png"));
			this.tile[0].stackable = true;

			this.tile[10] = new Tile();
			this.tile[10].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/sand_clutter.png"));
			this.tile[10].collision = true;
			this.tile[10].stackable = true;

			this.tile[11] = new Tile();
			this.tile[11].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/water_flow.png"));
			this.tile[11].stackable = true;

			this.tile[12] = new Tile();
			this.tile[12].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/spawn.png"));
			this.tile[12].stackable = true;
			
			this.tile[5] = new Tile();
			this.tile[5].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/wood_floor.png"));
			
			this.tile[14] = new Tile();
			this.tile[14].image = ImageIO.read(this.getClass().getResourceAsStream("/tiles/door.png"));
			this.tile[14].stackable = true;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMap() {
		try {
			String filePath = "/maps/" + gp.map + ".tmap";
			final InputStream is = this.getClass().getResourceAsStream(filePath);
			final BufferedReader br = new BufferedReader(new InputStreamReader(is));
			final InputStream is2 = this.getClass().getResourceAsStream(filePath);
			final BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));

			int height = 0;
			int width = 0;
			String initLine;
			while ((initLine = br2.readLine()) != null) {
				height++;
				width = initLine.split(" ").length;
			}

			this.mapTileNum = new String[height][width];

			int row = 0;
			String line;

			while ((line = br.readLine()) != null) {
				String[] numbers = line.split(" ");
				for (int j = 0; j < mapTileNum[0].length; j++) {

					if (numbers[j].contains(":")) {

						String[] split = numbers[j].split(":");
						
                        if(split[0].equals("12") || split[1].equals("12")) {

							spawnPointX = j * gp.tileSize;
							spawnPointY = row * gp.tileSize;
							
                        }

						mapTileNum[row][j] = numbers[j];

					} else if (!numbers[j].contains(":")) {
						if(numbers[j].equals("12")) {

							spawnPointX = j * gp.tileSize;
							spawnPointY = row * gp.tileSize;
							
                        }

						mapTileNum[row][j] = numbers[j];
					}

				}

				row++;
			}

			br2.close();
			br.close();
		} catch (Exception ex) {
		}
	}

	public void draw(Graphics2D g2) {

		int offsetX = ((gp.screenWidth / 2) - (gp.tileSize / 2)) - gp.player.worldX;
		int offsetY = ((gp.screenHeight / 2) - (gp.tileSize / 2)) - gp.player.worldY;

		for (int i = 0; i < mapTileNum.length; i++) {
			for (int j = 0; j < mapTileNum[0].length; j++) {
				int tileX = j * gp.tileSize + offsetX;
				int tileY = i * gp.tileSize + offsetY;
				if (!(tileX > gp.screenWidth || tileX + gp.tileSize < 0 || tileY > gp.screenHeight
						|| tileY + gp.tileSize < 0)) {
					if (!(mapTileNum[i][j].contains(":"))) {
						g2.drawImage(tile[Integer.valueOf(mapTileNum[i][j])].image, tileX, tileY, gp.tileSize, gp.tileSize, null);

					} else if (mapTileNum[i][j].contains(":")) {
                        String[] split = mapTileNum[i][j].split(":");
						
						g2.drawImage(tile[Integer.valueOf(split[0])].image, tileX, tileY, gp.tileSize, gp.tileSize, null);
						g2.drawImage(tile[Integer.valueOf(split[1])].image, tileX, tileY, gp.tileSize, gp.tileSize, null);

						
					}
				}

			}
		}

	}
}
