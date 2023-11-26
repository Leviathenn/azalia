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
    boolean isBroken;

    public Armor(String itemID){
        super(itemID);
        int index = iID;
        Name = ArmorNames[index];
        Durabilty = ArmorDurrabilties[index];
        Damage = ArmorDamages[index];
        isBroken = false;

    } 


    void Break(){
        isBroken = true;
    }
}