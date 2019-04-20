package chapter13;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static java.time.temporal.ChronoUnit.DAYS;

public class NewTimeDemo {

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();

        Map<Integer, String> weekStr = new HashMap<>();
        weekStr.put(0, "日");
        weekStr.put(1, "一");
        weekStr.put(2, "二");
        weekStr.put(3, "三");
        weekStr.put(4, "四");
        weekStr.put(5, "五");
        weekStr.put(6, "六");

        System.out.printf("%d-%d-%d 星期%s\n",
                nowDate.getYear(),
                nowDate.getMonth().getValue(),
                nowDate.getDayOfMonth(),
                weekStr.get(nowDate.getDayOfWeek().getValue()));

        weekStr.values().forEach((val) -> out.print(val + "\t"));
        out.println();

        LocalDate firstDate = nowDate.minus(nowDate.getDayOfMonth()-1, DAYS);
        int lastDate = nowDate.lengthOfMonth();
        int firstDayInMonth = firstDate.getDayOfMonth();
        LocalDate curDate = firstDate;

        for (int i = 1; i <= lastDate; i++) {
            curDate = curDate.plus(1, DAYS);

            if (i == 1) {
                for (int j = 0; j < firstDayInMonth; j++) {
                    System.out.print("\t");
                }
            }

            out.print(i + "\t");

            if (curDate.getDayOfWeek().getValue() == 7) {
                out.println();
            }
        }
    }

}
