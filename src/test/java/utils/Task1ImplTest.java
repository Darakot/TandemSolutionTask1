package utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Тесты на сортировку столбцов 1,2,3 и на сортировку несуществующего столбца
 */
public class Task1ImplTest {
    List<String> results = new ArrayList<>();
    List<String[]> inputData = new ArrayList<>();


    @Before
    public void createList() {
        inputData.add(new String[]{
                null,
                "14asdas533asdfwe879asdfs",
                "789klmnc567fgdh587xbc",
                "784dghf123dfgfdjg55dfjfn"});
        inputData.add(new String[]{
                "",
                null,
                "789dfghdfgh1516tertyrte156adfasasdf",
                "3466dfghjgdh3246qwrtqwuy767zxcvvcb"});
        inputData.add(new String[]{
                "917lhjdm9689tyidimg1005uyusjtn",
                "",
                null,
                "888gg924jhggg4447hhgban"});
        inputData.add(new String[]{"889asdfer766fiaf5564yuurth",
                "993khdhhh8876kgvnvka1432nvnsdhn",
                "",
                null});
        inputData.add(new String[]{
                null,
                null,
                "12fghgfd159kjg122uyy",
                "66aaqq677erdf88bbba"});
        inputData.add(new String[]{
                "zzpo8846bsdsss42kqu514",
                "oasda1512kkhcc5121mmnmncv8615",
                null,
                null});


    }

    @Test
    public void sortByСolumn1() {
        results.add("");
        results.add(null);
        results.add(null);
        results.add("1512 5121 8615 oasda kkhcc mmnmncv ");
        results.add("993 8876 1432 khdhhh kgvnvka nvnsdhn ");
        results.add("14 533 879 asdas asdfwe asdfs ");
        Task1Impl task1 = new Task1Impl();


        Assert.assertEquals(task1.sort(inputData, 1), results);
    }

    @Test
    public void sortByСolumn2() {
        results.add("");
        results.add(null);
        results.add(null);
        results.add("789 1516 156 dfghdfgh tertyrte adfasasdf ");
        results.add("789 567 587 klmnc fgdh xbc ");
        results.add("12 159 122 fghgfd kjg uyy ");
        Task1Impl task1 = new Task1Impl();


        Assert.assertEquals(task1.sort(inputData, 2), results);
    }

    @Test
    public void sortByСolumn3() {
        results.add(null);
        results.add(null);
        results.add("3466 3246 767 dfghjgdh qwrtqwuy zxcvvcb ");
        results.add("888 924 4447 gg jhggg hhgban ");
        results.add("784 123 55 dghf dfgfdjg dfjfn ");
        results.add("66 677 88 aaqq erdf bbba ");
        Task1Impl task1 = new Task1Impl();


        Assert.assertEquals(task1.sort(inputData, 3), results);
    }

    @Test
    public void sortByNonColumn() {
        Task1Impl task1 = new Task1Impl();
        Assert.assertNull(task1.sort(inputData, 10));
    }
}
