import java.util.Arrays;

public class Anagram {
   public static void anagramCheck(String text1,String text2)
   {
       if(text1.length()==text2.length())
       {
        char[] t1= text1.toCharArray();
           char[] t2 = text2.toCharArray();
           System.out.println(t1);
           System.out.println(t2);
           Arrays.sort(t1);

           Arrays.sort(t2);
           if(Arrays.equals(t1,t2))
           {
               System.out.println("its anagram");
               System.out.println(t1);
               System.out.println(t2);
           }
           else
           {
               System.out.println("not anagram");
               System.out.println(t1);
               System.out.println(t2);
           }
       }

   }
    public static void main(String[] args) {

        anagramCheck("listen","silent");
    }
}
