package com.mlesikov.pdfer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class App {
  public static void main(String[] args) throws DocumentException, IOException {
    // step 1
    Document document = new Document(PageSize.A4);

    // step 2
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf1.pdf"));
    // step 3
    document.open();

//    String html = "<html><body> This is my Project </body></html>";
//
//    // step 4
//    XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//            new ByteArrayInputStream(html.getBytes("UTF-8")));

    XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
       fontImp.register("fonts/TimesNewRoman.ttf");
       fontImp.register("fonts/FreeSans.ttf");
//       fontImp.register("fonts/arial.ttf");
//       fontImp.register("fonts/arial-unicode-ms.TTF");

       fontImp.register("fonts/Arimo-Bold.ttf");
       fontImp.register("fonts/Arimo-Italic.ttf");
       fontImp.register("fonts/Arimo-Regular.ttf");
       fontImp.register("fonts/ARIALUNI.TTF");
       FontFactory.setFontImp(fontImp);


//    XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("index.html"), Charset.forName("UTF-8"), fontImp);

    //step 5
//    document.close();


//
    CssAppliers cssAppliers = new CssAppliersImpl(fontImp);
            HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
            htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

            // Pipelines
            PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
            HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
            CssResolverPipeline css = new CssResolverPipeline(new StyleAttrCSSResolver(), html);

            // XML Worker
            XMLWorker worker = new XMLWorker(css, true);
            XMLParser p = new XMLParser(worker);

             p.parse(new FileInputStream("index.html"));
            // step 5
            document.close();

    System.out.println("PDF Created!");
  }
}
