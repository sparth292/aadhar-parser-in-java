import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AadharParser {
    
    public static void main(String[] args) throws Exception {
        
        // Image Scanner Integration


        String xmlText = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <printletterbarcodedata uid=\"436108442955\" name=\"parth shashikant salunke\" gender=\"m\" yob=\"2008\" gname=\"shraddha shashikant salunke\" co=\"s/o: shashikant salunke\" house=\"406/b vaishnav sadan\" street=\"s.b pawar marg\" loc=\"currey road\" vtc=\"delisle road\" po=\"delisle road\" dist=\"mumbai\" subdist=\"mumbai\" state=\"maharashtra\" pc=\"400013\" dob=\"23/02/2008\"/>";

        // Parse XML string using an xml Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xmlText.getBytes("UTF-8")));

        // Get root element
        Element root = doc.getDocumentElement();
        

    }
}
