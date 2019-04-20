package chapter9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 查找回文串
 */
public class FindPalindrome {

    private Deque<Character> ds;

    FindPalindrome(String str) {
        ds = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            ds.add(str.charAt(i));
        }
    }

    public boolean check() {
        boolean flag = true;

        while(ds.size() > 1) {
            if (ds.pollFirst() != ds.pollLast()) {
                flag = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        String[] words = {"RADAR", "WARTER START", "MILK KLIM", "RESERVERED", "IWI"};
        for (String s: words) {
            FindPalindrome fp = new FindPalindrome(s);
            if (fp.check()) {
                System.out.println(s);
            }
        }
    }

}
