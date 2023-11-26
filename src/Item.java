/**
 * @author Leviathenn
 */

public class Item {
    String sID;
    char cId;
    int iID;
    String name;   
    
    public Item(String itemID){ 
        sID = itemID;
        iID = Integer.parseInt(sID.split(sID.substring(0, 1))[1]); //This is scuffed asf but it works. Im like notch i typed random shit into my computer and it worked. ~Leviathenn
        cId = sID.split(sID.split(sID.substring(0, 1))[1])[0].charAt(0); //Jesus i don't know how i made this
        
        

    }; 
    
   
}
