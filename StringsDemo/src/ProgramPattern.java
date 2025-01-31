public class ProgramPattern
{
    public static void main(String[] args)
    {
        String s="PROGRAM";
        System.out.println("Length of the String is :"+s.length());
        for(int i=0;i<s.length();i++)
        {
            System.out.println(s.substring(0,s.length()-i));
        }
        for(int i=1;i<=s.length();i++)
        {
            System.out.println(s.substring(0,i));
        }
    }
}
