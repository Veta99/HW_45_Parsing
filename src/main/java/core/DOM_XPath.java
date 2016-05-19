package core;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class DOM_XPath {

	public static void main(String[] args) throws ParserConfigurationException,
			Exception {
		String xml = "http://learn2test.net/sdc.xml";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);
		doc.getDocumentElement().normalize();
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xp = xpf.newXPath();
					
		String element_01 = xp.compile("//server/orig-kw").evaluate(doc);
		String element_02 = xp.compile("//server/engine").evaluate(doc);
		String element_03 = xp.compile("//server/kadu-version").evaluate(doc);
		String element_04 = xp.compile("//response-time").evaluate(doc);
		String attribute_0501 = xp.compile("//deals/@count").evaluate(doc);
		
		
		System.out.println("Key Word: " + element_01);
		System.out.println("Engine: " + element_02);
		System.out.println("Version: " + element_03);
		System.out.println("Response time: " + element_04);
		System.out.println("Number of deals: " + attribute_0501);
			}
	}


