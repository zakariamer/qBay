import com.sun.source.doctree.SystemPropertyTree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class qBay {
    public static String sellerName;
    public static String sellerEmail;
    public static ArrayList<Item> itemList = new ArrayList<Item>();
    public static ArrayList<Item> sellList = new ArrayList<Item>();
    public static ArrayList<Item> cart = new ArrayList<Item>();

    public static void sell(){


        Scanner sellScan = new Scanner(System.in);

        System.out.println("1: See your items for sale\n2: Put item up for sale\n3: Back to main menu");
        int option = sellScan.nextInt();
        sellScan.nextLine();
        switch(option){
            case 1:
                if (sellList.isEmpty()) {
                    System.out.println("You have no items for sale.");
                } else {
                    for (Item i : sellList) {
                        System.out.println("Item Name: " + i.getName());
                        System.out.println("Item Category: " + i.getCategory());
                        System.out.println("Seller Name: " + i.getSellerName());
                        System.out.println("Price: " + i.getPrice());
                    }
                }
                break;
            case 2:
                System.out.println("Enter the name of the item you want to sell:");
                String itemName = sellScan.nextLine();
                System.out.println("Enter the category of the item you want to sell:");
                String itemCategory = sellScan.nextLine();
                System.out.println("Enter the name of the seller (your name):");
                String itemSellerName = sellScan.nextLine();
                System.out.println("Enter the eamil of the seller (your email):");
                String itemSellerEmail = sellScan.nextLine();
                System.out.println("Enter the price");
                double itemPrice = sellScan.nextInt();
                sellScan.nextLine();
                sellList.add(new Item(itemName, itemCategory, itemSellerName, itemSellerEmail, itemPrice));
                System.out.println("Item added to your list of items for sale!");
                break;
            case 3:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("invalid option, return to main menu.");
                break;
        }
    }
    public static void main(String[] args){

        ArrayList<String> emailList = new ArrayList<>();
        ArrayList<String> passwordList = new ArrayList<>();

        Item MathBook = new Item("Discrete Math Textbook", "Textbooks", "Alex Saldana", "Saldanaa@qu.edu", 109.99);
        Item eldenRing = new Item("Elden Ring", "Video Games", "John Doe", "johndoe@example.com", 59.99);
        Item tShirt = new Item("Graphic T-Shirt", "Clothing", "Jane Smith", "janesmith@example.com", 19.99);
        Item boardGame = new Item("Catan", "Board Games", "Chris Brown", "chrisbrown@example.com", 39.99);
        Item sneakers = new Item("Running Sneakers", "Footwear", "Emily Davis", "emilydavis@example.com", 89.99);

        itemList.add(MathBook);
        itemList.add(eldenRing);
        itemList.add(tShirt);
        itemList.add(boardGame);
        itemList.add(sneakers);

        Scanner scan = new Scanner(System.in);
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new File("account.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        
        while (fileScanner.hasNextLine()){
            String[] parts = fileScanner.nextLine().split(" ");
            emailList.add(parts[0]); 
            passwordList.add(parts[1]);
        }

        for (int i = 0; i < emailList.size(); i++){
            System.out.println(emailList.get(i) + " " + passwordList.get(i));
        }

        System.out.println(" __      __       .__                                  __                  __________               \r\n" + //
                        "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   _/  |_  ____     _____\\______   \\_____  ___.__.\r\n" + //
                        "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\  \\   __\\/  _ \\   / ____/|    |  _/\\__  \\<   |  |\r\n" + //
                        " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |  | (  <_> ) < <_|  ||    |   \\ / __ \\\\___  |\r\n" + //
                        "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |__|  \\____/   \\__   ||______  /(____  / ____|\r\n" + //
                        "       \\/       \\/          \\/            \\/     \\/                     |__|       \\/      \\/\\/     ");

        System.out.println("Please enter your email!");

        String email = scan.nextLine();
        while (!emailList.contains(email)){
            System.out.println("Email not found! Please enter a valid email!");
            email = scan.nextLine();
        }

        int index = emailList.indexOf(email);

        System.out.println("Please enter your password!");
        String password = scan.nextLine();
        int tries = 1;
        while (!passwordList.get(index).equals(password)){
            if (tries == 3){
                System.out.println("You have exceeded the number of tries! Please try again later!");
                System.exit(0);
            }
            System.out.println("Password not found! Please enter a valid password!");
            password = scan.nextLine();
            tries++;
        }

        System.out.println("Welcome! What would you like to do?");
        while (true){
            System.out.println("1: Sell an item\n2: Buy an item\n3: Cart\n4: Logout");
            int option = scan.nextInt();
            scan.nextLine();    
            switch(option){
                case 1:
                    sell();
                    break;
                case 2:
                    Buy();
                    break;
                case 3:
                    Cart();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again!");
            }
        }
    }


    public static void Buy()
    {
        Scanner scan = new Scanner(System.in);
        
        for(Item item : sellList)
        {
            itemList.add(item);
        }

        System.out.println("Welcome to the Buy section! Here are some items available for purchase:");
        // System.out.println("1: " + MathBook.getName() + " - " + MathBook.getCategory() + " - " + MathBook.getSellerName() + " - $" + MathBook.getPrice());
        // System.out.println("2: " + eldenRing.getName() + " - " + eldenRing.getCategory() + " - " + eldenRing.getSellerName() + " - $" + eldenRing.getPrice());
        // System.out.println("3: " + tShirt.getName() + " - " + tShirt.getCategory() + " - " + tShirt.getSellerName() + " - $" + tShirt.getPrice());
        // System.out.println("4: " + boardGame.getName() + " - " + boardGame.getCategory() + " - " + boardGame.getSellerName() + " - $" + boardGame.getPrice());
        // System.out.println("5: " + sneakers.getName() + " - " + sneakers.getCategory() + " - " + sneakers.getSellerName() + " - $" + sneakers.getPrice());

        for (int i = 1; i < itemList.size() + 1; i++)
        {
            System.out.println(i + ": " + itemList.get(i - 1).getName() + " - " + itemList.get(i - 1).getCategory() + " - " + itemList.get(i - 1).getSellerName() + " - $" + itemList.get(i - 1).getPrice());
        }

        System.out.println("Would you like to view more details about an item or add an item to your cart? ");
        System.out.println("1: View more details\n2: Add to cart\n3: Back to main menu");
        
        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter the number of the item you want to view:");
                int itemNumber = scan.nextInt();
                scan.nextLine();

                while(itemNumber > itemList.size() || itemNumber < 1)
                {
                    System.out.println("Please enter a valid number: ");
                    itemNumber = scan.nextInt();
                }


                System.out.println("Item Details: ");

                Item currItem = itemList.get(itemNumber - 1);


                System.out.println("Name: " + currItem.getName());
                System.out.println("Category: " + currItem.getCategory());
                System.out.println("Seller Name: " + currItem.getSellerName());
                System.out.println("Seller Email: " + currItem.getSellerEmail());
                System.out.println("Price: $" + currItem.getPrice());



                // switch (itemNumber) {
                //     case 1:
                //         System.out.println("Name: " + MathBook.getName());
                //         System.out.println("Category: " + MathBook.getCategory());
                //         System.out.println("Seller Name: " + MathBook.getSellerName());
                //         System.out.println("Seller Email: " + MathBook.getSellerEmail());
                //         System.out.println("Price: $" + MathBook.getPrice());
                //         break;
                //     case 2:
                //         System.out.println("Name: " + eldenRing.getName());
                //         System.out.println("Category: " + eldenRing.getCategory());
                //         System.out.println("Seller Name: " + eldenRing.getSellerName());
                //         System.out.println("Seller Email: " + eldenRing.getSellerEmail());
                //         System.out.println("Price: $" + eldenRing.getPrice());
                //         break;
                //     case 3:
                //         System.out.println("Name: " + tShirt.getName());
                //         System.out.println("Category: " + tShirt.getCategory());
                //         System.out.println("Seller Name: " + tShirt.getSellerName());
                //         System.out.println("Seller Email: " + tShirt.getSellerEmail());
                //         System.out.println("Price: $" + tShirt.getPrice());
                //         break;
                //     case 4:
                //         System.out.println("Name: " + boardGame.getName());
                //         System.out.println("Category: " + boardGame.getCategory());
                //         System.out.println("Seller Name: " + boardGame.getSellerName());
                //         System.out.println("Seller Email: " + boardGame.getSellerEmail());
                //         System.out.println("Price: $" + boardGame.getPrice());
                //         break;
                //     case 5:
                //         System.out.println("Name: " + sneakers.getName());
                //         System.out.println("Category: " + sneakers.getCategory());
                //         System.out.println("Seller Name: " + sneakers.getSellerName());
                //         System.out.println("Seller Email: " + sneakers.getSellerEmail());
                //         System.out.println("Price: $" + sneakers.getPrice());
                //         break;
                //     default:
                //         System.out.println("Invalid item number!");
                // }
                break;

            case 2: 
                System.out.println("Enter the number of the item you want to add to your cart:");
                int addItemNumber = scan.nextInt();


                while(addItemNumber > itemList.size() || addItemNumber < 1)
                {
                    System.out.println("Please enter a valid number: ");
                    addItemNumber = scan.nextInt();
                }

                while(cart.contains(itemList.get(addItemNumber - 1)))
                {
                    System.out.println("This item is already in your cart. Chose a different item.");
                    addItemNumber = scan.nextInt();
                }
                currItem = itemList.get(addItemNumber - 1);


                scan.nextLine();

                System.out.println("Added " + currItem.getName() + " to your cart.");
                cart.add(currItem);

                // switch (addItemNumber) {
                //     case 1:
                //         System.out.println("Added " + MathBook.getName() + " to your cart.");
                //         cart.add(MathBook);
                //         break;
                //     case 2:
                //         System.out.println("Added " + eldenRing.getName() + " to your cart.");
                //         cart.add(eldenRing);
                //         break;
                //     case 3:
                //         System.out.println("Added " + tShirt.getName() + " to your cart.");
                //         cart.add(tShirt);
                //         break;
                //     case 4:
                //         System.out.println("Added " + boardGame.getName() + " to your cart.");
                //         cart.add(boardGame);
                //         break;
                //     case 5:
                //         System.out.println("Added " + sneakers.getName() + " to your cart.");
                //         cart.add(sneakers);
                //         break;
                //     default:
                //         System.out.println("Invalid item number!");
                // }
                break;
                
            case 3:
                System.out.println("Returning to main menu...");
                break;

            default:
                break;
        }
    }

    public static void Cart()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("YOUR CART:\n\n");
        double totalPrice = 0;

        for (Item item : cart)
        {
            System.out.println("-" + item.getName());
            System.out.println("\t-" + item.getPrice() + "\n");

            totalPrice += item.getPrice();
        }

        System.out.println("\nTotal Price: " + totalPrice);
        System.out.println("Press enter to check out, or type \"exit\" to cancel.");

        String userIn = input.nextLine();

        while (!userIn.equals("") && !userIn.toLowerCase().equals("exit"))
        {
            System.out.println("Invalid, please press enter or enter the word \"exit\"");
            userIn = input.nextLine();
        }

        if(userIn.equals(""))
        {
            System.out.println("You successfully made a purchase for $" + totalPrice + ".");
            System.out.println("Items Purchased:");

            for(int i = 0; i < cart.size() + 1; i++)
            {
                System.out.println("FOR LOOP RAN");
                //if(cart.get(0).equals(itemList.get(i)))
                if(itemList.contains(cart.get(0)))
                {
                    System.out.println("\t-" + cart.get(0) + "\t-" + cart.get(0).getPrice());

                    itemList.remove(cart.get(0));
                    cart.remove(0);

                    i = 0;
                }
            }
        }
        //exit
    }
}