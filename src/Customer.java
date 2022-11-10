import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Global {
    static String temp1;
    static String temp2;
    static int index;
    static int cart_quantity;
}
interface Printable{
    void print_();
}
public class Customer implements Printable{
    String customer_name;
    String customer_password;
    String Status;
    int coupons;
    public static ArrayList<Integer> disc_list=new ArrayList<Integer>();
    private double Wallet;
    static ArrayList<Customer> customer_list = new ArrayList<Customer>();

    public double getWallet() {
        return Wallet;
    }
    public void print_(){
        System.out.println("Customer successfully registered!!!");
    };

    public void setWallet(double wallet) {
        Wallet -= wallet;
    }

    public Customer(String name, String password) {
        this.customer_name = name;
        this.customer_password = password;
        this.Status = "NORMAL";
        this.Wallet = 1000;
        this.coupons = 0;
        disc_list.add(0);
        //this.coupons_discount = Administrator.discount_Normal;
    }
    public static void Product_Catalog(int parameter){
        if(Product.product_list.isEmpty()){
            System.out.println("------------------------NO Products Available!!-----------------------");
            System.out.println(" ");
            Login_Menu();
        }else{
            for(int x=0;x<Product.product_list.size();x++){
                System.out.println("Product ID: "+Product.product_list.get(x).ID);
                System.out.println("Product Name: "+Product.product_list.get(x).name);
                System.out.println("Product Details: "+Product.product_list.get(x).Features);
                System.out.println("Product Price: Rs "+Product.product_list.get(x).price+"/-");
                System.out.println("In Stock : "+Product.product_list.get(x).quantity);
                System.out.println("------------------------------------------------------------------");
                System.out.println(" ");
            }
        }
    }
    public static float max_utility(){
        float max;
        Collections.sort(disc_list);
        //Collections.sort(disc_list);
        if(disc_list.isEmpty()){
            max=0;
        }else {
            max = disc_list.get(0);
        }
        return max;
    }
    public static void Login_Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println(" 1. Browse Products");
        System.out.println(" 2. Browse Deals");
        System.out.println(" 3. Add a product to cart");
        System.out.println(" 4. Add products in deal to cart");
        System.out.println(" 5. View coupons");
        System.out.println(" 6. Check amount balance");
        System.out.println(" 7. View Cart");
        System.out.println(" 8. Empty Cart");
        System.out.println(" 9. Checkout Cart");
        System.out.println("10. Upgrade customer Status");
        System.out.println("11. Add amount to Wallet");
        System.out.println("12. Back");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Enter your choice: ");
        int choice4 = sc.nextInt();
        sc.nextLine();
        if (choice4 == 1) {
            if(Product.product_list.isEmpty()){
                System.out.println("------------------NO Products Available!!-----------------------");
                System.out.println(" ");
                Login_Menu();
            }else{
                for(int x=0;x<Product.product_list.size();x++){
                    System.out.println("Product ID: "+Product.product_list.get(x).ID);
                    System.out.println("Product Name: "+Product.product_list.get(x).name);
                    System.out.println("Product Details: "+Product.product_list.get(x).Features);
                    System.out.println("Product Price: Rs "+Product.product_list.get(x).price+"/-");
                    System.out.println("In Stock : "+Product.product_list.get(x).quantity);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println(" ");
                }
                Login_Menu();
            }
        } else if (choice4 == 2) {
            if(Deals.deals_list.isEmpty()){
                System.out.println("---------------------NO Deals Available!!----------------------------");
                System.out.println(" ");
                Login_Menu();
            }else{
                for(int x=0;x<Deals.deals_list.size();x++){
                    System.out.println("ID of Ist product: "+Deals.deals_list.get(x).ID1);
                    System.out.println("ID of 2nd product: "+Deals.deals_list.get(x).ID2);
                    System.out.println("Giveaway Price: "+Deals.deals_list.get(x).price);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println(" ");
                }
                Login_Menu();
            }
        } else if (choice4 == 3) {
            Cart.Add_To_Cart();
        } else if (choice4 == 4) {
            Cart.Add_Deals_To_Cart();
        } else if (choice4 == 5) {
            if(!disc_list.isEmpty()) {
                System.out.println("Available coupons: ");
                for (int h = 0; h < disc_list.size(); h++) {
                    System.out.println("Discount % :" + disc_list.get(h));
                }
                Login_Menu();
            }else{
                System.out.println("No Coupons Available!!!");
                Login_Menu();
            }
        } else if (choice4 == 6) {
            System.out.println("Your Account balance is : Rs " + Customer.customer_list.get(Global.index).getWallet());
            Login_Menu();
        } else if (choice4 == 7) {
            Cart.View_Cart();

        } else if (choice4 == 8) {
            Cart.Empty_Cart();
        } else if (choice4 == 9) {
            Cart.Checkout();
        } else if (choice4 == 10) {
            int ind = -1;
            String indx1 = Global.temp1;
            String indx2 = Global.temp2;
            for (int a = 0; a < Customer.customer_list.size(); a++) {
                if (Customer.customer_list.get(a).customer_name.equals(indx1) && (Customer.customer_list.get(a).customer_password.equals(indx2))) {
                    ind = a;
                }
                Global.index=ind;
                System.out.println("---------------------------------------------------------- ");
                System.out.println("Your Current status: " + Customer.customer_list.get(ind).Status);
                System.out.print("Choose new Status:  ");
                String sts = sc.nextLine();
                if (sts.equals(Customer.customer_list.get(ind).Status)) {
                    System.out.println("Current and New status can't be same!!!");
                    System.out.println(" ");
                    Login_Menu();
                } else {
                    if (Customer.customer_list.get(ind).Status.equals("PRIME")) {
                        if (sts.equals("NORMAL")) {
                            System.out.println("Your can't degrade your Status!!!");
                            System.out.println(" ");
                            Login_Menu();
                        } else {
                            if (Customer.customer_list.get(ind).Wallet < 300) {
                                System.out.println("Insufficient Balance!!!");
                                System.out.println(" ");
                                Login_Menu();
                            } else {
                                Customer.customer_list.get(ind).Wallet -= 300;
                                Customer.customer_list.get(ind).Status = sts;
                                //Customer.customer_list.get(ind).coupons=4;
                                //Customer.customer_list.get(ind).coupons_discount=Administrator.discount_Elite;
                                System.out.println("Status updated successfully!!!");
                                System.out.println("----------------------------------------------");
                                System.out.println(" ");
                                Login_Menu();
                            }
                        }
                    } else if (Customer.customer_list.get(ind).Status.equals("ELITE")) {
                        System.out.println("Your current status is already maxed!!! ");
                        System.out.println(" ");
                        Login_Menu();
                    } else if (Customer.customer_list.get(ind).Status.equals("NORMAL")) {
                        if (sts.equals("ELITE")) {
                            if (Customer.customer_list.get(ind).Wallet < 300) {
                                System.out.println("Insufficient balance!!!");
                                System.out.println("----------------------------------------------");
                                System.out.println(" ");
                                Login_Menu();
                            } else {
                                Customer.customer_list.get(ind).Wallet -= 300;
                                Customer.customer_list.get(ind).Status = sts;
                                //Customer.customer_list.get(ind).coupons=4;
                                //Customer.customer_list.get(ind).coupons_discount=Administrator.discount_Elite;
                                System.out.println("Status updated successfully!!!");
                                System.out.println("----------------------------------------------");
                                System.out.println(" ");
                                Login_Menu();
                            }
                        } else if (sts.equals("PRIME")) {
                            if (Customer.customer_list.get(ind).Wallet < 200) {
                                System.out.println("Insufficient Balance!!");
                                System.out.println("----------------------------------------------");
                                System.out.println(" ");
                            } else {
                                Customer.customer_list.get(ind).Wallet -= 200;
                                Customer.customer_list.get(ind).Status = sts;
                                //Customer.customer_list.get(ind).coupons=2;
                                //Customer.customer_list.get(ind).coupons_discount=Administrator.discount_Prime;
                                System.out.println("Status updated successfully!!!");
                                System.out.println("----------------------------------------------");
                                System.out.println(" ");
                                Login_Menu();
                            }

                        }
                    }
                }
            }
        } else if (choice4 == 11) {
                System.out.print("Enter amount in rupees you wish to add: ");
                double amount = sc.nextInt();
                int z = Global.index;
                Customer.customer_list.get(z).Wallet += amount;
                System.out.println("Rs " + amount + "/- has been successfully added to your wallet!!!");
            System.out.println("----------------------------------------------");
            System.out.println(" ");
                Login_Menu();
            } else if (choice4 == 12) {
                Customer_Menu();
            } else {
                System.out.println("Wrong Input!!!");
                Login_Menu();
            }
        }
    public static void Customer_Menu() {
        System.out.println("----------------------------------------------");
        System.out.println("1. Sign up");
        System.out.println("2. Login");
        System.out.println("3. Back");
        System.out.println("----------------------------------------------");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice3 = sc.nextInt();
        if (choice3 == 1) {
            Signup();
        } else if (choice3 == 2) {
            Login();
        } else if (choice3 == 3) {
            FLIPZON.Main_Menu();
        } else {
            System.out.println("Wrong Input!!!");
            System.out.println("----------------------------------------------");
            System.out.println(" ");
            Customer_Menu();
        }
    }
    public static void Signup() {
        System.out.print("Enter Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        Customer customer = new Customer(name, password);
        Customer.customer_list.add(customer);
        customer.print_();
        Customer_Menu();
    }
    public static void Login() {
        if (Customer.customer_list.size() == 0) {
            System.out.println("Please sign up first");
            Customer_Menu();
        } else {
            System.out.print("Enter Name: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            //Global(name,password);
            Global.temp1 = name;
            Global.temp2 = password;
            for (int i = 0; i < Customer.customer_list.size(); i++) {
                if ((name.equals((Customer.customer_list.get(i).customer_name))) && (password.equals(Customer.customer_list.get(i).customer_password))) {
                    System.out.println("-------------------------Welcome " + name + "!!!--------------");
                    Login_Menu();
                } else {
                    System.out.println("Wrong Credentials or User not registered!!! \nTry to register for user with these credentials by pressing 1 or Login again by pressing 2:  ");
                    int temp = sc.nextInt();
                    if (temp == 1) {
                        Signup();
                    } else if (temp == 2) {
                        Login();
                    } else {
                        FLIPZON.Main_Menu();
                    }
                }
            }
        }
    }
}
