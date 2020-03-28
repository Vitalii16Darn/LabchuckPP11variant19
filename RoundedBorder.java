import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {//клас для заокруглення кутів деяких елементів
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        //return new Insets(this.radius, this.radius, this.radius, this.radius);
        return new Insets(1,10,1,10);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
