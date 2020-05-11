import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class XmlParser {
    public static void main(String[] args){
        String xmlString =
                "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:wd=\"urn:com.workday/bsvc\" xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "   <env:Header>\n" +
                "      <wsa:Action>urn:com.workday/bsvc:NotificationPort:Receive_NotificationInput</wsa:Action>\n" +
                "      <wsa:MessageID>uuid:d52ce484792901aebe5bfc2edc034802</wsa:MessageID>\n" +
                "      <wsa:To>https://gateway-qa.phenompro.com/v2.0/jobs/notify/6809aea5-ce9b-453e-af42-a4632d2a2847</wsa:To>\n" +
                "      <wsa:From>\n" +
                "         <wsa:Address>http://balance.svc.impl.wd2.wd:19110/ccx/ExternalSystemNotificationService</wsa:Address>\n" +
                "      </wsa:From>\n" +
                "      <wd:Integration_Correlation_ID>d52ce484792901aebe5bfc2edc034802</wd:Integration_Correlation_ID>\n" +
                "      <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" env:mustUnderstand=\"1\">\n" +
                "         <wsse:UsernameToken>\n" +
                "            <wsse:Username>wdtest</wsse:Username>\n" +
                "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">wdtest</wsse:Password>\n" +
                "         </wsse:UsernameToken>\n" +
                "      </wsse:Security>\n" +
                "   </env:Header>\n" +
                "   <env:Body>\n" +
                "      <wd:Notification_Data wd:version=\"v33.0\">\n" +
                "         <wd:Event_Data>\n" +
                "            <wd:Event_Reference wd:Descriptor=\"Job Requisition Change: R-00508 Manager, Collections\">\n" +
                "               <wd:ID wd:type=\"WID\">d52ce4847929010e0e296925dc032602</wd:ID>\n" +
                "            </wd:Event_Reference>\n" +
                "            <wd:Event_Name>Edit Job Requisition Event</wd:Event_Name>\n" +
                "            <wd:Notification_Trigger>Completed</wd:Notification_Trigger>\n" +
                "            <wd:Event_Completion_Date>2019-09-05T11:10:27.835-07:00</wd:Event_Completion_Date>\n" +
                "            <wd:Event_Effective_Date>2019-09-04-07:00</wd:Event_Effective_Date>\n" +
                "            <wd:Tenant_Name>phenompeople_dpt2</wd:Tenant_Name>\n" +
                "            <wd:System_ID>testjobupdates</wd:System_ID>\n" +
                "            <wd:Transaction_Target_Reference wd:Descriptor=\"Manager, Collections (Unfilled)\">\n" +
                "               <wd:ID wd:type=\"WID\">efd607447b580124ec77b97680037c1c</wd:ID>\n" +
                "               <wd:ID wd:type=\"Position_ID\">P-00747</wd:ID>\n" +
                "            </wd:Transaction_Target_Reference>\n" +
                "            <wd:Transaction_Target_Reference wd:Descriptor=\"Accounting Operations\">\n" +
                "               <wd:ID wd:type=\"WID\">e7dcf5926bdc40d6b6877f41f4c15387</wd:ID>\n" +
                "               <wd:ID wd:type=\"Organization_Reference_ID\">Accounting_Operations_supervisory</wd:ID>\n" +
                "            </wd:Transaction_Target_Reference>\n" +
                "            <wd:Transaction_Target_Reference wd:Descriptor=\"R-00508 Manager, Collections (Open)\">\n" +
                "               <wd:ID wd:type=\"WID\">efd607447b58016afda4b87680037a1c</wd:ID>\n" +
                "               <wd:ID wd:type=\"Job_Requisition_ID\">R-00508</wd:ID>\n" +
                "            </wd:Transaction_Target_Reference>\n" +
                "         </wd:Event_Data>\n" +
                "      </wd:Notification_Data>\n" +
                "   </env:Body>\n" +
                "</env:Envelope>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {


        }
        Document doc = null;
        try {
            doc = builder.parse(xmlString);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        XPathExpression expr = null;
        try {
            expr = xpath.compile("//*[@wd:type='Job_Requisition_ID']");
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        Object result = null;
        try {
            result = expr.evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }



    }
}
