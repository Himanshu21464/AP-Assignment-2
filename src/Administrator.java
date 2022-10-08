import java.util.Scanner;
import java.lang.*;
class Administrator {

    static final String admin1="Himanshu";
    static final String password1="12345";
    static final String admin2="Rishabh";
    static final String password2="67890";

    public static void Add_Category(){
        System.out.print("Add Category ID: ");
        Scanner sc=new Scanner(System.in);
        int ID=sc.nextInt();
        sc.nextLine();
        System.out.print("Add name of category: ");
        String category=sc.nextLine();
        System.out.println("Category Added Successfully");
        Category category1=new Category();
        Category.category_list.add(ID,category1);
        Admin_Menu();

    }
    public static void Delete_Category(){
        System.out.println("Enter ID of category: ");
        Scanner sc=new Scanner(System.in);
        int ID=sc.nextInt();
        for (int i=0;i<Category.category_list.size();i++) {
            if (Category.category_list.get(i).category==ID) {
                Category.category_list.remove(i);
                for (i=0;i<Product.product_list.size();i++){
                    if((int)Product.product_list.get(i).ID==ID){
                        Product.product_list.remove(i);
                    }else{
                        continue;
                    }
                }
                System.out.println("Category deleted successfully!!!");
                Admin_Menu();
            }else {
                System.out.println("Category not Found!!!");
                Delete_Category();
            }
        }
    }
    public static void Add_Product(){
        System.out.println("Add category ID: ");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        for(int i=0;i<Category.category_list.size();i++){
            if(Category.category_list.get(i).category==id){
                System.out.println("-------Add a Product---------");
                System.out.print("Product name: ");
                String name=sc.nextLine();
                System.out.print("Product ID: ");
                int temp_id=sc.nextInt();
                sc.nextLine();
                System.out.println("Features: ");
                String features=sc.nextLine();
                System.out.print("Price: ");
                int price=sc.nextInt();
                Product product=new Product(name,temp_id,price,features,id);
                Product.product_list.add(product);
                Admin_Menu();
            }else{
                System.out.println("Wrong category ID!!!");
                Admin_Menu();
            }
        }
    }
    public static void Delete_Product(){
        System.out.println("Enter ID of category: ");
        Scanner sc=new Scanner(System.in);
        int ID=sc.nextInt();
        int i=0;
        for (i=0;i<Category.category_list.size();i++){
            if(Category.category_list.get(i).category==ID){
                System.out.println("Enter Product ID: ");
                double id=sc.nextDouble();
                int temp=(int) id;
                if(temp==ID){
                    for (int x=0;x<Product.product_list.size();x++){
                        if(Product.product_list.get(x).ID==id){
                            Product.product_list.remove(x);
                            System.out.println("Product removed successfully!!!");
                            Admin_Menu();
                        }else{
                            continue;
                        }
                    }
                }else{
                    System.out.println("Wrong Product ID!!!");
                    Delete_Product();
                }
            }else {
                System.out.println("Wrong Input!!!");
                Admin_Menu();
            }
        }
    }
    public static void Discount(){
        System.out.print("Dear Admin give the Product ID you want to add discount for: ");
        Scanner sc=new Scanner(System.in);
        double id=sc.nextDouble();
        if(id==1){
            System.out.println("Enter discount for ELITE CUSTOMERS in % :");
            int Elite_disc=sc.nextInt();
            System.out.println("Enter discount for PRIME CUSTOMERS in % :");
            int Prime_disc=sc.nextInt();
            System.out.println("Enter discount for NORMAL CUSTOMERS in % :");
            int Normal_disc=sc.nextInt();
            Admin_Menu();
        }else {
            System.out.println("Wrong Input!!!");
            Discount();
        }
    }
    public static void Giveaway(){
        System.out.print("Dear Admin give the Product IDs you want to combine and giveaway a deal for : ");
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter First Product ID: ");
        double id1=sc.nextDouble();
        if(id1==1) {
            System.out.print("Enter Second Product ID: ");
            double id2 = sc.nextDouble();
            if(id2==1){
                System.out.print("Enter the combined price in rupees(should be less then their combined price): ");
                double price=sc.nextInt();
                Deals deals=new Deals(id1,id2,price);
                Deals.deals_list.add(deals);
                Admin_Menu();
            }else {
                System.out.println("Wrong Input!!!");
                Giveaway();
            }
        }else{
            System.out.println("Wrong Input!!!");
            Giveaway();
        }



    }
    public static void Admin_Menu(){

        System.out.println("1. Add Category");
        System.out.println("2. Delete Category");
        System.out.println("3. Add Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Set Discount on Product");
        System.out.println("6. Add giveaway deal");
        System.out.println("7. Back");
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice2=sc.nextInt();
        if (choice2==1){
            Add_Category();
        } else if (choice2==2) {
            Delete_Category();
        } else if (choice2==3) {
            Add_Product();
        } else if (choice2==4) {
            Delete_Product();
        } else if (choice2==5) {
            Discount();
        } else if (choice2==6) {
            Giveaway();
        } else if (choice2==7) {
            FLIPZON.Main_Menu();
        }else {
            System.out.println("Wrong Input!!!");
            Admin_Menu();
        }
    }
    public static void Credentials(){
        System.out.println("Dear Admin");
        System.out.println("Please enter your Username and password");
        Scanner sc=new Scanner(System.in);
        int username= sc.nextInt();
        int password;
        if (username==1) {
            //int temp=sc.nextInt();
            password=sc.nextInt();
            if (password==123){
                System.out.println("Welcome "+username+"!!!");
                Admin_Menu();
            } else {
                System.out.println("Wrong password!!");
                Credentials();
            }
        } else if (username==2) {
             password=sc.nextInt();
            if (password==456){
                System.out.println("Welcome "+username+"!!!");
                Admin_Menu();
            }else {
                System.out.println("Wrong password!!");
                Credentials();
            }
        }else {
            System.out.println("Wrong Username!!!");
            Credentials();
        }

    }
}