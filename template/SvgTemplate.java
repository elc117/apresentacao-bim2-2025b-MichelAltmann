package template;

import model.colors.TemplateColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SvgTemplate {

    private final TemplateColors colors;
    private final String svgRef;

    public SvgTemplate(TemplateColors colors, String svgRef) {
        this.colors = colors;
        this.svgRef = svgRef;
    }

    public static SvgTemplate fromChoice(String choice, TemplateColors colors) {
        return switch (choice) {
            case "azul" -> new SvgTemplate(colors, "assets/circle-star.svg");
            default -> new SvgTemplate(colors, "assets/gem.svg");
        };
    }

    public String render(String title1, String title2, String name, String reason) {
        String iconContent = "";
        try {
            iconContent = Files.readString(Paths.get(svgRef));
        } catch (IOException e) {
            iconContent = "<!-- could not load icon -->";
        }
        double scale = 16.0;
        double x = 348;
        double y = 540;
        return String.format("""
                <svg xmlns='http://www.w3.org/2000/svg' width='1080' height='1350' viewBox='0 0 1080 1350'>
                  <defs>
                    <linearGradient id='bg' x1='0' y1='0' x2='0' y2='1'>
                      <stop offset='0%%' stop-color='%s'/>
                      <stop offset='100%%' stop-color='%s'/>
                    </linearGradient>
                    <linearGradient id='accent' x1='0' y1='0' x2='1' y2='1'>
                      <stop offset='0%%' stop-color='%s'/>
                      <stop offset='100%%' stop-color='%s'/>
                    </linearGradient>
                    <style>
                      .title { font: 800 96px system-ui, sans-serif; fill: #F8FAFC; }
                      .name  { font: 800 56px system-ui, sans-serif; fill: #F8FAFC; }
                      .desc  { font: 600 44px system-ui, sans-serif; fill: #CBD5E1; }
                    </style>
                  </defs>
                
                  <rect width='1080' height='1350' fill='url(#bg)'/>
                  <text class='title' x='540' y='260' text-anchor='middle'>%s</text>
                  <text class='title' x='540' y='360' text-anchor='middle'>%s</text>
                  <circle cx='540' cy='720' r='280' fill='url(#accent)'/>
                  <g transform='translate(%f,%f) scale(%f)'>
                    %s
                  </g>
                  <text class='name' x='540' y='1100' text-anchor='middle'>%s</text>
                  <text class='desc' x='540' y='1170' text-anchor='middle'>%s</text>
                </svg>
                """, colors.getPrimary(), colors.getSecondary(), colors.getTertiary(), colors.getAccent(), title1, title2, x, y, scale, iconContent, name, reason);
    }
}
