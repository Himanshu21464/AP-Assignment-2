import java.util.Scanner;
import java.lang.*;
public class Administrator {

    static int discount_Normal;
    static int discount_Elite;
    static int discount_Prime;
    public static void Add_Category(){
        System.out.print("Add Category ID: ");
        Scanner sc=new Scanner(System.in);
        int ID=sc.nextInt();
        sc.nextLine();
        System.out.print("Add name of category: ");
        String category = sc.nextLine();
        int w=0;
        for(int q=0;q<Category.category_list.size();q++){
            if(Category.category_list.get(q).category==ID){
                w+=1;
            }
        }
        if(w==0) {
            Category category1 = new Category(ID, category);
            Category.category_list.add(category1);
            System.out.println("Category Added Successfully");
            Admin_Menu();
        }else {
            System.out.println("Category Already Exist");
            Admin_Menu();
        }
    }
    public static void Delete_Category() {
        System.out.println("Enter ID of category: ");
        Scanner sc = new Scanner(System.in);
        int ID = sc.nextInt();
        if (!Category.category_list.isEmpty()) {
            int temp = 0;
            while (Category.category_list.get(temp).category != ID) {
                temp += 1;
            }
        if(temp>=0) {
            Category.category_list.remove(temp);
            for(int q=0;q<Product.product_list.size();q++){
                if(ID==(Product.product_list.get(q).category)){
                    Product.product_list.remove(q);
                }
            }
            System.out.println("Category removed successfully!!!");
            Admin_Menu();
        }
        }else {
            System.out.println("Category does not exist!!!");
            Admin_Menu();
        }
    }
    public static void Add_Product(){
        System.out.print("Add category ID: ");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<Category.category_list.size();i++){
            if(Category.category_list.get(i).category==id){
                System.out.println("-------Add a Product---------");
                System.out.print("Product name: ");
                String name=sc.nextLine();
                System.out.print("Product ID: ");
                double temp_id=sc.nextDouble();
                sc.nextLine();
                System.out.print("Features: ");
                String features=sc.nextLine();
                //sc.nextLine();
                System.out.print("Price: ");
                int price=sc.nextInt();
                System.out.print("Enter quantity: ");
                int quantity=sc.nextInt();
                //sc.nextLine();
                Product product=new Product(name,temp_id,price,features,id,quantity);
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
        for(int s=0;s<Product.product_list.size();s++){
            if(Product.product_list.get(s).ID==id){
                Product.product_list.get(s).discount=true;
            }
        }
        if(id==1){
            System.out.println("Enter discount for ELITE CUSTOMERS in % :");
            discount_Elite=sc.nextInt();
            System.out.println("Enter discount for PRIME CUSTOMERS in % :");
            discount_Prime=sc.nextInt();
            System.out.println("Enter discount for NORMAL CUSTOMERS in % :");
            discount_Normal=sc.nextInt();
            Admin_Menu();
        }else {
            System.out.println("Wrong Input!!!");
            Discount();
        }
    }
    public static void Giveaway() {
        /*
        System.out.print("Dear Admin give the Product IDs you want to combine and giveaway a deal for : ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Product ID: ");
        double id1 = sc.nextDouble();
        System.out.print("Enter Second Product ID: ");
        double id2=sc.nextDouble();
        for (int a = 0; a < Product.product_list.size(); a++){
            if((Product.product_list.get(a).ID==id1)&&(id1!=id2)){

                if ((Product.product_list.get(a).ID==id2))

            }

        }*/
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("Dear Admin give the Product IDs you want to combine and giveaway a deal for : ");
        //Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Product ID: ");
        double id1 = sc.nextDouble();
        for (int a = 0; a < Product.product_list.size(); a++) {
            if (Product.product_list.get(a).ID == id1) {
                System.out.print("Enter Second Product ID: ");
                double id2 = sc.nextDouble();
                for (int b = 0; a < Product.product_list.size(); b++) {
                    if (Product.product_list.get(b).ID == id2) {
                        System.out.print("Enter the combined price in rupees(should be less then their combined price): ");
                        double price = sc.nextInt();
                        Deals deals = new Deals(id1, id2, price);
                        Deals.deals_list.add(deals);
                        Admin_Menu();
                    }else{
                        System.out.println("Wrong Input!!!");
                        Giveaway();
                    }
                }
            }

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
        System.out.print("Please enter your Username: ");
        Scanner sc=new Scanner(System.in);
        String username= sc.nextLine();
        System.out.print("Please enter your Password: ");
        String password=sc.nextLine();

        if(username.equals("Himanshu")&&password.equals("12345")){
            System.out.println("Welcome Himanshu!!!");
            Admin_Menu();
        } /*else if (username.equals("Rishabh")&&(password.equals("67890"))) {
            System.out.println("Welcome Rishabh!!!");
            Admin_Menu();
        } */else {
            System.out.println("Wrong Username!!!");
            Credentials();
        }
    }
}
