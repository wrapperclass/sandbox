package com.nelson.flyingsaucer;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FirstDoc {

    public static void main(String[] args) throws IOException, DocumentException {

        File inputFile = File.createTempFile("firstdoc", "xhtml");
        String outputFile = "firstdoc.pdf";
        String url = inputFile.getAbsolutePath();
        OutputStream os = new FileOutputStream(outputFile);

        // Create variables to give us the same data as on server.
        String contextPath = "TCI/";

        // Create our regular expression and the text to replace it with.
        String regex = "(?i)(\\b(?:src|href)\\s*=\\s*['\"])" + contextPath + "/";
        String replace = "$1file:///" + url.replaceAll("\\\\", "\\\\\\\\");

        // Read the Html text from the file.
        String text = IOUtils.read(inputFile, "UTF-8");

        // Find current text with regular expression and replace it with our
        // text.
        text = text.replaceAll(regex, replace);

        // Replace the text in the file.
        IOUtils.write(inputFile, "UTF-8", text);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);

        os.close();
    }
}
