import java.util.Scanner;

public class FLIPZON {
    public static void Main_Menu(){
        System.out.println("WELCOME TO FLIPZON");
        System.out.println("1. Enter as Administrator");
        System.out.println("2. Explore the Product Catalog");
        System.out.println("3. Show Available deals");
        System.out.println("4. Enter as Customer");
        System.out.println("5. Exit the Application");
    }

    public static void main(String[] args) {
        Main_Menu();
        System.out.print("Enter your choice: ");
        Scanner sc=new Scanner(System.in);
        int choice1=sc.nextInt();
        if (choice1==1){
            Administrator.Credentials();
        } else if (choice1==2) {
            //Product.Catalog();

        } else if (choice1==3) {

        } else if (choice1==4) {

        } else if (choice1==5) {
            System.exit(0);
        }else {
            System.out.println("Wrong Input!!!");
            Main_Menu();
        }

    }
}
