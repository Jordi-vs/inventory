import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10000000; i++) {
            inventory.addItem(new Item("item #" + i, i, i+10));
        }
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("""
                    Please select an option by typing the number:
                    1. Print out the list of items in the inventory
                    2. Add a new item to the inventory
                    3. Remove an item from the inventory
                    4. Edit the price of an item
                    5. Edit the quantity of an item
                    6. Print out specific item
                    7. Quit the program""");
            String selection = input.nextLine();
            switch (selection) {
                case "1" -> inventory.printInventory();
                case "2" -> addItem(inventory, input);
                case "3" -> removeItem(inventory, input);
                case "4" -> editPrice(inventory, input);
                case "5" -> editQuantity(inventory, input);
                case "6" -> printItem(inventory, input);
                case "7" -> running = false;
                default -> System.out.println("INCORRECT INPUT TRY AGAIN");
            }
        }
    }

    private static void printItem(Inventory inventory, Scanner input) {
        String itemName = getOldItemName(inventory, input);
        System.out.println(inventory.getItem(itemName));
    }

    private static void editQuantity(Inventory inventory, Scanner input) {
        String itemName = getOldItemName(inventory, input);
        Item item = inventory.getItem(itemName);
        System.out.println("What is the new quantity");
        item.setQuantity(input.nextInt());
    }

    private static void editPrice(Inventory inventory, Scanner input) {
        String itemName = getOldItemName(inventory, input);
        Item item = inventory.getItem(itemName);
        System.out.println("What is the new price?");
        item.setPrice(input.nextDouble());
    }

    private static String getOldItemName(Inventory inventory, Scanner input) {
        String itemName;
        System.out.println("What is the name of the item?");
        while (true) {
            itemName = input.nextLine();
            if (inventory.containsItem(itemName)) break;
            else System.out.println("This item doesn't exist");
        }
        return itemName;
    }

    private static String getNewItemName(Inventory inventory, Scanner input) {
        String itemName;
        System.out.println("What is the name of the item?");
        while (true) {
            itemName = input.nextLine();
            if (!inventory.containsItem(itemName)) break;
            else System.out.println("Item with this name already exists");
        }
        return itemName;
    }

    private static void removeItem(Inventory inventory, Scanner input) {
        System.out.println("What is the name of the item?");
        if(inventory.removeItem(input.nextLine()) == null) System.out.println("This item does not exist in the inventory");
    }

    private static void addItem(Inventory inventory, Scanner input) {
        String itemName = getNewItemName(inventory, input);
        System.out.println("How much quantity is available?");
        int quantity = input.nextInt();
        System.out.println("What is the price?");
        double price = input.nextDouble();
        inventory.addItem(new Item(itemName, quantity, price));
    }
}
