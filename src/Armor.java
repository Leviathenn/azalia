/**
 * @author Leviathenn
 
*/


public class Armor extends Item {
    private String[] ArmorNames = {"Cracked Bat","Stone Chestplate", "Stone Helment"};
    private int[] ArmorDurrabilties = {100,232, 115};
    private int[] ArmorDamages = {8,0,0};
    String Name; 
    int Durabilty;
    int Damage;
    Inventory i;
    public Armor(String itemID, Inventory inv){
        super(itemID);
        int index = iID;
        Name = ArmorNames[index];
        Durabilty = ArmorDurrabilties[index];
        Damage = ArmorDamages[index];
        i = inv;

    } 


    void Break(){
        i.RemoveItem(this); 
    }
}