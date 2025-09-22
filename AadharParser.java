import java.io.ByteArrayInputStream;
import java.io.File;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class AadharParser {
    
    public static void main(String[] args) throws Exception {
        
        // Image Scanner Integration

        // Converting .png .jpeg .jpg into a Buffered Image
        File aadharFile = new File("Add Your Image Here");
        BufferedImage bufferedImage = ImageIO.read(aadharFile);

        LuminanceSource src = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(src));

        String xmlText = "";

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            xmlText = result.getText();
        }
        catch(NotFoundException e){
            System.out.println("QR Not Found");
        }

        // Parse XML string using an xml Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xmlText.getBytes("UTF-8")));

        // Get root element
        Element root = doc.getDocumentElement();
        System.out.println(root.getAttribute("uid"));
        System.out.println(root.getAttribute("name"));
        System.out.println(root.getAttribute("yob"));

    }
}
