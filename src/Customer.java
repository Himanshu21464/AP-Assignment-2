import java.util.Scanner;

public class Customer {

    String customer_name;
    String customer_password;
    String Status;
    double Wallet;
    public Customer(String name, String password){
        this.customer_name=name;
        this.customer_password=password;
        this.Status="NORMAL";
        this.Wallet=1000;
    }
    public static void Login_Menu(){
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
        System.out.println("Customer successfully registered!!!");

    }
    public static void Login(){
        System.out.print("Enter Name: ");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.print("Enter password: ");
        String password=sc.nextLine();


        System.out.println("Welcome "+name+"!!!");
        Login_Menu();
    }
}
