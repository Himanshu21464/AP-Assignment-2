import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Category{
    int category;
    String category_name;
    static ArrayList<Category> category_list=new ArrayList<Category>();
    public Category(){}
    public Category(int category, String category_name){
        this.category=category;
        this.category_name=category_name;
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
    boolean discount;
    float disc;
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
        this.discount=false;
        this.disc=0;
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
    static int Total_amount;
    static int list=0;
    public Cart(double product_id, int quantity,String name, double price,String details ){
        this.product_id=product_id;
        this.quantity=quantity;
        Cart.list+=quantity;
        this.name=name;
        this.price=price;
        this.Features=details;
        Cart.Total_amount+=price;
    }
    static ArrayList<Deals> deals=new ArrayList<Deals>();
    static ArrayList<Cart> cart_list=new ArrayList<Cart>();
    public static void Add_To_Cart() {
        System.out.print("Enter product ID: ");
        Scanner sc=new Scanner(System.in);
        double id=sc.nextDouble();
        boolean flag4=false;
        for( int i=0;i<Product.product_list.size();i++){
            if(id==Product.product_list.get(i).ID){
                flag4=true;
                System.out.print("Enter quantity: ");
                int qty=sc.nextInt();
                String name=Product.product_list.get(i).name;
                double price=Product.product_list.get(i).price;
                String details=Product.product_list.get(i).Features;
                Cart item=new Cart(id,qty,name,price,details);
                cart_list.add(item);
                System.out.println("Product added to Cart successfully!!!");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
                Customer.Login_Menu();
                //Cart.Total_amount+=price;
            }
        }
        if(flag4==false){
            System.out.println("Wrong Input!!!");
            Customer.Login_Menu();
        }
    }
    public static void Add_Deals_To_Cart(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter index of deal you want to add in cart: ");
        int tempo= sc.nextInt();
        if(tempo<=Deals.deals_list.size()) {
            double temp1 = Deals.deals_list.get(tempo - 1).ID1;
            double temp2 = Deals.deals_list.get(tempo - 1).ID1;
            double temp3 = Deals.deals_list.get(tempo - 1).price;
            Cart.deals.add(Deals.deals_list.get(tempo - 1));
            Cart.Total_amount+=temp3;
            System.out.println("Deal Products successfully added to Cart!!");
            System.out.println("----------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        }else {
            System.out.println("Invalid Input!!!");
            System.out.println("----------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        }
    }
    public static void View_Cart() {
        if((Cart.cart_list.isEmpty())&&(Cart.deals.isEmpty())){
            System.out.println("Cart is Empty!!");
            System.out.println("----------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        }else if (Cart.cart_list.isEmpty()&&(!Cart.deals.isEmpty())){
            for (int s=0;s<Cart.deals.size();s++){
                System.out.println("ID of Ist Product: "+Cart.deals.get(s).ID1);
                System.out.println("ID of 2nd Product: "+Cart.deals.get(s).ID2);
                System.out.println("Giveaway price: "+Cart.deals.get(s).price);
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            System.out.println("Total amount of all items in cart: "+Cart.Total_amount);
            System.out.println("----------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        }else if(Cart.deals.isEmpty()&&(!Cart.cart_list.isEmpty())){
            for(int x=0;x<Cart.cart_list.size();x++){
                System.out.println("Product ID: "+Cart.cart_list.get(x).product_id);
                System.out.println("Product Name: "+Cart.cart_list.get(x).name);
                System.out.println("Product Details: "+Cart.cart_list.get(x).Features);
                System.out.println("Product Price: Rs "+Cart.cart_list.get(x).price+"/-");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            System.out.println("Total amount of all items in cart: "+Cart.Total_amount);
            System.out.println("----------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        }else {
            for (int u=0;u<Cart.deals.size();u++){
                System.out.println("ID of Ist Product: "+Cart.deals.get(u).ID1);
                System.out.println("ID of 2nd Product: "+Cart.deals.get(u).ID2);
                System.out.println("Giveaway price: "+Cart.deals.get(u).price);
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            for(int v=0;v<Cart.cart_list.size();v++){
                System.out.println("Product ID: "+Cart.cart_list.get(v).product_id);
                System.out.println("Product Name: "+Cart.cart_list.get(v).name);
                System.out.println("Product Details: "+Cart.cart_list.get(v).Features);
                System.out.println("Product Price: Rs "+Cart.cart_list.get(v).price+"/-");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            System.out.println("Total amount of all items in cart: "+Cart.Total_amount);
            System.out.println("----------------------------------------------");
            System.out.println(" ");
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
        Random random=new Random();
        if(Customer.customer_list.get(Global.index).Status.equals("PRIME")){
            if(!Administrator.list.isEmpty()){
                for(int f=0;f<Administrator.list.size();f++){
                    for (int x=0;x<Cart.cart_list.size();x++){
                        if(Cart.cart_list.get(x).ID==Administrator.list.get(f)){
                            Cart.cart_list.get(x).disc=Administrator.prime_list.get(f);
                        }else {
                            Cart.cart_list.get(x).disc=5;
                        }
                    }
                }
            }
        }else if(Customer.customer_list.get(Global.index).Status.equals("ELITE")){
            if(!Administrator.list.isEmpty()){
                for(int f=0;f<Administrator.list.size();f++){
                    for (int x=0;x<Cart.cart_list.size();x++){
                        if(Cart.cart_list.get(x).ID==Administrator.list.get(f)){
                            Cart.cart_list.get(x).disc=Administrator.elite_list.get(f);
                        }else {
                            Cart.cart_list.get(x).disc=5;
                        }
                    }
                }
            }
        }else if(Customer.customer_list.get(Global.index).Status.equals("NORMAL")){
            if(!Administrator.list.isEmpty()){
                for(int f=0;f<Administrator.list.size();f++){
                    for (int x=0;x<Cart.cart_list.size();x++){
                        if(Cart.cart_list.get(x).ID==Administrator.list.get(f)){
                            Cart.cart_list.get(x).disc=Administrator.normal_list.get(f);
                        }
                    }
                }
            }
        }

        float MAX;
        if(Customer.customer_list.get(Global.index).Status.equals("PRIME")){
            //if(Customer.customer_list.get(Global.index)){
            //
           // }

        }else{

        }

        /*
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
        }*/
    }
}