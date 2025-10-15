package template;

import model.colors.TemplateColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class SvgTemplate {

    private final TemplateColors colors;
    private final String svgRef;

    public SvgTemplate(TemplateColors colors, String svgRef) {
        this.colors = colors;
        this.svgRef = svgRef;
    }

    public static String randomIcon(){
        String[] icons = {
                "award.svg",
                "circle-star.svg",
                "gem.svg",
                "medal.svg",
                "square-star.svg",
                "star.svg",
                "trophy.svg",
                "trophy-hero.svg}"
        };
        Random rand = new Random();
        return icons[rand.nextInt(icons.length-1)];
    }

    public static SvgTemplate fromChoice(String choice, TemplateColors colors) {
        return switch (choice) {
            case "azul" -> new SvgTemplate(colors, "assets/"+randomIcon());
            default -> new SvgTemplate(colors, "assets/"+randomIcon());
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
        double x = 350;
        double y = 534;
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
                      .title { font: 800 96px system-ui, sans-serif; fill: %s; }
                      .name  { font: 800 56px system-ui, sans-serif; fill: %s; }
                      .desc  { font: 600 44px system-ui, sans-serif; fill: %s; }
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
                """, colors.getAccent1(), colors.getAccent2(), colors.getPrimary(), colors.getSecondary(), colors.getTextTop(), colors.getTextBottom(), colors.getTextBottom(), title1, title2, x, y, scale, iconContent, name, reason);
    }
}
