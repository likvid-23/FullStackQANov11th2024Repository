public class CharCountDemo {
    private static int charcount(String str)
    {
        int count=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<str.length();i++) {
        count=count+1;
        }
        return count;
    }

    public static void main(String[] args)
    {

        String  str= "SG Testing" ;

        System.out.println("The String is :"+str);

        System.out.println("Length of the given String is :"+charcount(str));
    }
}
