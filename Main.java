import model.colors.ColorUtil;
import io.CsvReader;
import model.Achievement;
import model.colors.TemplateColors;
import service.CardGenerator;
import template.SvgTemplate;

import java.awt.*;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path csvPath = Paths.get("conquistas.csv");
        Path outputDir = Paths.get("cards");
        String templateChoice = "default";

        try {
            TemplateColors colors = new TemplateColors();
            List<Achievement> conquistas = new CsvReader().read(csvPath);
            SvgTemplate template = SvgTemplate.fromChoice(templateChoice, colors);
            CardGenerator generator = new CardGenerator(template);

            for (Achievement a : conquistas) {
                // Complete-me:
                // Gere um card
                String card = generator.generateCard(a);
                // Salve o card
                generator.saveCard(outputDir, a.getName(), card);
            }
            Color[] c = ColorUtil.generateTriadColor(new Color(255, 0, 0));
            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i]);
            }
            System.out.println("Cartões gerados em: " + outputDir.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
