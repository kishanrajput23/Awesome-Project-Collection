import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
    System.out.println("Hello, Dcoder!");
  // move 
 // 0 for Rock 
 // 1 for Paper
 // 2 for Scissor
 
 //user input
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter 0 for Rock, 1 for Paper, 2 for Scissor ");
 int userInput = sc.nextInt();
 
// computer input
Random random = new Random();
 int computerInput = random.nextInt(3);
 
//main code
if (userInput == computerInput) {
System.out.println("Draw");
}
else if (userInput == 0 && computerInput == 2 || userInput == 1 && computerInput == 0|| userInput == 2 && computerInput == 1) {
System.out.println("You Win!");
} else {
System.out.println("Computer Win!");
 }
 
 //Computer move
 if(computerInput==0){
System.out.println("Computer move: Rock");
 }
else if(computerInput==1){
System.out.println("Computer move: Paper");
}
else if(computerInput==2){
System.out.println("Computer move: Scissors");
}
}
}        
       
        
