import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AadharParser {
    
    public static void main(String[] args) throws Exception {
        
        // Image Scanner Integration

        // Converting .png .jpeg .jpg into a Buffered Image
        File aadharFile = new File("aadharSample.jpeg");
        BufferedImage bufferedImage = ImageIO.read(aadharFile);

        LuminanceSource src = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(src));

        String xmlText = "";

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            xmlText = result.getText();
        }
        catch(NotFoundException e){
            System.out.println("QR NAHI MILA");
        }

        // Parse XML string using an xml Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xmlText.getBytes("UTF-8")));

        // Get root element
        Element root = doc.getDocumentElement();
        System.out.println(root.getAttribute("uid"));
        System.out.println(root.getAttribute("name"));
        System.out.println(xmlText);
    }
}

/* Data to fetch 
 uid="436108442955" 
 name="Parth Shashikant Salunke" 
 gender="M" 
 yob="2008" 
 gname="Shraddha Shashikant Salunke" 
 co="S/O: Shashikant Salunke" 
 house="406/B Vaishnav Sadan" 
 street="S.B Pawar Marg" 
 loc="Currey Road" 
 vtc="Delisle Road" 
 po="Delisle Road" 
 dist="Mumbai" 
 subdist="Mumbai" 
 state="Maharashtra" pc="400013" 
 dob="23/02/2008"
 */