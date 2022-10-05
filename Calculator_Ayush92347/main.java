import java.util.Scanner;

class Main

 {

  public static void main(String[] args) 

  {

    

  System.out.println("follow the rules to use the calculator");

  System.out.println("you can divide two number only");

  System.out.println("(√) this symbol is used to find the square root of a number (@) this symbol is used to find the cube root of a number (^) this symbol is used to find power(square or cube of a number ) of a number");

  System.out.println("in order to find the square root of a number write the number in number1 of which you want to find the  number square root");

  System.out.println("in order to find the cube root of a number write the number in number1 of which you want to find the  number cube root");

  System.out.println("in order to find the power of a number write number in number1 of which you want to find the power and in number2 write the power ");

  

    char operator;

    Double number1, number2, number3, result;

    Scanner input = new Scanner(System.in);

    // ask users to enter operator

    System.out.println("Choose an operator: +, -, *, /, √, @, or ^");

    operator = input.next().charAt(0);

    // ask users to enter numbers

    System.out.println("Enter first number");

    number1 = input.nextDouble();

    System.out.println("Enter second number");

    number2 = input.nextDouble();

    

    System.out.println("Enter third number");

    number3 = input.nextDouble();

    switch (operator) {

      // performs addition between  three numbers

      case '+':

        result = number1 + number2 + number3 ;

        System.out.println(number1 + " + " + number2 + " + " + number3 + " = " + result);

        break;

      // performs subtraction between  three numbers

      case '-':

        result = number1 - number2 - number3;

        System.out.println(number1 + " - " + number2 + " - " + number3 + " = " + result);

        break;

      // performs multiplication between three numbers

      case '*':

        result = number1 * number2 * number3;

        System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + result);

        break;

      // performs division between two numbers

      case '/':

        result = number1 / number2;

        System.out.println(number1 + " / " + number2 + " = " + result);

        break;

        

        // to find the square root of a number

        case '√':

        result = Math.sqrt(number1);

        System.out.println("Squareroot"+result);

        break;

        

        // to find the cube root of a number

        case '@':

        result = Math.cbrt(number1);

        System.out.println("Cuberoot"+result);

        break;

        

        // to find the power of a number

        case '^':

        result = Math.pow(number1,number2);

        System.out.println("Power"+result);

        break;

      default:

        System.out.println("Invalid operator!");

        break;

    }

   input.close();

  }

}
