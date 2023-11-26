/**
 * @author Leviathenn
 */

public class Item {
    String sID;
    int iID;
    String name;   
    public Item(String itemID){ 
        sID = itemID;
        iID = Integer.parseInt(sID.split(sID.substring(0, 1))[1]); //This is scuffed asf but it works. Im like notch i typed random shit into my computer and it worked. ~Leviathenn
    
        

    }; 
    
   
}
