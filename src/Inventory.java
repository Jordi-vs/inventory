import java.util.HashMap;
import java.util.List;

public class Inventory {
    HashMap<String, Item> itemHashMap;

    public Inventory(){
        this.itemHashMap = new HashMap<>();
    }

    public Item addItem(Item itemToAdd) {
        return this.itemHashMap.put(itemToAdd.getName(), itemToAdd);
    }

    public Item removeItem(Item itemToRemove) {
        return this.itemHashMap.remove(itemToRemove);
    }

    public Item removeItem(String itemNameToRemove) {
        return this.itemHashMap.remove(itemNameToRemove);
    }

    public boolean containsItem(String itemContained){
        return this.itemHashMap.containsKey(itemContained);
    }

    public Item getItem(String itemToGet){
        return this.itemHashMap.get(itemToGet);
    }

    public void printInventory(){
        for(Item i : itemHashMap.values()){
            System.out.println(i.toString());
        }
    }
}
