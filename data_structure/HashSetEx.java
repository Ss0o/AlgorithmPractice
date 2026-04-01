package data_structure;

import java.util.HashSet;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        /*
            HashSet은 중복을 허용하지 않는 자료구조
            add()
            contains()
            remove()
            size()
            isEmpty()
         */
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);               // 중복해서 값을 넣어도 추가되지 않음
        System.out.println(set);   // HashSet은 순서가 보장되지 않음
        System.out.println(set.contains(20));
        System.out.println(set.contains(50));

        set.remove(20);
        System.out.println(set);

        System.out.println(set.size());
        System.out.println(set.isEmpty());

    }
}
