import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameTutorial extends JFrame {
  private JLabel testText;

  public FrameTutorial() {
    testText = new JLabel(new ImageIcon("GURA.jpg"));
    testText.setFont(new Font("SansSerif", Font.PLAIN, 100));
    testText.setHorizontalAlignment(SwingConstants.CENTER);

    this.add(testText);
    this.setSize(1000, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }



  public static void main(String[] args){
    //EDT
    SwingUtilities.invokeLater(FrameTutorial::new);
  }
}
