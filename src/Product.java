import java.util.ArrayList;

class Category{
    int category;
    public Category(){}
    public Category(int category){
        this.category=category;
    }
}
class Product extends Category {
    String name;
    int ID;
    int price;
    String Features;
    public Product(){}
    static ArrayList<Product> product_list=new ArrayList<Product>();
    public Product(String Name, int ID, int Price,String Features,int category){
        this.name=Name;
        this.ID=ID;
        this.Features=Features;
        this.price=Price;
        this.category=category;
    }
}

class Deals extends Product{
    double price, ID1, ID2;
    static ArrayList<Deals> deals_list=new ArrayList<Deals>();
    public Deals(){}
    public Deals(double ID1,double ID2,double price){
        this.ID1=ID1;
        this.ID2=ID2;
        this.price=price;
    }

}
class Cart extends Deals{
    
    public static void Add_To_Cart(){

    }
    public static void Add_Deals_To_Cart(){

    }
    public static void View_Cart(){

    }
    public static void Empty_Cart(){

    }
    public static void Checkout(){

    }

}