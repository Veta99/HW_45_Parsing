package core;

import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAX {

	public static void main(String[] args) throws XMLStreamException, Exception {
		URL url = new URL("http://learn2test.net/sdc.xml");
		
		//final String element_01 = "orig-kw";
		//final String element_02 = "engine";
		//final String element_03 = "kadu-version";
		//final String element_04 = "response-time";
		//final String element_05 = "deals";

		//final String element_name_01 = "Key Word: ";
		//final String element_name_02 = "Engine: ";
		//final String element_name_03 = "Version: ";
		//final String element_name_04 = "Response time: ";
		//final String element_name_05 = "Number of deals: ";
		
		InputStream is = url.openStream();
		
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		XMLStreamReader sr = xmlif.createXMLStreamReader(is);
		int eventType = sr.getEventType();
		
		while (sr.hasNext()) {
		eventType = sr.next();
		if (eventType == XMLStreamReader.START_ELEMENT) {
			if (sr.getLocalName() == "orig-kw") {
			System.out.println("Key Word:"  + sr.getElementText());
			}
			if (sr.getLocalName() == "engine") {
			System.out.println("Engine: " + sr.getElementText());
			}
			if (sr.getLocalName() == "kadu-version") {
			System.out.println("Version: " + sr.getElementText());
			}
			if (sr.getLocalName() == "response-time") {
			System.out.println("Response time: " + sr.getElementText());
			}
			if (sr.getLocalName() == "deals") {
			System.out.println("Number of deals: " + sr.getAttributeValue(0));
			}//if
		}//if if
		}//while
	}//main
	}//class



