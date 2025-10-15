package model.colors;

import java.awt.*;
import java.util.Random;

public class ColorUtil {
    public static Color generateRandomColor() {
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        return new Color(r, g, b);
    }

    public static Color mixColors(Color color1, Color color2) {
        int r,g,b;
        if (color2 != null) {
            r = (color1.getRed() + color2.getRed()) / 2;
            g = (color1.getGreen() + color2.getGreen()) / 2;
            b = (color1.getBlue() + color2.getBlue()) / 2;
            return new Color(r, g, b);
        } else {
            return color1;
        }

    }

    public static Color[] generateTriadColor(Color c) {
        float[] hsbColor = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
        float hue = hsbColor[0];
        float saturation = hsbColor[1];
        float brightness = hsbColor[2];

        float p, s, t;
        p = hue;
        s = (hue + 1f/3f) % 1f;
        t = (hue + 2f/3f) % 1f;

        int primary = Color.HSBtoRGB(p, saturation, brightness);
        int secondary = Color.HSBtoRGB(s, saturation, brightness);
        int tertiary = Color.HSBtoRGB(t, saturation, brightness);


        return new Color[]{new Color(primary), new Color(secondary), new Color(tertiary), Color.BLACK};
    }

    public static String toHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

}
