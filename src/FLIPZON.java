import java.util.Scanner;
public class FLIPZON {
    public static void Product_Catalog(){
        if(Product.product_list.isEmpty()){
            System.out.println("------------------------NO Products Available!!-----------------------");
            System.out.println(" ");
            Main_Menu();
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
            Main_Menu();
        }
    }
    public static void Available_Deals(){
        if(Deals.deals_list.isEmpty()){
            System.out.println("-------------------------NO Deals Available!!----------------------------");
            Main_Menu();
        }else{
            for(int x=0;x<Deals.deals_list.size();x++){
                System.out.println("ID of Ist product: "+Deals.deals_list.get(x).ID1);
                System.out.println("ID of 2nd product: "+Deals.deals_list.get(x).ID2);
                System.out.println("Giveaway Price (NORMAL) : "+Deals.deals_list.get(x).price);
                System.out.println("Giveaway Price (PRIME)  : "+Deals.deals_list.get(x).prime_price);
                System.out.println("Giveaway Price (ELITE)  : "+Deals.deals_list.get(x).elite_price);

                System.out.println("------------------------------------------------------------------");
                System.out.println(" ");
            }
            Main_Menu();
        }
    }
    public static void Main_Menu(){
        System.out.println("----------------------WELCOME TO FLIPZON-------------------------");
        System.out.println(" ");
        System.out.println("1. Enter as Administrator");
        System.out.println("2. Explore the Product Catalog");
        System.out.println("3. Show Available deals");
        System.out.println("4. Enter as Customer");
        System.out.println("5. Exit the Application");
        System.out.println("------------------------------------------------------------------");
        System.out.print("Enter your choice: ");
        Scanner sc=new Scanner(System.in);
        int choice1=sc.nextInt();
        if (choice1==1){
            Administrator.Credentials();
        } else if (choice1==2) {
            Product_Catalog();
        } else if (choice1==3) {
            Available_Deals();
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