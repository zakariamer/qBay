public class Item 
{
    private String name;
    private String category;
    private String sellerName;
    private String sellerEmail;
    private double price;

    public Item(String n, String c, String sn, String se, double p)
    {
        name = n;
        category = c;
        sellerName = sn;
        sellerEmail = se;
        price = p;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public double getPrice() {
        return price;
    }
}
