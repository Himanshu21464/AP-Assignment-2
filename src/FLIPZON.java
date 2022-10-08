import java.util.Scanner;
public class FLIPZON {
    public static void Main_Menu(){
        System.out.println("WELCOME TO FLIPZON");
        System.out.println("1. Enter as Administrator");
        System.out.println("2. Explore the Product Catalog");
        System.out.println("3. Show Available deals");
        System.out.println("4. Enter as Customer");
        System.out.println("5. Exit the Application");
        System.out.print("Enter your choice: ");
        Scanner sc=new Scanner(System.in);
        int choice1=sc.nextInt();
        if (choice1==1){
            Administrator.Credentials();
        } else if (choice1==2) {
            if(Product.product_list.isEmpty()){
                System.out.println("NO Products Available!!");
                Main_Menu();
            }else{
                for(int x=0;x<Product.product_list.size();x++){
                    System.out.println(Product.product_list);
                    Main_Menu();
                }
            }
        } else if (choice1==3) {
            if(Deals.deals_list.isEmpty()){
                System.out.println("NO Deals Available!!");
                Main_Menu();
            }else{
                for(int x=0;x<Deals.deals_list.size();x++){
                    System.out.println(Deals.deals_list);
                    Main_Menu();
                }
            }
        } else if (choice1==4) {
            Customer.Customer_Menu();
        } else if (choice1==5) {
            System.exit(0);
        }else {
            System.out.println("Wrong Input!!!");
            Main_Menu();
        }
    }
    public static void main(String[] args) {
        Main_Menu();
    }
}