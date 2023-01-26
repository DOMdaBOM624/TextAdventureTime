
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
public class Room {
    private String description;
    private HashMap<String, Room> exits;
private HashMap<String, Item> inventory;


public void setItem(String name, Item item) {
        inventory.put(name, item);

    }
    public Item getItem(String name){
        return inventory.remove(name);
    }

    private String longDescription;
    public Room(String description, String longDescription) {
 this.longDescription = longDescription;
        this.description = description;
        exits = new HashMap<String, Room>();
        inventory = new HashMap<>();
    }

    public String getItemString() {
        String returnString = "Room Inventory: ";
        Set<String> keys = inventory.keySet();
        for (String item : keys) {
            returnString += " " + item;
        }
        return returnString;
    }

        private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit: keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    public String getLongDescription(){

        return longDescription + "\n" + getExitString() + "\n" + getItemString();
    }
    public void setExit(String direction, Room neighbor) {
        exits.put(direction,neighbor);

    }
    public Room getExit(String direction){
        return exits.get(direction);
    }
    public String getShortDescription(){
        return description;
    }
}