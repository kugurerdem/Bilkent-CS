import java.util.Scanner;
import java.nio.file.*;   
import java.io.*;

/**
 * __lab03c: Information of Employee___ 
 * @author __Uður Erdem Seyfi___
 * @version __23.10.2018__
 */ 
public class Lab03c
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    //constants
    
    //variable
    String name;
    int age;
    double gross_sallary;
    
    //programcode
    
    // Getting name from the user
    name = scan.nextLine(); 
    // Getting age from the user
    age = scan.nextInt();
    // Getting salary from the user
    gross_sallary = scan.nextDouble();
    
    // Gettin comment
    scan.nextLine();
    
    String comment = scan.nextLine();
    
    if( age <= 0 ){
        System.out.println(" Given age is not a positive number. ");
    } else if( gross_sallary < 0 ){
        System.out.println(" Given sallary is not a positive number. ");
    } else if( gross_sallary > 10000){
        System.out.println(" Given sallary does exceed the maximum sallary limit");
    } else{
        
        // variables
        double tax_rate;
        double net_sallary;
        
        // determining tax_rate 
        if(gross_sallary < 1000){
            tax_rate = 0.05;
        } else if(gross_sallary > 5000){
            tax_rate = 0.25;
        } else{
            tax_rate = 0.15;
        }
        
        // Compute net sallary
        net_sallary = (gross_sallary - 100) * (1 - tax_rate);
        
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html>");
        System.out.println("<head>");
        System.out.println("<title> Derya's Home Page </title>");
        System.out.println("</head>");
        System.out.println("<body>");
        System.out.println("<hr> <h1>" + name + "</h1> <p>Age:" + age + "</p> <p>Net salary:"+  net_sallary + " with a tax rate " + tax_rate + "</p> Comment: <p>" + comment + "</p>");
        
        if( Files.exists( Paths.get("deneme/"+name+".jpg")) ){
            System.out.println("<img src=" + " \"" +name+".jpg\"" + ">");
        }
        
        System.out.println("</hr>");
        
        System.out.println("</body>");
        System.out.println("<html>");
    }
  }
} 