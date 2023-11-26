/**
 * @author PWITZEL, Leviathenn
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class TextBox {
	GamePanel gp;
	public int x;
	public int y;
	public int width;
	public int height;
	public int borderWeight;
	public boolean hidden = false;
    public boolean typing = false;
    public String text = "";
    public String prompt = ""; 
	Color bgColor;
	Color fgColor;
	Color borderColor;
    KeyHandler kh;
    MouseHandler mh;
    boolean keyPressed = false;
	
	public TextBox(GamePanel gp,int x,int y,int width,int height,String prompt,int borderWeight,
			Color bgColor,Color fgColor,Color borderColor) {
		this.gp=gp;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
        this.prompt=prompt;
		this.borderWeight=borderWeight;
		this.bgColor=bgColor;
		this.fgColor=fgColor;
		this.borderColor=borderColor;
        kh = gp.kh;
        mh = gp.mh;
	}
	public TextBox(GamePanel gp,int x,int y,int size,String prompt,int borderWeight,
			Color bgColor,Color fgColor,Color borderColor) {
		this.gp=gp;
		this.x=x;
		this.y=y;
		this.width=size;
		this.height=size/2;
        this.prompt=prompt;
		this.borderWeight=borderWeight;
		this.bgColor=bgColor;
		this.fgColor=fgColor;
		this.borderColor=borderColor;
        kh = gp.kh;
        mh = gp.mh;
	}
	
	public void update() {
		if(mh.clicked()) {
            if(mh.mouseX() > x && mh.mouseX() < x + width && mh.mouseY() > y && mh.mouseY() < y + height) {
                typing = true;
            } else  if(!(mh.mouseX() > x && mh.mouseX() < x + width && mh.mouseY() > y && mh.mouseY() < y + height)) {
                typing = false;
            }
        }

        if(typing) {
            if(!keyPressed) {
                if(!(kh.keyTyped.split("_")[1].equals("space"))) {
                    text = text + (kh.keyTyped.split("_")[1]);
                } else if(kh.keyTyped.split("_")[1].equals("space")) {
                    text = text + " ";
                }
                
            } else if(keyPressed) {
                if(kh.keyTyped.equals("none")) {
                    keyPressed = false;
                }
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

        //prompt text
        if(text.equals("")) {
             g2.setColor(fgColor.darker());
             g2.drawString(prompt, x + 2, y + 2);
        } 

	}
}