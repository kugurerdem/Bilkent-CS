import java.util.Scanner;

/**
 * __lab02e: Information of Employee___ 
 * @author __Uður Erdem Seyfi___
 * @version __16.10.2018__
 */ 
public class Lab02e
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    // Getting name from the user
    String name = scan.nextLine(); 
    // Getting age from the user
    int age = scan.nextInt();
    // Getting salary from the user
    double sallary = scan.nextDouble();
    
    // Gettin comment
    scan.nextLine();
    
    String comment = scan.nextLine();
    
    System.out.println("<!DOCTYPE html>");
    System.out.println("<html>");
    System.out.println("<head>");
    System.out.println("<title> Derya's Home Page </title>");
    System.out.println("</head>");
    System.out.println("<body>");
    System.out.println("<hr> <h1>" + name + "</h1> <p>Age:" + age + "</p> <p>Salary:"+  sallary + "</p> Comment: <p>" + comment + "</p> <hr>");
    System.out.println("</body>");
    System.out.println("<html>");
    
  }
} 