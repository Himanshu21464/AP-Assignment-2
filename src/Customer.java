import java.util.ArrayList;
import java.util.Scanner;
public class Customer {
    String customer_name;
    String customer_password;
    String Status;
    int coupons;
    double Wallet;
    static ArrayList<Customer> customer_list=new ArrayList<Customer>();
    public Customer(String name, String password){
        this.customer_name=name;
        this.customer_password=password;
        this.Status="NORMAL";
        this.Wallet=1000;
    }
    public static void Login_Menu(){
        Scanner sc=new Scanner(System.in);
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
        System.out.print("Enter your choice: ");
        int choice4=sc.nextInt();
        if (choice4==1){
            while(true){
                System.out.println(Product.product_list);
            }
        } else if (choice4==2) {
            while (true){
                System.out.println(Deals.deals_list);
            }
        } else if (choice4==3) {
            Cart.Add_To_Cart();
        } else if (choice4==4) {
            Cart.Add_Deals_To_Cart();
        } else if (choice4==5) {
            Coupons();
            Login_Menu();
        } else if (choice4==6) {
            System.out.println("Your Account balance is : Rs "+Customer.customer_list.get(0).Wallet);
            Login_Menu();
        } else if (choice4==7) {
            Cart.View_Cart();

        } else if (choice4==8) {
            Cart.Empty_Cart();

        } else if (choice4==9) {
            Cart.Checkout();
        } else if (choice4==10) {
            int a=0;
            System.out.println("Your Current status: "+Customer.customer_list.get(a).Status);
            System.out.print("Choose new Status:  ");
            String sts=sc.nextLine();
            if((sts!=Customer.customer_list.get(a).Status)&&(Customer.customer_list.get(0).Wallet>=300)){
                Customer.customer_list.get(a).Status=sts;
                System.out.println("status updated to "+sts);
            }else {
                System.out.println("Wrong Input!!!");
                Login_Menu();
            }
        } else if (choice4==11) {
            System.out.println("Enter amount in rupees you wish to add: ");
            double amount=sc.nextInt();
            int z=0;
            Customer.customer_list.get(z).Wallet+=amount;
            System.out.println("Rs "+amount +"/- has been successfully added to your wallet!!!");
            Login_Menu();
        } else if (choice4==12) {
            FLIPZON.Main_Menu();
        } else {
            System.out.println("Wrong Input!!!");
            Login_Menu();
        }
    }
    public static void Coupons(){
    }
    public static void Customer_Menu(){
        System.out.println("1. Sign up");
        System.out.println("2. Login");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        Scanner sc=new Scanner(System.in);
        int choice3=sc.nextInt();
        if (choice3==1){
            Signup();
        } else if (choice3==2) {
            Login();
        } else if (choice3==3) {
            FLIPZON.Main_Menu();
        }else {
            System.out.println("Wrong Input!!!");
            Customer_Menu();
        }
    }
    public static void Signup(){
        System.out.print("Enter Name: ");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.print("Enter password: ");
        String password=sc.nextLine();
        Customer customer=new Customer(name, password);
        Customer.customer_list.add(customer);
        System.out.println("Customer successfully registered!!!");
        Customer_Menu();
    }
    public static void Login(){
        System.out.print("Enter Name: ");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.print("Enter password: ");
        String password=sc.nextLine();
        int i=0;
        //while((Customer.customer_list.get(i).customer_name==name)&&(Customer.customer_list.get(i).customer_password==password )){
        //
        for (i=0;i<Customer.customer_list.size();i++){
            if((Customer.customer_list.get(i).customer_name==name)&&(Customer.customer_list.get(i).customer_password==password)){
                System.out.println("Welcome "+name+"!!!");
                Login_Menu();
            }else{
             continue;
            }
        }
        System.out.println("Wrong Credentials!!!");
        Login();
    }
}