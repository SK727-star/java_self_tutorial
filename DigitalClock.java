import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private JLabel clockLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        // 時刻の書式指定
        timeFormat = new SimpleDateFormat("HH:mm:ss");

        // ラベル設定
        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Monospaced", Font.BOLD, 60));
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // ウィンドウ設定
        this.setTitle("デジタル時計");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(clockLabel);
        this.setVisible(true);

        // タイマーで1秒ごとに更新
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock(); // 起動直後に1回表示更新
    }

    private void updateClock() {
        Date now = new Date();
        clockLabel.setText(timeFormat.format(now));
    }

    public static void main(String[] args) {
        // GUIはEDTで起動
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}
