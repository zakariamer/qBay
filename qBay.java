public class qBay {

    public static void main(String[] args){
        

        
        
    }

    public static void Buy()
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