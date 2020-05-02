import utils.Task1Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Тестировал простой коллекцией которую захардкодил.
 */

public class Main {
    public static void main(String[] args) throws SQLException {
        Task1Impl task1 = new Task1Impl();
        List<String[]> inputData = new ArrayList<>();
        int nTable = 3;
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



        System.out.println("До---------------------------------------------------------");
        outDisp(inputData, nTable);
        System.out.println("После-------------------------------------------------------");
        task1.sort(inputData, nTable).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
    }


    static void outDisp(List<String[]> list, int num) {
        if (num > list.get(0).length) return;
        for (String[] arrStr : list) {
            System.out.println(arrStr[num]);
        }
    }
}
