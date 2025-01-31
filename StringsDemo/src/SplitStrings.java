public class SplitStrings
{
    private static void splitString()
    {
        String s="SUNDAYMONDAYTUESDAYWEDNESDAYTHURSDAYFRIDAYSATURDAY";
        System.out.println("The Given String is :"+s);
        String str[]=s.split("DAY");
        for(String kk:str)
        {
            System.out.print(kk);
        }
        System.out.println();
        System.out.println("+++++++++++++++++++");
    }
    private static void insertString()
    {
        String s="SUNDAYMONDAYTUESDAYWEDNESDAYTHURSDAYFRIDAYSATURDAY";
        System.out.println("The Given String is :"+s);
        StringBuilder s1=new StringBuilder(s);
        s1.insert(6,",");
        s1.insert(13,",");
        s1.insert(21,",");
        s1.insert(31,",");
        s1.insert(40,",");
        s1.insert(47,",");
        System.out.println(s1);


    }
    public static void main(String[] args)
    {
        splitString();
        insertString();
    }
}
