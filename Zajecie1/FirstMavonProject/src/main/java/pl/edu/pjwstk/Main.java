package pl.edu.pjwstk;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage[] pages = new PDPage[10];
        for (int i = 0; i < 10; i++) {
            pages[i] = new PDPage();
        }
        PDPageContentStream stream = new PDPageContentStream(document, pages[0]);
        stream.beginText();
        stream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 14);
        String text = "Hello World";
        stream.newLineAtOffset(25, 500);
        stream.showText(text);
        stream.endText();
        stream.close();

        PDPageContentStream stream2 = new PDPageContentStream(document, pages[9]);
        stream2.beginText();
        stream2.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 14);
        text = "Goodbye World!";
        stream2.newLineAtOffset(25, 500);
        stream2.showText(text);
        stream2.endText();
        stream2.close();

        for (int i = 0; i < 10; i++) {
            document.addPage(pages[i]);
        }
        document.save("document.pdf");
    }
}