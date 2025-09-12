sowhatwergonnadoisthat
first of all,we create a java file
then make a string  
in tht string add the text you get after QR 
(You will get the information in a xml format)
use xml parser to parse it 
Once you get the data
Print It in a structured manner
NOW WE WILL DO THE QR SCANNING PART
create a file object of the image (for example File file = new File())
Then convert it into Buffered Image
Then convert it into LUMINANCESOURCEBUFFEREDIMAGE
then create a bitmap object and give that source to it
Baadme Result create karo (Result result = new MultiFormatReader().decode(bitmap);)
then print the output i.e. result.getText();
HOGYAA