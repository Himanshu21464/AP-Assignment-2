import java.util.ArrayList;
import java.util.Scanner;

class Category{
    int category;
    String category_name;
    boolean discount;
    static ArrayList<Category> category_list=new ArrayList<Category>();
    public Category(){}
    public Category(boolean discount){
        this.discount=true;
    }
    public Category(int category, String category_name){
        this.category=category;
        this.category_name=category_name;
        this.discount=false;
    }
    public Category(int category){
        this.category=category;
    }
}
class Product extends Category {
    String name;
    double ID;
    int price;
    String Features;
    int quantity;
    public Product(){}
    static ArrayList<Product> product_list=new ArrayList<Product>();
    public Product(String Name, double ID, int Price,String Features,int category,int quantity){
        //super(category);
        this.category=category;
        this.name=Name;
        this.ID=ID;
        this.Features=Features;
        this.price=Price;
        this.quantity=quantity;
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
    int quantity;
    double product_id;
    int Total_amount;
    static int list=0;
    public Cart(double product_id, int quantity ){
        this.product_id=product_id;
        this.quantity=quantity;
        Cart.list+=quantity;
    }
    static ArrayList<Deals> deals=new ArrayList<Deals>();
    static ArrayList<Cart> cart_list=new ArrayList<Cart>();
    public static void Add_To_Cart() {
        System.out.print("Enter product ID: ");
        Scanner sc=new Scanner(System.in);
        double id=sc.nextDouble();
        for( int i=0;i<Product.product_list.size();i++){
            if(id==Product.product_list.get(i).ID){
                System.out.print("Enter quantity: ");
                int qty=sc.nextInt();
                Cart item=new Cart(id,qty);
                cart_list.add(item);
            }else {
                System.out.println("Wrong Input!!!");
                Add_To_Cart();
            }
        }
        Customer.Login_Menu();
    }
    public static void Add_Deals_To_Cart(){
        double temp1=Deals.deals_list.get(0).ID1;
        double temp2=Deals.deals_list.get(0).ID1;
        double temp3=Deals.deals_list.get(0).price;
        Cart.deals.add(Deals.deals_list.get(0));
        Customer.Login_Menu();
    }
    public static void View_Cart() {
        if((Cart.cart_list.isEmpty())&&(Cart.deals.isEmpty())){
            System.out.println("Cart is Empty!!");
            Customer.Login_Menu();
        }else if (Cart.cart_list.isEmpty()&&(!Cart.deals.isEmpty())){
            for (int s=0;s<Cart.deals.size();s++){
                System.out.println(Cart.deals.get(s).ID1);
                System.out.println(Cart.deals.get(s).ID2);
                System.out.println(Cart.deals.get(s).price);
            }
            Customer.Login_Menu();
        }else if(Cart.deals.isEmpty()&&(!Cart.cart_list.isEmpty())){
            for(int x=0;x<Product.product_list.size();x++){
                System.out.println("Product ID: "+Cart.cart_list.get(x).ID);
                System.out.println("Product Name: "+Cart.cart_list.get(x).name);
                System.out.println("Product Details: "+Cart.cart_list.get(x).Features);
                System.out.println("Product Price: Rs "+Cart.cart_list.get(x).price+"/-");
            }
            Customer.Login_Menu();
        }else {
            for (int s=0;s<Cart.deals.size();s++){
                System.out.println(Deals.deals_list.get(s).ID1);
                System.out.println(Deals.deals_list.get(s).ID2);
                System.out.println(Deals.deals_list.get(s).price);
            }
            for(int x=0;x<Product.product_list.size();x++){
                System.out.println("Product ID: "+Product.product_list.get(x).ID);
                System.out.println("Product Name: "+Product.product_list.get(x).name);
                System.out.println("Product Details: "+Product.product_list.get(x).Features);
                System.out.println("Product Price: Rs "+Product.product_list.get(x).price+"/-");
            }
            Customer.Login_Menu();
        }
    }
    public static void Empty_Cart(){
        if(!Cart.cart_list.isEmpty()&&(!Cart.deals.isEmpty())){
            for (int i=0;i<Cart.deals.size();i++) {
                Cart.deals.remove(i);
            }
            for (int w=0;w<Cart.cart_list.size();w++){
                Cart.cart_list.remove(w);
            }
            System.out.println("Cart is empty now!!");
            Customer.Login_Menu();

        }else if(Cart.cart_list.isEmpty()&&(!Cart.deals.isEmpty())){
            for (int i=0;i<Cart.deals.size();i++) {
                Cart.deals.remove(i);
            }
            System.out.println("Cart is empty now!!");
            Customer.Login_Menu();
        } else if (Cart.deals.isEmpty()&&(!Cart.cart_list.isEmpty())) {
            for (int w=0;w<Cart.cart_list.size();w++){
                Cart.cart_list.remove(w);
            }
            System.out.println("Cart is empty now!!");
            Customer.Login_Menu();
        }else {
            System.out.println("Cart is Already Empty!!");
            Customer.Login_Menu();
        }
    }
    public static void Checkout(){
        int i=0;
        System.out.println("Proceeding to checkout, Details: ");
        for(i=0;i<Cart.cart_list.size();i++){
            System.out.println(Cart.cart_list.get(i).name);
            System.out.println(Cart.cart_list.get(i).ID);
            System.out.println(Cart.cart_list.get(i).Features);
            System.out.println(Cart.cart_list.get(i).price*Cart.cart_list.get(i).quantity);
            Cart.cart_list.get(i).Total_amount+=Cart.cart_list.get(i).price*Cart.cart_list.get(i).quantity;
        }
        if(Customer.customer_list.get(0).Status=="NORMAL"){
            int discount=0;
            int Delivery_Charge=100+(Cart.cart_list.get(i).Total_amount)/20;
            int Total=Cart.cart_list.get(i).Total_amount+Delivery_Charge-discount;
            System.out.println("Total cost: "+Total);
            System.out.println("Order placed. It will be delivered in 7-10 days.");
            Customer.Login_Menu();
        }else if(Customer.customer_list.get(0).Status=="ELITE"){
            int discount=((Customer.customer_list.get(0).coupons_discount + 10)*Cart.cart_list.get(i).Total_amount)/100;
            int Delivery_Charge=100+(Cart.cart_list.get(i).Total_amount)/50;
            int Total=Cart.cart_list.get(i).Total_amount+Delivery_Charge-discount;
            System.out.println("Total cost: "+Total);
            System.out.println("Order placed. It will be delivered in 2 days.");
            Customer.Login_Menu();
        }else if(Customer.customer_list.get(0).Status=="PRIME"){
            int discount=((Customer.customer_list.get(0).coupons_discount + 5)*Cart.cart_list.get(i).Total_amount)/100;
            int Delivery_Charge=100;
            int Total=Cart.cart_list.get(i).Total_amount+Delivery_Charge-discount;
            System.out.println("Total cost: "+Total);
            System.out.println("Order placed. It will be delivered in 3-6 days.");
            Customer.Login_Menu();
        }else {
            System.out.println("Error!!");
            Checkout();
        }
    }
}