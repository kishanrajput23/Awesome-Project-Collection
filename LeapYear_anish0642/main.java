import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
    System.out.println("Hello, Dcoder!");
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter the year");
    int year= sc.nextInt();
    if(year%4==0){
    System.out.print("Leap year");
   }else{
    System.out.print("Not Leap year");
   }
 }
}
