public class AadharParser {
    public static void main(String[] args) {
     
        String xmlText = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <printletterbarcodedata uid=\"436108442955\" name=\"parth shashikant salunke\" gender=\"m\" yob=\"2008\" gname=\"shraddha shashikant salunke\" co=\"s/o: shashikant salunke\" house=\"406/b vaishnav sadan\" street=\"s.b pawar marg\" loc=\"currey road\" vtc=\"delisle road\" po=\"delisle road\" dist=\"mumbai\" subdist=\"mumbai\" state=\"maharashtra\" pc=\"400013\" dob=\"23/02/2008\"/>";
        // we will minus or start with 67
        for (int i = 63 ; i < (xmlText.length() - 2) ; i++){
        System.out.print(xmlText.charAt(i));
        }

        // for (int i = 63 ; i< )
    }
    


}


/*
 Example Info 
 uid=\"436108442955\" 
 name=\"parth shashikant salunke\" 
 gender=\"m\" 
 yob=\"2008\" 
 gname=\"shraddha shashikant salunke\" 
 co=\"s/o: shashikant salunke\" 
 house=\"406/b vaishnav sadan\" 
 street=\"s.b pawar marg\" 
 loc=\"currey road\" 
 vtc=\"delisle road\" 
 po=\"delisle road\" 
 dist=\"mumbai\" 
 subdist=\"mumbai\" 
 state=\"maharashtra\" 
 pc=\"400013\" 
 dob=\"23/02/2008\"
 */
