package Collection.Cursors;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


/**
 * Наследуется от Iterator
 * <p>
 * В отличие от Iterator может идти не только вперёд, но ещё и назад
 * @see Collection.Cursors.Iterator_Class
 */
public class ListIterator_Class {
    public static void main(String[] args) {
        String s = "madam";
        List<Character> list = new LinkedList<>();
        for(char ch: s.toCharArray()){
            list.add(ch);
        }

        ListIterator<Character> liter = list.listIterator();
        ListIterator<Character> liter_revers = list.listIterator(list.size());

        boolean isPalindrome = true;

        while (liter.hasNext() && liter_revers.hasPrevious()){
            if (liter.next() != liter_revers.previous()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);


    }

}
