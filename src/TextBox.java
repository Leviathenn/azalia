/**
 * @author PWITZEL, Leviathenn
 */

import java.awt.Color;
import java.awt.Graphics2D;

public class TextBox {
	GamePanel gp;
	public int x;
	public int y;
	public int width;
	public int height;
	public int size;
	public int borderWeight;
	public boolean hidden = false;
    public boolean typing = false;
	Color bgColor;
	Color fgColor;
	Color borderColor;
	
	public TextBox(GamePanel gp,int x,int y,int width,int height,int borderWeight,
			Color bgColor,Color fgColor,Color borderColor) {
		this.gp=gp;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.borderWeight=borderWeight;
		this.bgColor=bgColor;
		this.fgColor=fgColor;
		this.borderColor=borderColor;
	}
	public TextBox(GamePanel gp,int x,int y,int size,int borderWeight,
			Color bgColor,Color fgColor,Color borderColor) {
		this.gp=gp;
		this.x=x;
		this.y=y;
		this.width=size;
		this.height=size/2;
		this.borderWeight=borderWeight;
		this.bgColor=bgColor;
		this.fgColor=fgColor;
		this.borderColor=borderColor;
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g2) {
		
	}
}
