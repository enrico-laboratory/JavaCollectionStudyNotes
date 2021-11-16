package com.enricoruggieri.javastudies.collections;

import java.util.*;

public class LinkedListAndArrayListStudy {

    public static void testing(){
        // For ArrayList just change LinkedList<>() to ArrayList<>().
        List<Composers> romanSchoolComposers = new LinkedList<>();

        Composers palestrina = new Composers("Giovanni Pierluigi da Palestrina","Palestrina", 1525, 1594);
        Composers animuccia = new Composers("Giovanni Anumuccia","Firenze", 1520, 1571);
        Composers maque = new Composers("Giovanni de Maque","Valenciennes", 1550, 1614);
        Composers allegri = new Composers("Domenico Allegri","Roma", 1585, 1629);
        Composers giovannelli = new Composers("Ruggero Giovannelli","Velletri", 1520, 1625);
        Composers anerio = new Composers("Giovanni Francesco Anerio","Roma", 1569, 1630);

        romanSchoolComposers.add(palestrina);
        romanSchoolComposers.add(animuccia);
        romanSchoolComposers.add(maque);

        System.out.println("+++++ initial linked list ++++");
        printList(romanSchoolComposers);

        ListIterator<Composers> iterator = romanSchoolComposers.listIterator();
        // Iterator does not have hasPrevious(), does not traverse backwards.
        // Iterator does not have add()
        Iterator<Composers> iterator1 = romanSchoolComposers.iterator();

        iterator.next();
        iterator.remove();

        System.out.println("+++++ remove first linked list ++++");
        printList(romanSchoolComposers);

        System.out.println("+++++ add Anerio first linked list ++++");
        iterator.add(anerio);
        printList(romanSchoolComposers);

        System.out.println("+++++ Previous, has previous? has next? nextIndex, previousIndex ++++");
        System.out.println(iterator.previous());
        System.out.println(iterator.hasPrevious());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.nextIndex());
        System.out.println(iterator.previousIndex());

        System.out.println("++++++ Methods ++++++");
        System.out.println("size(): " + romanSchoolComposers.size());
        System.out.println("isEmpty(): " + romanSchoolComposers.isEmpty());
        System.out.println("contains(palestrina): " + romanSchoolComposers.contains(palestrina));
        System.out.println("contains(1571) false: " + romanSchoolComposers.contains(1571));
        System.out.println("hashCode(): " + romanSchoolComposers.hashCode());


        System.out.println("+++++ toString, get 0, set 3, toString ++++");
        System.out.println(romanSchoolComposers);
        // get is inefficient for linked list, has to traverse the entire list,
        // better an array to retrieve element knowing the index
        // STAY AWAY FROM METHODS WHICH USE INDEX WITH LINKEDLISTS.
        System.out.println(romanSchoolComposers.get(0));
        romanSchoolComposers.set(2, anerio);
        System.out.println(romanSchoolComposers);

        System.out.println("++++++ To array ++++++");
        Composers[] romanSchoolComposersArray = new Composers[romanSchoolComposers.size()];
        romanSchoolComposers.toArray(romanSchoolComposersArray);
        for (Composers composer : romanSchoolComposersArray) {
            System.out.println(composer);
        }

    }

    private static void printList(List<Composers> list) {
        for (Composers composer : list) {
            System.out.println(composer);
        }
    }
}
