/**
 * @author Leviathenn
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ini4j.*;

public class SaveFile{

  

    GamePanel gp;

    public SaveFile(GamePanel gp) {
        this.gp=gp;
    }
    
    void ParseSave(){
        Inventory i = gp.i;
        File file = new File("bin/game.asf"); 
        try (FileReader fReader = new FileReader(file)) { 
            Ini fIni = new Ini(fReader);
            int health = Integer.parseInt(fIni.get("Save", "health"));
            Utils.print(health);
            String sInvR = fIni.get("Save","playerInventory");
            String[] sInv = sInvR.split(",");
            for (String item : sInv) {
                Item iItem = new Item(item);
                Category itemCat = i.GetCategory(iItem.cId);
                switch (itemCat) {
                    case ARMOR:
                        Armor armor = new Armor(item, i);
                        i.AddItem(armor);
                        
                        break;
                    case FOOD:
                    break;
                    case COLLECTABLES:
                    break;
                    case MAGIC:
                    break;
                    default:
                        break;
                }
            }
            
            Utils.print(i.items);

        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            Utils.print("Unable to find save file, creating a new one");
    
        }


    }
}