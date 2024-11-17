package pl.edu.pjwstk;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
        File file = new File("file.pdf");
        FileUtils.copyURLToFile(url, file);
        PDDocument document = Loader.loadPDF(file);
        url = new URL("https://www.thealexandriazoo.com/images/animals/Capybara02.jpg");
        PDPage page = document.getPage(0);
        File image = new File("img.jpg");
        FileUtils.copyURLToFile(url, image);
        PDImageXObject imageXObject = PDImageXObject.createFromFileByContent(image, document);
        PDPageContentStream stream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
        stream.drawImage(imageXObject, 12, 30, 200, 400);
        stream.close();
        document.save("file1.pdf");
    }
}