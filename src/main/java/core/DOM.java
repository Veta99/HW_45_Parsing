package core;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM 
{
    public static void main( String[] args ) throws ParserConfigurationException, Exception {
    String xml = "http://learn2test.net/sdc.xml";
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(xml);
    doc.getDocumentElement().normalize();
    NodeList nl = doc.getElementsByTagName("kadu-response");
       for (int i=0; i<nl.getLength(); i++) {
    	Node n = nl.item(i); 
    if (n.getNodeType() == Node.ELEMENT_NODE){   
    	Element e = (Element) n;
      	System.out.println("Key Word: " + e.getElementsByTagName("orig-kw").item(0) .getChildNodes().item(0).getNodeValue());
    	System.out.println("Engine: " + e.getElementsByTagName("engine").item(0) .getChildNodes().item(0).getNodeValue());
    	System.out.println("Version: " + e.getElementsByTagName("kadu-version").item(0) .getChildNodes().item(0).getNodeValue());
    	System.out.println("Response time: " + e.getElementsByTagName("response-time").item(0) .getChildNodes().item(0).getNodeValue());
    	       }
      }
 // Parsing attribute (NodeList should be created for every node to getting the attributes of this node)
       //String element_d = "deals";
       //String attribute_d = "count";
       NodeList nl_5 = doc.getElementsByTagName("deals");
       for (int i=0; i<nl_5.getLength(); i++) {
       	Node n = nl_5.item(i); 
       if (n.getNodeType() == Node.ELEMENT_NODE){   
       	Element e = (Element) n;
       	System.out.println("Number of deals: " + e.getAttribute("count"));
  		}
      }
    }}

