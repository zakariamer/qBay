import java.util.Scanner;
public class qBay {
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
                itemList.add(new Item(itemName, itemCategory, ));
            default:
                System.out.println("invalid option, return to main menu.");
        }
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        sell();
    }

}