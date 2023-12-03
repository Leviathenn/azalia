/**
 * @author Leviathan, PrestonWitzel
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

 public class Button {
    GamePanel gp;
	public int x;
	public int y;
	public int width;
	public int height;
	public int borderWeight;
    public String text = "";
	Color bgColor;
	Color fgColor;
	Color borderColor;
    MouseHandler mh;

    public Button(GamePanel gp,int x,int y,int width,int height,String text,int borderWeight,
			Color bgColor,Color fgColor,Color borderColor){
        this.gp=gp;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
        this.text=text;
		this.borderWeight=borderWeight;
		this.bgColor=bgColor;
		this.fgColor=fgColor;
		this.borderColor=borderColor;
        mh = gp.mh;
    }

    public Button(GamePanel gp,int x,int y,int size,String text,int borderWeight,
			Color bgColor,Color fgColor,Color borderColor){
        this.gp=gp;
		this.x=x;
		this.y=y;
		this.width=size;
		this.height=size/2;
        this.text=text;
		this.borderWeight=borderWeight;
		this.bgColor=bgColor;
		this.fgColor=fgColor;
		this.borderColor=borderColor;
        mh = gp.mh;
    }

    public void update() {
        if(mh.clicked()) {
            if(mh.mouseX() > x && mh.mouseX() < x + width && mh.mouseY() > y && mh.mouseY() < y + height) {
                //mouse event code
            }
        }
    }

    public void draw(Graphics2D g2) {
        //background
		g2.setColor(bgColor);
        g2.fillRect(x, y, width, height);

        //border
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWeight));
        g2.drawRect(x-borderWeight, y-borderWeight, width, height);
        g2.setStroke(new BasicStroke(1));

        //text
        g2.setColor(fgColor);
        g2.drawString(text, x + 2, y + 2);
    }
 }