package utils;


import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Метод sort выполняет непосредственно сортировку.
 * Вначале прогоняем коллекцию через парсинг что бы строки вида "14asdas533asdfwe879asdfs" имели вид "14 533 879 asdas asdfwe asdfs".
 * Парсит метод parStr, прогоняя через патерн с регулярным выражением, возвращая после строку.
 * Затем сортируем согласно задданым условиям (вначале идут null, затем пустые строки "", затем уже строки со значениями)
 * Строка сравнивается методом CompareToString, который сравнивает подстроки возвращая значения -3 и 3 если сравниваются цифры.
 * Метод isLong возвращает true если переданная строка является целым числом.
 */

@Log4j
public class Task1Impl implements IStringRowsListSorter {


    @Override
    public List<String> sort(List<String[]> rows, int columnIndex) {
        if (columnIndex > rows.get(0).length) {
            log.info("Колонки с индексом " + columnIndex + " нет.");
            return null;
        }
        List<String> result = new ArrayList<>();
        //Парсим строки коллекции.
       rows.stream()
                .map(strings -> Arrays.stream(strings)
                        .map(s -> {
                            if (s != null & s != "") s = parStr(s);
                            return s;
                        })
                        .toArray(String[]::new))
                .sorted((s1, s2) -> {
                    if ((s1[columnIndex] == null && s2[columnIndex] != null) ||
                            (s1[columnIndex] == "" && s2[columnIndex] != "")) return -1;
                    if (s1[columnIndex] == null && s2[columnIndex] == null) return 0;
                    if ((s1[columnIndex] != null && s2[columnIndex] == null) ||
                            (s1[columnIndex] != "" && s2[columnIndex] == "")) return 1;

                    return CompareToString(s1[columnIndex], s2[columnIndex]);
                })
                .forEach(strings -> {
                    result.add(strings[columnIndex]);
                });


        log.info(String.format("Сортировка по колонке №%s успешна", columnIndex));

        return result;
    }

    /**
     * Метод проверяет является ли строка числом
     *
     * @param s - строка из из метода CompareToString
     * @return - возвращает true если строка является числом
     */
    private boolean isLong(String s) {
        try {
            Long.parseLong(s);
            log.info(String.format("%s является цифрой", s));
            return true;
        } catch (NumberFormatException e) {
            log.info(String.format("%s не является цифрой", s));
            return false;
        }
    }

    /**
     * Метод парсит строку из массива строк коллекции
     *
     * @param sIn - строка из массива строк коллекции rows
     * @return - возвращает результат где вначале идут цифры, затем буквы
     */
    private String parStr(String sIn) {
        String sOut = "";
        Pattern num = Pattern.compile("-?\\d+");
        Pattern str = Pattern.compile("-?[a-zA-Z]+");
        Matcher mNum = num.matcher(sIn);
        Matcher mStr = str.matcher(sIn);
        while (mNum.find()) {
            sOut += mNum.group() + " ";
        }
        while (mStr.find()) {
            sOut += mStr.group() + " ";
        }
        log.info(String.format("строка вида %s расспарилась в %s", sIn, sOut));
        return sOut;
    }

    /**
     * Метод сравнивает строки
     *
     * @param s1 - строка массива коллекции rows
     * @param s2 - строка массива коллекции rows
     * @return - возвращает 1 или -1 в зависимости от того какая строка в числовом значении больше, если вдруг какая
     * либо строка не является числом сравнит обе строки через метод compareTo, в противном случае вернет 0
     */
    private int CompareToString(String s1, String s2) {
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        if (s1Arr.length == s2Arr.length) {
            for (int i = 0; i < s1Arr.length; i++) {
                if (isLong(s1Arr[i]) & isLong(s2Arr[i])) {
                    long i1 = Long.parseLong(s1Arr[i]);
                    long i2 = Long.parseLong(s2Arr[i]);
                    log.info(String.format("сравнение цифр %s и %s", s1Arr[i], s2Arr[i]));
                    if (i1 > i2) return -1;
                    if (i1 < i2) return 1;
                } else {
                    log.info(String.format("некорректные входные параметры %s и %s", s1Arr[i], s2Arr[i]));
                    return s1Arr[i].compareTo(s2Arr[i]);
                }
            }
        }
        log.info(String.format("некорректные входные параметры %s и %s", s1, s2));
        return 0;
    }
}
