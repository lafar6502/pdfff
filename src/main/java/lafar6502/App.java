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


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        if (args.length == 0) {
            String[] usages = {
                "USAGE",
                "extractform -input [input pdf file] -output [out file]",
                "fillform -input [input pdf file] -formfile [input form file]"
            };
            for (int i=0; i<usages.length; i++) {
                System.out.println(usages[i]);
            }
            return;
        }
        String cmd = args[0];
        switch(cmd) {
            case "extractform":
            break;
            case "fillform":
            break;
            default:
                throw new Exception("Invalid command: " + cmd);
        }
    }
    
    
}
