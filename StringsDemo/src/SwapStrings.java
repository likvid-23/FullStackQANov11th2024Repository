import java.util.Arrays;

public class SwapStrings {
    private static void swap()
    {
        String s="Mysore and Bangalore";
        System.out.println("Given sentence is : "+s);
        System.out.println("Changed sentence is :");
       String str[]=s.split(" ");
       for(int i=str.length-1;i>=0;i--)
       {
           System.out.print(str[i]+" ");
       }
       System.out.println();
    }

    private static void countwords()
    {
        String s="Bangalore is Garden City";
        System.out.println("Number of characters including space is :"+s.length());

        String str[]=s.split(" ");
        System.out.println("The given sentence is "+s+" and it consists of "+str.length+" number of words");

        String s2=s.replace(" ","");
        int n = s2.length();
        System.out.println("Number of characters excluding space is :"+n);
    }
    public static void main(String[] args)
    {
        swap();
        countwords();
    }
}

