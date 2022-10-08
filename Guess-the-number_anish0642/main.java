import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
    //instructions
    System.out.println("        Rules ");
    System.out.println("Rules are very simple.");
    System.out.println("\t*This game is played by 2 members.");
    System.out.println("\t*Each player need to select a number between 0-100");
    System.out.println("\t*Computer selects a random number.");
    System.out.println("\t*Whose number is nearest to the selected number.\n\t They are declared as WINNER.");
    System.out.println("\t*Winner gives a task to loser and loser need to do it.");
    System.out.println("I hope the rules are clear.");
    //continue 
    char ch;
    Scanner sc=new Scanner (System.in);
    System.out.print("When you are ready enter + :");
    ch= sc.next().charAt(0);
    while(ch!='+')
    {
      System.out.println("Invalid code");
      System.out.print("Enter the code again : ");
      ch= sc.next().charAt(0);
    }
    if(ch=='+')
    {
    System.out.println("Here we go!");
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();
    System.out.println();
     //random number
     double f,s,n;
     int z;
    f=Math.random();
    f=f*100;
    s=Math.random();
    s=s*10;
    n=f+s;
    z=(int)n;
    while(100<z)
    {
    f=Math.random();
    f=f*100;
    s=Math.random();
    s=s*10;
    n=f+s;
    z=(int)n;
    }
    //names
    Scanner na=new Scanner(System.in);
    String fn,sn;
    System.out.print("Enter the First player name : ");
    fn=na.nextLine();
    System.out.print("Enter the Second player name : ");
    sn=na.nextLine();
    System.out.println();
    //input
    int a,b;
    System.out.print("Enter the "+fn+"'s number : ");
    a=sc.nextInt();
    while(100<a)
    {
      System.out.println("Invalid number");
      System.out.print("Enter again : ");
      a=sc.nextInt();
    }
    System.out.print("Enter the "+sn+"'s number : ");
    b=sc.nextInt();
    while(100<b)
    {
      System.out.println("Invalid number");
      System.out.print("Enter again : ");
      b=sc.nextInt();
    }
    //winner
    int d1,d2;
    char winner;
    if(a>z)
      d1=a-z;
     else
      d1=z-a;
    if(b>z)
      d2=b-z;
     else
      d2=z-b;
    //output
    System.out.println();
    System.out.println();
    System.out.println("Random number is "+z);
    System.out.println(fn+" : "+a);
    System.out.println(sn+" : "+b);
    System.out.println();
    if (d1==d2)
    {
      System.out.println("Oops!");
      System.out.println("This is strange.");
      System.out.println("Both are Winners.\nAnd now there is no need of task.");
    }
    else if(d1<d2)
    {
      System.out.println("Winner is "+fn+".");
      System.out.println("Congratulations👏 "+fn+".");
      System.out.println("Sorry "+sn+", you lost. Get ready for the task!");
     }
    else
    {
      System.out.println("Winner is "+sn+".");
      System.out.println("Congratulations👏 "+sn+".");
      System.out.println("Sorry "+fn+", you lost. Get ready for the task!");
     }
    System.out.println();
    System.out.println();
    System.out.println("---------------------------------------------------------------------------------------------");
    }
   }
 }
