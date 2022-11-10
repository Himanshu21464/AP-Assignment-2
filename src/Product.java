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
        //Cart.Total_amount+=price;
    }
    public Deals(float paisa){
        Cart.Total_amount+=price;

    }
}
class Cart extends Deals{
    int quantity;
    static float discnt = 0;
    double product_id;
    static int Total_amount;
    static int list = 0;
    public Cart(double product_id, int quantity, String name, double price, String details) {
        this.product_id = product_id;
        this.quantity = quantity;
        Cart.list += quantity;
        this.name = name;
        this.price = price;
        this.Features = details;
        Cart.Total_amount += price;
    }
    static ArrayList<Deals> deals = new ArrayList<Deals>();
    static ArrayList<Cart> cart_list = new ArrayList<Cart>();
    public static void qty_maintain(double i, int q){
        for (int r=0;r<product_list.size();r++){
            if(product_list.get(r).ID==i){
                product_list.get(r).quantity-=q;
            }
        }
    }
    public static void Available_Deals(int parameter2){
        if(Deals.deals_list.isEmpty()){
            System.out.println("-------------------------NO Deals Available!!----------------------------");
            Customer.Login_Menu();
        }else{
            for(int x=0;x<Deals.deals_list.size();x++){
                System.out.println("ID of Ist product: "+Deals.deals_list.get(x).ID1);
                System.out.println("ID of 2nd product: "+Deals.deals_list.get(x).ID2);
                System.out.println("Giveaway Price: "+Deals.deals_list.get(x).price);
                System.out.println("------------------------------------------------------------------");
                System.out.println(" ");
            }
        }
    }
    public static void Add_To_Cart() {
        Customer.Product_Catalog(0);
        System.out.print("Enter product ID: ");
        Scanner sc = new Scanner(System.in);
        double id = sc.nextDouble();
        boolean flag4 = false;
        for (int i = 0; i < Product.product_list.size(); i++) {
            if (id == Product.product_list.get(i).ID) {
                flag4 = true;
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                if(product_list.get(i).quantity<qty){
                    System.out.println(" Product is out of Stock!!!");
                    Customer.Login_Menu();
                }else {
                    String name = Product.product_list.get(i).name;
                    double price = Product.product_list.get(i).price * qty;
                    String details = Product.product_list.get(i).Features;
                    Cart item = new Cart(id, qty, name, price, details);
                    cart_list.add(item);
                    System.out.println("Product added to Cart successfully!!!");
                    qty_maintain(id, qty);
                    System.out.println("--------------------------------------------------");
                    System.out.println(" ");
                    Customer.Login_Menu();
                    //Cart.Total_amount+=price;
                }
            }
        }
        if (flag4 == false) {
            System.out.println("Wrong Input!!!");
            Customer.Login_Menu();
        }
    }
    public static void Add_Deals_To_Cart() {
        Available_Deals(0);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index of deal you want to add in cart: ");
        int tempo = sc.nextInt();
        if (tempo <= Deals.deals_list.size()) {
            double temp1 = Deals.deals_list.get(tempo - 1).ID1;
            double temp2 = Deals.deals_list.get(tempo - 1).ID1;
            double temp3 = Deals.deals_list.get(tempo - 1).price;
            Cart.deals.add(Deals.deals_list.get(tempo - 1));
            Cart.Total_amount += temp3;
            System.out.println("Deal Products successfully added to Cart!!");
            System.out.println("--------------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        } else {
            System.out.println("Invalid Input!!!");
            System.out.println("--------------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        }
    }
    public static void View_Cart(int qwerty){
            if ((Cart.cart_list.isEmpty()) && (Cart.deals.isEmpty())) {
                System.out.println("Cart is Empty!!");
                System.out.println("--------------------------------------------------");
                System.out.println(" ");

            } else if (Cart.cart_list.isEmpty() && (!Cart.deals.isEmpty())) {
                for (int s = 0; s < Cart.deals.size(); s++) {
                    System.out.println("ID of Ist Product: " + Cart.deals.get(s).ID1);
                    System.out.println("ID of 2nd Product: " + Cart.deals.get(s).ID2);
                    System.out.println("Giveaway price: " + Cart.deals.get(s).price);
                    System.out.println("----------------------------------------------");
                    System.out.println(" ");
                }
                System.out.println("Total amount of all items in cart: " + Cart.Total_amount);
                System.out.println("--------------------------------------------------");
                System.out.println(" ");

            } else if (Cart.deals.isEmpty() && (!Cart.cart_list.isEmpty())) {
                for (int x = 0; x < Cart.cart_list.size(); x++) {
                    System.out.println("Product ID: " + Cart.cart_list.get(x).product_id);
                    System.out.println("Product Name: " + Cart.cart_list.get(x).name);
                    System.out.println("Product Details: " + Cart.cart_list.get(x).Features);
                    System.out.println("Price: Rs " + Cart.cart_list.get(x).price + "/-");
                    System.out.println("----------------------------------------------");
                    System.out.println(" ");
                }
                System.out.println("Total amount of all items in cart: " + Cart.Total_amount);
                System.out.println("--------------------------------------------------");
                System.out.println(" ");

            } else {
                for (int u = 0; u < Cart.deals.size(); u++) {
                    System.out.println("ID of Ist Product: " + Cart.deals.get(u).ID1);
                    System.out.println("ID of 2nd Product: " + Cart.deals.get(u).ID2);
                    System.out.println("Giveaway price: " + Cart.deals.get(u).price+"/-");
                    System.out.println("----------------------------------------------");
                    System.out.println(" ");
                }
                for (int v = 0; v < Cart.cart_list.size(); v++) {
                    System.out.println("Product ID: " + Cart.cart_list.get(v).product_id);
                    System.out.println("Product Name: " + Cart.cart_list.get(v).name);
                    System.out.println("Product Details: " + Cart.cart_list.get(v).Features);
                    System.out.println("Price: Rs " + Cart.cart_list.get(v).price + "/-");
                    System.out.println("----------------------------------------------");
                    System.out.println(" ");
                }
                System.out.println("Total amount of all items in cart: " + Cart.Total_amount+"/-");
                System.out.println("--------------------------------------------------");
                System.out.println(" ");

            }
        }
    public static void View_Cart() {
        if ((Cart.cart_list.isEmpty()) && (Cart.deals.isEmpty())) {
            System.out.println("Cart is Empty!!");
            System.out.println("--------------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        } else if (Cart.cart_list.isEmpty() && (!Cart.deals.isEmpty())) {
            for (int s = 0; s < Cart.deals.size(); s++) {
                System.out.println("ID of Ist Product: " + Cart.deals.get(s).ID1);
                System.out.println("ID of 2nd Product: " + Cart.deals.get(s).ID2);
                System.out.println("Giveaway price: " + Cart.deals.get(s).price);
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            System.out.println("Total amount of all items in cart: " + Cart.Total_amount);
            System.out.println("--------------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        } else if (Cart.deals.isEmpty() && (!Cart.cart_list.isEmpty())) {
            for (int x = 0; x < Cart.cart_list.size(); x++) {
                System.out.println("Product ID: " + Cart.cart_list.get(x).product_id);
                System.out.println("Product Name: " + Cart.cart_list.get(x).name);
                System.out.println("Product Details: " + Cart.cart_list.get(x).Features);
                System.out.println("Price: Rs " + Cart.cart_list.get(x).price + "/-");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            System.out.println("Total amount of all items in cart: " + Cart.Total_amount);
            System.out.println("--------------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        } else {
            for (int u = 0; u < Cart.deals.size(); u++) {
                System.out.println("ID of Ist Product: " + Cart.deals.get(u).ID1);
                System.out.println("ID of 2nd Product: " + Cart.deals.get(u).ID2);
                System.out.println("Giveaway price: " + Cart.deals.get(u).price+"/-");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            for (int v = 0; v < Cart.cart_list.size(); v++) {
                System.out.println("Product ID: " + Cart.cart_list.get(v).product_id);
                System.out.println("Product Name: " + Cart.cart_list.get(v).name);
                System.out.println("Product Details: " + Cart.cart_list.get(v).Features);
                System.out.println("Price: Rs " + Cart.cart_list.get(v).price + "/-");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
            System.out.println("Total amount of all items in cart: " + Cart.Total_amount+"/-");
            System.out.println("--------------------------------------------------");
            System.out.println(" ");
            Customer.Login_Menu();
        }
    }
    public static void Empty_Cart() {
        Cart.Total_amount=0;
        if (!Cart.cart_list.isEmpty() && (!Cart.deals.isEmpty())) {
            for (int i = 0; i < Cart.deals.size(); i++) {
                Cart.deals.remove(i);
                //Cart.Total_amount=0;
            }
            for (int w = 0; w < Cart.cart_list.size(); w++) {
                Cart.cart_list.remove(w);

                //Cart.Total_amount=0;
            }
            System.out.println("Cart is empty now!!");
            Customer.Login_Menu();

        } else if (Cart.cart_list.isEmpty() && (!Cart.deals.isEmpty())) {
            for (int i = 0; i < Cart.deals.size(); i++) {
                Cart.deals.remove(i);
                //Cart.Total_amount=0;
            }
            System.out.println("Cart is empty now!!");
            Customer.Login_Menu();
        } else if (Cart.deals.isEmpty() && (!Cart.cart_list.isEmpty())) {
            for (int w = 0; w < Cart.cart_list.size(); w++) {
                for (int c=0;c<product_list.size();c++){
                    if(product_list.get(c).ID==Cart.cart_list.get(w).product_id){
                        product_list.get(c).quantity+=Cart.cart_list.get(w).quantity;
                    }
                }
                Cart.cart_list.remove(w);
                //Cart.Total_amount=0;

            }
            System.out.println("Cart is empty now!!");
            Customer.Login_Menu();
        } else {
            System.out.println("Cart is Already Empty!!");
            Customer.Login_Menu();
        }
    }
    public static void Empty_Cart(int we) {
        Cart.Total_amount=0;
        if (!Cart.cart_list.isEmpty() && (!Cart.deals.isEmpty())) {
            for (int i = 0; i < Cart.deals.size(); i++) {
                Cart.deals.remove(i);
                //Cart.Total_amount=0;
            }
            for (int w = 0; w < Cart.cart_list.size(); w++) {
                Cart.cart_list.remove(w);

                //Cart.Total_amount=0;
            }


        } else if (Cart.cart_list.isEmpty() && (!Cart.deals.isEmpty())) {
            for (int i = 0; i < Cart.deals.size(); i++) {
                Cart.deals.remove(i);
                //Cart.Total_amount=0;
            }

        } else if (Cart.deals.isEmpty() && (!Cart.cart_list.isEmpty())) {
            for (int w = 0; w < Cart.cart_list.size(); w++) {
                for (int c=0;c<product_list.size();c++){
                    if(product_list.get(c).ID==Cart.cart_list.get(w).product_id){
                        product_list.get(c).quantity+=Cart.cart_list.get(w).quantity;
                    }
                }
                Cart.cart_list.remove(w);
                //Cart.Total_amount=0;

            }

        } else {
            System.out.println(" ");
        }
    }
    public static void Checkout() {
        int discount_coupons = 0;
        double cart_price = 0, Delivery_charge = 100;
        int MAX;
        double deals_price= 0;
        System.out.println("Proceeding to checkout, Details: ");
        View_Cart(0);
        int i = 0;
        Random random = new Random();
        if (Customer.customer_list.get(Global.index).Status.equals("PRIME")) {
            if (!Administrator.list.isEmpty()) {
                for (int f = 0; f < Administrator.list.size(); f++) {
                    for (int x = 0; x < Cart.cart_list.size(); x++) {
                        if (Cart.cart_list.get(x).ID == Administrator.list.get(f)) {
                            Cart.cart_list.get(x).disc = Administrator.prime_list.get(f);
                        } else {
                            Cart.cart_list.get(x).disc = 5;
                        }
                    }
                }
            }
        } else if (Customer.customer_list.get(Global.index).Status.equals("ELITE")) {
            if (!Administrator.list.isEmpty()) {
                for (int f = 0; f < Administrator.list.size(); f++) {
                    for (int x = 0; x < Cart.cart_list.size(); x++) {
                        if (Cart.cart_list.get(x).ID == Administrator.list.get(f)) {
                            Cart.cart_list.get(x).disc = Administrator.elite_list.get(f);
                        } else {
                            Cart.cart_list.get(x).disc = 5;
                        }
                    }
                }
            }
        } else if (Customer.customer_list.get(Global.index).Status.equals("NORMAL")) {
            if (!Administrator.list.isEmpty()) {
                for (int f = 0; f < Administrator.list.size(); f++) {
                    for (int x = 0; x < Cart.cart_list.size(); x++) {
                        if (Cart.cart_list.get(x).ID == Administrator.list.get(f)) {
                            Cart.cart_list.get(x).disc = Administrator.normal_list.get(f);
                        }
                    }
                }
            }
        }

        if (Customer.customer_list.get(Global.index).Status.equals("PRIME")) {
            MAX = (int) Customer.max_utility();
            if (!Customer.disc_list.isEmpty()) {
                if (MAX >= 5) {
                    discount_coupons = MAX;

                } else {
                    discount_coupons = 5;
                }
            }else if(Customer.disc_list.isEmpty()){
                discount_coupons=(int)Administrator.discount_Prime;
            }
            for (int z = 0; z < (Cart.cart_list.size()); z++) {
                if (Cart.cart_list.get(z).disc >= discount_coupons) {
                    Cart.cart_list.get(z).price = (Cart.cart_list.get(z).price) - ((Cart.cart_list.get(z).price) / 100) * Cart.cart_list.get(z).disc;
                    cart_price += Cart.cart_list.get(z).price;
                } else {
                    Cart.cart_list.get(z).price = Cart.cart_list.get(z).price - ((Cart.cart_list.get(z).price) / 100) * discount_coupons;
                    cart_price += Cart.cart_list.get(z).price;
                }
            }
            for(int f=0;f<Cart.deals.size();f++){
                deals_price+=Cart.deals.get(f).price;
            }

            Delivery_charge += ((cart_price+deals_price) / 100) * 2;
            if ((cart_price + Delivery_charge + deals_price) >= Customer.customer_list.get(Global.index).getWallet()) {
                System.out.println("LOW Balance!!!");
                Customer.Login_Menu();
            } else {
                Customer.customer_list.get(Global.index).setWallet((cart_price + Delivery_charge+ deals_price));
                Cart.cart_list.clear();
                int rand_temp = (int) Math.floor(Math.random() * (6 - 3 + 1) + 3);
                System.out.println("Order placed successfully!!!!");
                System.out.println("Order details:-");
                View_Cart(0);
                System.out.println("Delievery charge (100 + 2% of total amount): "+Delivery_charge);
                double r=cart_price+Delivery_charge+ deals_price;
                System.out.println("Total amount : "+r);
                System.out.println("Your order will be placed in " + rand_temp + " days!!");
                Cart.Empty_Cart(0);
                Cart.Total_amount=0;
                if(!Customer.disc_list.isEmpty()) {
                    Customer.disc_list.remove(0);
                }
                int rand_tem = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);


                if(cart_price>5000) {
                    for (int j = 0; j < rand_tem; j++) {
                        int count3 = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
                        Customer.disc_list.add(count3);
                        System.out.println("Congratulations!! You got some coupons");
                    }
                    Customer.Login_Menu();
                }else{
                    Customer.Login_Menu();
                }
            }

        } else if (Customer.customer_list.get(Global.index).Status.equals("ELITE")) {
            MAX = (int) Customer.max_utility();
            if (!Customer.disc_list.isEmpty()) {
                if (MAX >= 10) {
                    discount_coupons = MAX;

                } else {
                    discount_coupons = 10;
                }
            }else if(Customer.disc_list.isEmpty()){
                discount_coupons=(int)Administrator.discount_Elite;
            }
            for (int z = 0; z < (Cart.cart_list.size()); z++) {
                if (Cart.cart_list.get(z).disc >= discount_coupons) {
                    Cart.cart_list.get(z).price = (Cart.cart_list.get(z).price) - ((Cart.cart_list.get(z).price) / 100) * Cart.cart_list.get(z).disc;
                    cart_price += Cart.cart_list.get(z).price;
                } else {
                    Cart.cart_list.get(z).price = Cart.cart_list.get(z).price - ((Cart.cart_list.get(z).price) / 100) * discount_coupons;
                    cart_price += Cart.cart_list.get(z).price;
                }
            }
            for(int f=0;f<Cart.deals.size();f++){
                deals_price+=Cart.deals.get(f).price;
            }
            if ((cart_price + Delivery_charge+ deals_price) >= Customer.customer_list.get(Global.index).getWallet()) {
                System.out.println("LOW Balance!!!");
                Customer.Login_Menu();
            } else {
                Customer.customer_list.get(Global.index).setWallet((cart_price + Delivery_charge+ deals_price));
                Cart.cart_list.clear();
                System.out.println("Order placed successfully!!!!");
                System.out.println("Order details:-");
                View_Cart(0);
                System.out.println("Delievery charge : "+Delivery_charge);
                double x=cart_price+Delivery_charge+ deals_price;
                System.out.println("Total amount : "+x);
                if(!Customer.disc_list.isEmpty()) {
                    Customer.disc_list.remove(0);
                }
                System.out.println("Order placed!!!\nYour order will be delivered within 2 days.......");
                Cart.Empty_Cart(0);
                Cart.Total_amount=0;
                int loop = (int) Math.floor(Math.random() * (3 - 4 + 1) + 4);
                if (cart_price > 5000) {
                    for (int j = 0; j < loop; j++) {
                        int count4 = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
                        Customer.disc_list.add(count4);
                        System.out.println("Congratulations!! You got some coupons");
                    }
                    Customer.Login_Menu();
                }else{
                    Customer.Login_Menu();
                }
            }

        }else if (Customer.customer_list.get(Global.index).Status.equals("NORMAL")) {
            for (int j = 0; j < Cart.cart_list.size(); j++) {
                cart_price+= Cart.cart_list.get(j).price;

            }
            for(int f=0;f<Cart.deals.size();f++){
                deals_price+=Cart.deals.get(f).price;
            }
            Delivery_charge+=((cart_price+deals_price)/100)*5;
            if ((cart_price + Delivery_charge+ deals_price) >= Customer.customer_list.get(Global.index).getWallet()) {
                System.out.println("LOW Balance!!!");
                Customer.Login_Menu();
            } else {
                Customer.customer_list.get(Global.index).setWallet((cart_price + Delivery_charge+ deals_price));
                Cart.cart_list.clear();
                System.out.println("Order placed successfully!!!!");
                System.out.println("Order details:-");
                View_Cart(0);
                System.out.println("Delievery charge (100 + 5% of total amount): "+Delivery_charge);
                double t=cart_price+Delivery_charge+ deals_price;
                System.out.println("Total amount : "+t);
                int count = (int) Math.floor(Math.random() * (10 - 7 + 1) + 7);
                System.out.println("Order placed!!!\nYour order will be delivered within "+count+" days.......");
                Cart.Empty_Cart(0);
                Cart.Total_amount=0;
                }
                Customer.Login_Menu();
            }
        }
}
