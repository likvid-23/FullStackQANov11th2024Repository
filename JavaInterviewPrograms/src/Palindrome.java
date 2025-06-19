import java.util.Scanner;

public class Palindrome {

    public static void palindromeString(String input)
    {
        String givenString=input;
        String reversed="";
         for(int i=0;i<input.length();i++)
         {
         reversed= input.charAt(i)+reversed;
         }
        System.out.println("Reversed String :"+reversed);
      if(givenString.equals(reversed))
      {
          System.out.println("Entered String is a Palindrome");
      }
      else
      {
          System.out.println("Entered String is not a Palindrome");

      }
    }

    public static void palindromeNumber(int num)
    {
        String number = Integer.toString(num);
        System.out.println(number.length());
        String reversed="";
        for(int i=0;i<number.length();i++)
        {
            reversed= number.charAt(i)+reversed;
        }
        System.out.println("Reversed Number :"+reversed);
        if(number.equals(reversed))
        {
            System.out.println("Entered number is a Palindrome");
        }
        else
        {
            System.out.println("Entered number is not a Palindrome");

        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string :");
        String userinput = sc.next();
        System.out.println("Entered String is :"+userinput);
        palindromeString(userinput);
        System.out.println("Enter the number :");
        int numberinput = sc.nextInt();
        palindromeNumber(numberinput);
    }
}
