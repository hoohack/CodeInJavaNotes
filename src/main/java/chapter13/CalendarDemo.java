package chapter13;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class CalendarDemo {

    public static void printCurrentMonth() {
        Calendar calendar = Calendar.getInstance();

        Map<Integer, String> weekStr = new HashMap<>();
        weekStr.put(0, "日");
        weekStr.put(1, "一");
        weekStr.put(2, "二");
        weekStr.put(3, "三");
        weekStr.put(4, "四");
        weekStr.put(5, "五");
        weekStr.put(6, "六");

        System.out.printf("%d-%d-%d 星期%s\n",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DATE),
                weekStr.get(calendar.get(Calendar.DAY_OF_WEEK)-1));

        weekStr.values().forEach((val) -> out.print(val + "\t"));
        out.println();

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int firstDayInMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= lastDate; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            if (i == 1) {
                for (int j = 0; j < firstDayInMonth; j++) {
                    System.out.print("\t");
                }
            }

            out.print(i + "\t");

            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                out.println();
            }
        }
    }

    public static void main(String[] args) {
        CalendarDemo.printCurrentMonth();
    }

}
