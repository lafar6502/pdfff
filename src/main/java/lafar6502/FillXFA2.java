package lafar6502;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.XfaForm;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FillXFA2 {
 
    public static final String SRC = "resources/pdfs/xfa_form_poland.pdf";
    public static final String XML = "resources/xml/xfa_form_poland.xml";
    public static final String DEST = "results/xfa/xfa_form_poland_filled.pdf";
 
    public static void zz_main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new FillXFA2().manipulatePdf(SRC, XML, DEST);
    }
 
    public void manipulatePdf(String src, String xmlFile, String dest)
        throws IOException, DocumentException {
        PdfReader.unethicalreading = true;
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader,
                new FileOutputStream(dest));
        AcroFields form = stamper.getAcroFields();
        XfaForm xfa = form.getXfa();
        xfa.fillXfaForm(new FileInputStream(xmlFile));
        stamper.close();
        reader.close();
    }
}