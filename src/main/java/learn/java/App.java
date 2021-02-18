package learn.java;
import java.text.*;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws ParseException {

        System.out.println(String.format("%n-------Enter date YYY-MM-DD-----------------"));
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        System.out.println(date);
        if(date == null || date.isEmpty())
        {
            System.out.println("date");
            date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            System.out.println(date);
        }

        System.out.println(String.format("%n-------Luck number -----------------"));
        String lns = sc.nextLine();
        if ((lns == null ) || lns .isEmpty()){
            lns ="1,6,7";
        }
        String[] x = lns.split(",");
        ArrayList<Integer> ln = new ArrayList<>();
        for(String xx : x){
            int foo;
            try {
                foo = Integer.parseInt(xx);
                ln.add(foo);
            }
            catch (NumberFormatException e)
            {}
        }
        System.out.println( "Hello World!" );
        luckyDate(date,ln);
    }

    private static void luckyDate(String startDate, ArrayList<Integer> luckynumber) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(startDate);

        DateFormat d = new SimpleDateFormat("MM-dd-yyy");
        System.out.printf("CURRENT DATE - %s %n",date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.printf("Subject,Start Date, All Day Event%n");
        int i = 0;
        while (i < 1000) {
            int month = cal.get(Calendar.MONTH) +1 ;
            int day = cal.get(Calendar.DATE);
            int year = cal.get(Calendar.YEAR);
            int total = month + day + year;
            int x = findnumber(total);
            if (luckynumber.contains(x))
            System.out.printf("Good Day [%d], %-25s,TRUE %n", x,new SimpleDateFormat("yyyy/MM/dd EEEEE").format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
            i++;
        }
    }


    private static int findnumber(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
           // System.out.println(num);
        }

        sum = (sum < 10) ? sum : findnumber(sum);
        return sum;
    }
}

