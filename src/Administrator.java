import javax.swing.*;
import java.util.Scanner;
import java.io.*;

class Administrator {

    /*String Admin1="Himanshu";
       String Admin1_password="Adminpass1";
       String Admin2="Rishabh";
       String Admin2_password="Adminpass2";*/

    public static void Add_Category(){

    }
    public static void Delete_Category(){

    }
    public static void Add_Product(){

    }
    public static void Delete_Product(){

    }
    public static void Discount(){

    }
    public static void Giveaway(){

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
        String username= sc.nextLine();
        String password;

        if (username=="Himanshu") {
            password=sc.nextLine();
            if (password=="Adminpass1"){
                System.out.println("Welcome "+username+"!!!");
                Admin_Menu();
            } else {
                System.out.println("Wrong password!!");
                Credentials();
            }
        } else if (username=="Rishabh") {
             password=sc.nextLine();
            if (password=="Adminpass2"){
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
