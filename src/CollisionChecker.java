/**
 * @author PrestonWitzel
 */

public class CollisionChecker {
	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

		int entityLeftCol = entityLeftWorldX / gp.tileSize;
		int entityRightCol = entityRightWorldX / gp.tileSize;
		int entityTopRow = entityTopWorldY / gp.tileSize;
		int entityBottomRow = entityBottomWorldY / gp.tileSize;

		String tileNum1, tileNum2;

		try {

			switch (entity.direction) {
			case "up":
				entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
				tileNum1 = gp.tm.mapTileNum[entityTopRow][entityRightCol];
				tileNum2 = gp.tm.mapTileNum[entityTopRow][entityLeftCol];
				boolean tile1collision = false;
				boolean tile2collision = false;

				if (!(tileNum1.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum1)].collision) {
						tile1collision = true;
					}
				} else if (tileNum1.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision = true;
					}
				}

				if (!(tileNum2.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum2)].collision) {
						tile2collision = true;
					}
				} else if (tileNum2.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision = true;
					}
				}

				if (tile1collision || tile2collision) {
					entity.collisionOn = true;
				}
				break;
			case "down":
				entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
				tileNum1 = gp.tm.mapTileNum[entityBottomRow][entityRightCol];
				tileNum2 = gp.tm.mapTileNum[entityBottomRow][entityLeftCol];
				boolean tile1collision2 = false;
				boolean tile2collision2 = false;

				if (!(tileNum1.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum1)].collision) {
						tile1collision2 = true;
					}
				} else if (tileNum1.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision2 = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision2 = true;
					}
				}

				if (!(tileNum2.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum2)].collision) {
						tile2collision2 = true;
					}
				} else if (tileNum2.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision2 = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision2 = true;
					}
				}

				if (tile1collision2 || tile2collision2) {
					entity.collisionOn = true;
				}
				break;
			case "left":
				entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
				tileNum1 = gp.tm.mapTileNum[entityTopRow][entityLeftCol];
				tileNum2 = gp.tm.mapTileNum[entityBottomRow][entityLeftCol];
				boolean tile1collision3 = false;
				boolean tile2collision3 = false;

				if (!(tileNum1.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum1)].collision) {
						tile1collision3 = true;
					}
				} else if (tileNum1.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision3 = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision3 = true;
					}
				}

				if (!(tileNum2.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum2)].collision) {
						tile2collision2 = true;
					}
				} else if (tileNum2.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision3 = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision3 = true;
					}
				}

				if (tile1collision3 || tile2collision3) {
					entity.collisionOn = true;
				}
				break;
			case "right":
				entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
				tileNum1 = gp.tm.mapTileNum[entityTopRow][entityRightCol];
				tileNum2 = gp.tm.mapTileNum[entityBottomRow][entityRightCol];
				boolean tile1collision4 = false;
				boolean tile2collision4 = false;

				if (!(tileNum1.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum1)].collision) {
						tile1collision4 = true;
					}
				} else if (tileNum1.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision4 = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum1.split(":")[0])].collision) {
						tile1collision4 = true;
					}
				}

				if (!(tileNum2.contains(":"))) {
					if (gp.tm.tile[Integer.valueOf(tileNum2)].collision) {
						tile2collision4 = true;
					}
				} else if (tileNum2.contains(":")) {
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision4 = true;
					}
					if (gp.tm.tile[Integer.valueOf(tileNum2.split(":")[0])].collision) {
						tile2collision4 = true;
					}
				}

				if (tile1collision4 || tile2collision4) {
					entity.collisionOn = true;
				}
				break;
			}

		} catch (Exception e) {
			entity.collisionOn = true;
		}
	}

	// public void checkTalker(Talker t) {
	// 	int ex = t.worldX;
	// 	int ey = t.worldY;

	// 	int dx = gp.player.worldX - ex;
	// 	int dy = gp.player.worldY - ey;

	// 	double dist = Math.sqrt(dx * dx + dy * dy);

	// 	if (dist <= (gp.tileSize * 1.1)) {
	// 		t.canTalk = true;
	// 	}
	// }
}
