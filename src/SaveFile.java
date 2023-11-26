/**
 * @author Leviathenn
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Leviathenn
 */


import org.ini4j.*;

public class SaveFile{
    public static void ParseSave(){
        File file = new File("bin/game.zsf");
        try (FileReader fReader = new FileReader(file)) {
            Ini fIni = new Ini(fReader);
            int health = Integer.parseInt(fIni.get("Save", "health"));
            Utils.print(health);
            Inventory i = new Inventory();
            Armor armor = new Armor("a0");
           // i.AddItem(armor);
            //Utils.print(i.items);
            

        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            Utils.print("Unable to find save file, creating a new one");
    
        }


    }
}