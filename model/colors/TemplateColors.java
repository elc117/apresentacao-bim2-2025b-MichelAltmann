package model.colors;

import java.awt.*;

public class TemplateColors {
    private final Color primary;
    private final Color secondary;
    private final Color tertiary;

    private final Color accent;

    public TemplateColors() {
        Color color = ColorUtil.generateRandomColor();
        Color[] colors = ColorUtil.generateTriadColor(ColorUtil.mixColors(color, new Color(255,255,255)));
        this.primary = colors[0];
        this.secondary = colors[1];
        this.tertiary = colors[2];
        this.accent = colors[3];
    }

    public String getPrimary() {
        return ColorUtil.toHex(primary);
    }

    public String getSecondary() {
        return ColorUtil.toHex(secondary);
    }

    public String getTertiary() {
        return ColorUtil.toHex(tertiary);
    }

    public String getAccent() {
        return ColorUtil.toHex(accent);
    }

}
