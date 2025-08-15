import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FrameTutorial {

    public static void main(String[] args) {
        // 1) GUIはEDTで安全に起動
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aspect-Fit Photo Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationByPlatform(true);

            // 2) 画像を読み込む（ここでは同じフォルダの 画像を想定）
            BufferedImage img;
            try {
                String path = (args.length > 0) ? args[0] : "GUA.jpg";
                img = ImageIO.read(new File(path));
            } catch (IOException e) {
                // 画像が読めなかったらメッセージだけ出す
                frame.setContentPane(new JLabel("画像が読み込めませんでした。用意してください。",
                        SwingConstants.CENTER));
                frame.setVisible(true);
                System.out.println("error: " + e.getMessage());
                return;
            }

            // 3) カスタム描画パネルに画像を渡して表示
            frame.setContentPane(new ImagePanel(img));
            frame.setVisible(true);
        });
    }

    /** 画像をアスペクト比を保ってパネル全体に「フィット」させて描画するパネル */
    static class ImagePanel extends JPanel {
        private final BufferedImage image;

        ImagePanel(BufferedImage image) {
            this.image = image;
            setBackground(Color.BLACK); // 余白が分かりやすいように
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image == null) return;

            int panelW = getWidth();
            int panelH = getHeight();
            int imgW   = image.getWidth();
            int imgH   = image.getHeight();

            // 4) パネルと画像のアスペクト比を比較して「フィット」する幅・高さを決定
            double panelRatio = (double) panelW / panelH;
            double imgRatio   = (double) imgW   / imgH;

            int drawW, drawH;
            if (panelRatio > imgRatio) {       // パネルの方が横に広い → 高さを基準に合わせる
                drawH = panelH;
                drawW = (int) Math.round(drawH * imgRatio);
            } else {                            // パネルの方が縦に長い/同じ → 幅を基準に合わせる
                drawW = panelW;
                drawH = (int) Math.round(drawW / imgRatio);
            }

            // 5) 余白分だけ中央寄せ（黒帯が左右/上下に出る）
            int x = (panelW - drawW) / 2;
            int y = (panelH - drawH) / 2;

            // 6) 品質を上げる描画ヒントを設定して拡大/縮小描画
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                                RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

            g2.drawImage(image, x, y, drawW, drawH, null);
            g2.dispose();
        }
    }
}
