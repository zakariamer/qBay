import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class qBay {

    public static void main(String[] args){

        ArrayList<String> emailList = new ArrayList<>();
        ArrayList<String> passwordList = new ArrayList<>();

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
        int tries = 0;
        while (!passwordList.get(index).equals(password)){
            if (tries == 3){
                System.out.println("You have exceeded the number of tries! Please try again later!");
                System.exit(0);
            }
            System.out.println("Password not found! Please enter a valid password!");
            password = scan.nextLine();
            tries++;
        }
    }

    public void Buy()
    {
            ArrayList<Item> Items = new ArrayList<>();
    
            Item MathBook = new Item("Discreet Math Textbook", "Textbooks", "Alex Saldana", "ASaldana@qu.edu", 109.99);
            Item BioBook = new Item("Advanced Biology Textbook", "Textbooks", "Scott Canney", "SCanney@qu.edu", 219.99);
            Item Calculator = new Item("TI-84 Calculator", "Supplies", "Ben Bailor", "BBailor@qu.edu", 89.99);
            Item Sweatshirt = new Item("QU Logo Hooded Sweatshirt", "Clothing", "David Scrivines", "DScrivines@qu.edu", 49.99);
            Item Pen = new Item("Black Ink Pen (5 pack)", "Supplies", "Richard Kamins", "RKamins@qu.edu", 2.99);
    
            Items.add(MathBook);
            Items.add(BioBook);
            Items.add(Calculator);
            Items.add(Sweatshirt);
            Items.add(Pen);
            System.out.println("\nList of items for sale:");
            System.out.println("Type \"info\" to obtain more information on a listed item, "
             + "or type the name of the item to add it to the cart.\n");

            for (Item Item : Items) 
            {
                System.out.println("\t- " + Item.getName());
            }
    }
}