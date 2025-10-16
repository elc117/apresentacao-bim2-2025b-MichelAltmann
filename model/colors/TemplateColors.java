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
        Color color = ColorUtils.generateRandomColor();
        Color[] colors = ColorUtils.generateTriadColor(ColorUtils.mixColors(color, new Color(200, 200, 200)));
        this.primary = colors[0];
        this.secondary = ColorUtils.getComplementary(colors[0]);
        this.accent1 = colors[1];
        this.accent2 = colors[2];
        this.textTop = ColorUtils.getComplementary(colors[1]);
        this.textBottom = ColorUtils.getComplementary(colors[2]);
    }

    public String getPrimary() {
        return ColorUtils.toHex(primary);
    }

    public String getSecondary() {
        return ColorUtils.toHex(secondary);
    }

    public String getAccent1() {
        return ColorUtils.toHex(accent1);
    }

    public String getAccent2() {
        return ColorUtils.toHex(accent2);
    }

    public String getTextTop() {
        return ColorUtils.toHex(textTop);
    }

    public String getTextBottom() {
        return ColorUtils.toHex(textBottom);
    }
}
