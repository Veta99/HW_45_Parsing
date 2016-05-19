package core;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, Exception {
		String url = "http://learn2test.net/sdc.xml";

		// final String element_01 = "orig-kw";
		// final String element_02 = "engine";
		// final String element_03 = "kadu-version";
		// final String element_04 = "response-time";
		// final String element_05 = "deals";

		// final String element_name_01 = "Key Word: ";
		// //final String element_name_02 = "Engine: ";
		// final String element_name_03 = "Version: ";
		// final String element_name_04 = "Response time: ";
		// final String element_name_05 = "Number of deals: ";

		SAXParserFactory sax_pf = SAXParserFactory.newInstance();
		SAXParser sax_p = sax_pf.newSAXParser();
		DefaultHandler dh = new DefaultHandler() {
			boolean h_origkw = false;
			boolean h_engine = false;
			boolean h_kaduversion = false;
			boolean h_responsetime = false;
			boolean h_deals = false;
			String attribute_01;

			// a - url; b - localName; c - qName; d - attributes)
			public void startElement(String url, String LocalName,
					String qName, Attributes Attr) throws SAXException {

				// System.out.println("Start Element :" + qName);
				if (qName.equals("orig-kw")) {
					h_origkw = true;
				}
				if (qName.equals("engine")) {
					h_engine = true;
				}
				if (qName.equals("kadu-version")) {
					h_kaduversion = true;
				}
				if (qName.equals("response-time")) {
					h_responsetime = true;
				}
				if (qName.equals("deals")) {
					h_deals = true;
					attribute_01 = Attr.getValue("count");
				}
			}

			public void characters(char ch[], int start, int length)
					throws SAXException {
				if (h_origkw) {
					System.out.println("Key Word: "
							+ new String(ch, start, length));
					h_origkw = false;
				}
				if (h_engine) {
					System.out.println("Engine: "
							+ new String(ch, start, length));
					h_engine = false;
				}
				if (h_kaduversion) {
					System.out.println("Version: "
							+ new String(ch, start, length));
					h_kaduversion = false;
				}
				if (h_responsetime) {
					System.out.println("Response time: "
							+ new String(ch, start, length));
					h_responsetime = false;
				}

				if (h_deals) {
					System.out.println("Nimber of deals: " + attribute_01);
					h_deals = false;
				}
			}

			public void endElement(String uri, String localName, String qName)
					throws SAXException {
			}
		};
		sax_p.parse(url, dh);
	}
}

