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
    private static String inputFile;
    private static String outputFile;
    private static String xmlFile;
    
    private static void processCmdline(String[] args) throws Exception {
        for(int i=1; i<args.length; i+= 2) {
            switch(args[i]) {
                case "-input":
                    inputFile = args[i+1];
                    break;
                case "-output":
                    outputFile = args[i+1];
                    break;
                case "-xmlfile":
                    xmlFile = args[i+1];
                    break;
                default:
                    throw new Exception("Unknown switch: " + args[i]);
            }
        }
    }
    
    public static void main( String[] args ) throws Exception
    {
        if (args.length == 0) {
            String[] usages = {
                "USAGE",
                "extractform -input [input pdf file] -output [out file]",
                "fillform -input [input pdf file] -xmlfile [input form data file] -output [output file]"
            };
            for (int i=0; i<usages.length; i++) {
                System.out.println(usages[i]);
            }
            return;
        }
        String cmd = args[0];
        processCmdline(args);
        switch(cmd) {
            case "extractform":
                if (inputFile == null) throw new Exception("Missing -input");
                if (outputFile == null) throw new Exception("Missing -output");
                extractFormData(inputFile, outputFile);
            break;
            case "fillform":
                if (inputFile == null) throw new Exception("Missing -input option");
                if (xmlFile == null) throw new Exception("Missing -xmlfile option");
                if (outputFile == null) throw new Exception("Missing -output option");
                updateFormData(inputFile, xmlFile, outputFile);
            break;
            default:
                throw new Exception("Invalid command: " + cmd);
        }
    }
    
    private static void extractFormData(String inputFile, String outputFile) throws Exception {
        ReadXFA xf = new ReadXFA();
        xf.readXml(inputFile, outputFile);
    }
    
    private static void updateFormData(String inf, String xmlf, String outF) throws Exception {
        FillXFA2 xf = new FillXFA2();
        xf.manipulatePdf(inf, xmlf, outF);
    }
    
}
