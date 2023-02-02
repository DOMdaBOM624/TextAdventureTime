import java.util.HashMap;
import java.util.Set;

public class Player {
    private HashMap<String, Item> inventory;

    Player() {
        inventory = new HashMap<>();
    }

    public void setItem(String name, Item item) {
        inventory.put(name, item);

    }

    public Item getItem(String name) {
        return inventory.remove(name);
    }

    public String getItemString() {
        String returnString = "Player Inventory: ";
        Set<String> keys = inventory.keySet();
        for (String item : keys) {
            returnString += " " + item;
        }
        return returnString;
    }
public  HashMap getInventory(){
        return inventory;
}



}