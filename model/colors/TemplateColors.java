package model.colors;

import java.awt.*;

public class TemplateColors {
    private final Color primary;
    private final Color secondary;
    private final Color accent1;

    private final Color accent2;
    private final Color textTop;
    private final Color textBottom;

    public TemplateColors() {
        Color color = ColorUtil.generateRandomColor();
        Color[] colors = ColorUtil.generateTriadColor(ColorUtil.mixColors(color, new Color(200, 200, 200)));
        this.primary = colors[0];
        this.secondary = ColorUtil.getComplementary(colors[0]);
        this.accent1 = colors[1];
        this.accent2 = colors[2];
        this.textTop = ColorUtil.getComplementary(colors[1]);
        this.textBottom = ColorUtil.getComplementary(colors[2]);
    }

    public String getPrimary() {
        return ColorUtil.toHex(primary);
    }

    public String getSecondary() {
        return ColorUtil.toHex(secondary);
    }

    public String getAccent1() {
        return ColorUtil.toHex(accent1);
    }

    public String getAccent2() {
        return ColorUtil.toHex(accent2);
    }

    public String getTextTop() {
        return ColorUtil.toHex(textTop);
    }

    public String getTextBottom() {
        return ColorUtil.toHex(textBottom);
    }
}
