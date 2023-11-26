/**
 * @author Leviathenn
 */
import java.util.ArrayList;

public class Inventory {
    public ArrayList<Item> items = new ArrayList<Item>();
    public void AddItem(Item item){
        items.add(item);
    }  
    public void RemoveItem(Item item)
    {
        items.remove(item);
    }
    
    public Category GetCategory(char sChar){
        Category d = null;
        switch (sChar) {
            case 'a':
                d = Category.ARMOR;
                break;
            case 'c':
                d = Category.COLLECTABLES;
                break; 
            case 'f':
                d = Category.FOOD;
                break;
            case 'm':
                d = Category.MAGIC;
                break;
            default:  
                d = Category.UNKNOWN;                   
                break;
        }
        return d;  
    }
}
