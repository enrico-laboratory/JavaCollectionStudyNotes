import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorStudy {

    public static void testing() {
        Collection<Composers> romanSchoolComposers = new ArrayList<>();

        Composers palestrina = new Composers("Giovanni Pierluigi da Palestrina",
                "Palestrina", 1525, 1594);
        romanSchoolComposers.add(palestrina);
        romanSchoolComposers.add(new Composers("Giovanni Anumuccia",
                "Firenze", 1520, 1571));
        romanSchoolComposers.add(new Composers("Domenico Allegri",
                "Roma", 1585, 1629));
        romanSchoolComposers.add(new Composers("Giovanni de Maque",
                "Valenciennes", 1550, 1614));
        romanSchoolComposers.add(new Composers("Ruggero Giovannelli",
                "Velletri", 1520, 1625));
        romanSchoolComposers.add(new Composers("Giovanni Francesco Anerio",
                "Roma", 1569, 1630));
        System.out.println(romanSchoolComposers.add(palestrina));

        System.out.println("++++++ Iterator ++++++");

        Iterator<Composers> iterator = romanSchoolComposers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("++++++ Iterator (for-each) ++++++");

        for (Composers composer : romanSchoolComposers) {
            System.out.println(composer);
        }
    }
}
