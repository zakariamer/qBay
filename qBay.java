import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class qBay {
    public static String sellerName;
    public static String sellerEmail;
    public static ArrayList<Item> itemList;

    public static void sell(){


        Scanner sellScan = new Scanner(System.in);

        System.out.println("1: See your current shop\n2: Put item up for sale");
        int option = sellScan.nextInt();
        sellScan.nextLine();
        switch(option){
            case 1:
                for(Item i: itemList){
                    System.out.println("Item Name: " + i.getName());
                    System.out.println("Item Category: " + i.getCategory());
                    System.out.println("Seller Name: " + i.getSellerName());
                    System.out.println("Price:" + i.getPrice());
                }
            case 2:
                String itemName = sellScan.nextLine();
                String itemCategory = sellScan.nextLine();
                double itemPrice = sellScan.nextInt();
                sellScan.nextLine();
                itemList.add(new Item(itemName, itemCategory, sellerName, sellerEmail, itemPrice));
            default:
                System.out.println("invalid option, return to main menu.");
        }
    }
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
        //ItemList;
        Item MathBook = new Item("Discreet Math Textbook", "Textbooks", "Alex Saldana", "Saldanaa@qu.edu", 109.99);


    }
}