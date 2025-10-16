import io.CsvReader;
import model.Achievement;
import model.colors.TemplateColors;
import service.CardGenerator;
import template.SvgTemplate;

import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path csvPath = Paths.get("conquistas.csv");
        Path outputDir = Paths.get("cards");
        try {
            List<Achievement> conquistas = new CsvReader().read(csvPath);

            for (Achievement a : conquistas) {
                TemplateColors colors = new TemplateColors();
                SvgTemplate template = SvgTemplate.fromChoice(colors);
                CardGenerator generator = new CardGenerator(template);
                // Complete-me:
                // Gere um card
                String card = generator.generateCard(a);
                // Salve o card
                generator.saveCard(outputDir, a.getName(), card);
            }
            System.out.println("Cartões gerados em: " + outputDir.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
