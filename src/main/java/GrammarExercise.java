import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String[] firstWord = firstWordList.split(",");
        String[] secondWord = secondWordList.split(",");
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*\\W+.*");
        Matcher matcher;

        for (int i = 0; i < firstWord.length; i++) {
            matcher = pattern.matcher(firstWord[i]);
            if (firstWord[i].equals("") || matcher.find()) {

                throw new RuntimeException("input not valid");
            }
            firstList.add(firstWord[i].toUpperCase());
        }
        for (int i = 0; i < secondWord.length; i++) {
            matcher = pattern.matcher(secondWord[i]);
            if (secondWord[i].equals("") || matcher.find()) {

                throw new RuntimeException("input not valid");
            }
            secondList.add(secondWord[i].toUpperCase());
        }
        for (int i = 0; i < firstList.size(); i++)
            for (int m = 0; m < secondList.size(); m++) {
                if (firstList.get(i).equals(secondList.get(m))) {
                    String str = firstList.get(i).replace("", " ").trim();
                    result.add(str);
                }
            }
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
    }
}
