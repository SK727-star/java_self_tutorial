import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ShuttingYardPractice {
  public static void main(String[] args){
    Scanner inScanner = new Scanner(System.in);
    Pattern p = Pattern.compile("\\d+|[+\\-*/()]|[a-zA-Z]+");
    List<String> spitFormulaList = new ArrayList<String>();
    String formula = "";

    System.out.println("式を受け付けます。");
    formula = inScanner.nextLine();
    if ( "a".equals(formula) ) formula = "(33+2d1)/wwe23-2*34"; //めんどくさがり用
    Matcher matcherFormula = p.matcher(formula);

    // spitFormulaList.addAll(Arrays.asList(formula.split("(?<=[+\\-*/])|(?=[+\\-*/])|(?<=[A-z]+)|(?=[A-z])+")));
    // System.out.println(spitFormulaList);
    while ( matcherFormula.find() ) {
      spitFormulaList.add(matcherFormula.group());
    }
    System.out.println(spitFormulaList);
    inScanner.close();
  }
}

// import java.util.*;
// import java.util.regex.Pattern;
//
// public class ShuttingYardPractice {
//   public static void main(String[] args) {
//     var str = "携帯は0123-99-0000です。自宅は000-123-4567やで。";
//     var ptn = Pattern.compile("(\\d{2,4})-(\\d{2,4})-(\\d{4})");
//     var match = ptn.matcher(str);
//     while (match.find()) {
//       System.out.println("開始位置：" + match.start());
//       System.out.println("終了位置：" + match.end());
//       System.out.println("マッチング文字列：" + match.group());
//       System.out.println("市外局番：" + match.group(1));
//       System.out.println("市内局番：" + match.group(2));
//       System.out.println("加入者番号：" + match.group(3));
//       System.out.println("-----");
//     }
//   }
// }
