import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ShuttingYardPractice {
  public static void main(String[] args){
    Scanner inScanner = new Scanner(System.in);
    List<String> spitFormulaList = new ArrayList<String>();
    String formula = "";

    System.out.println("式を受け付けます。");
    formula = inScanner.nextLine();

    spitFormulaList.addAll(Arrays.asList(formula.split("(?<=[+\\-*/])|(?=[+\\-*/])|(?<=[A-z]+)|(?=[A-z])+")));
    System.out.println(spitFormulaList);

    inScanner.close();
  }
}
