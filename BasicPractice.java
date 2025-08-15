import java.util.Arrays;
import java.util.Scanner;

public class BasicPractice {
  public BasicPractice(){
  }

  public static void main(String[] args){
    //繰り返し処理の練習と計算
    Scanner scanner = new Scanner(System.in);

    double count         = 0;
    double firstNum      = 0;
    double secondNum     = 0;
    int operatorNum      = 0;
    double answer        = 0;

    String mathMessage = "";

    while(count <= 2){ //入力受付
      if(count == 0){
        System.out.println("一つ目の数字をどうぞ");
        firstNum = scanner.nextDouble(); //メッセージの次の行を読み取る
      }else if(count == 1){
        System.out.println("二つ目の数字をどうぞ");
        secondNum = scanner.nextDouble(); //同じ
      }else{
        System.out.println("なんの演算を行いますか。(+=1 -=2 x=3 ÷=4)");
        operatorNum = scanner.nextInt();
        if(operatorNum <= 0 || operatorNum > 4) count--;//指定範囲外の数字が出る場合はやり直す
      }
      count++;
    }

    switch (operatorNum) {
        case 1 -> {
        mathMessage = "加算";
        answer = firstNum + secondNum;
        }
      case 2 -> {
        mathMessage = "減算";
        answer = firstNum - secondNum;
      }
      case 3 -> {
        mathMessage = "乗算";
        answer = firstNum * secondNum;
      }
      case 4 -> {
        if(secondNum == 0){
          System.out.println("ゼロ除算のため実行停止します");
          scanner.close();
          return;
        }
        mathMessage = "除算";
        answer = firstNum / secondNum;
      }
      default ->{
        System.out.println("何らかの抜け穴があるため終了します。");
        scanner.close();
        return;
      }
    }



    System.out.println(mathMessage + "の結果答えは　" + answer + "　です");

    scanner.close();

    //System.out.println(" " + firstNum + secondNum + operatorNum);//変数内容確認用の暫定コード

  }
}
