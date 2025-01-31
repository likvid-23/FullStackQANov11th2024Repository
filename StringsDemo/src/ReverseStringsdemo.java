public class ReverseStringsdemo {
    public static void main(String[] args) {
        /* Reverse the String using CharArray */
        String s=new String("Hello World");
        System.out.println("Length of the String is : "+s.length());
      System.out.println("Actual string:"+s);
        char[] str = s.toCharArray();
        System.out.println("The reversed string :");
        for(int i=s.length()-1;i>=0;i--)
        {
           System.out.print(str[i]);
        }
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        /* Reverse the String using CharAt */
        System.out.println("Actual string:"+s);
        System.out.println("The reversed string :");
        for(int i=s.length()-1;i>=0;i--)
        {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        /* Reverse the String using Substring*/
        System.out.println("Actual string:"+s);


    }
}