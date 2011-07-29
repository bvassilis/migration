package com.main.stories;

import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;

import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.HTMLSchema;

import org.jdom.Namespace;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXHandler;

import java.io.*;

public class HTMLFilter {

static private Namespace XHTML_NS = Namespace.getNamespace("http://www.w3.org/1999/xhtml");

  public static String fixHtml(String input) throws IOException, SAXException {

	  
	  XMLReader r = new Parser();
      HTMLSchema schema = new HTMLSchema();
      r.setProperty(Parser.schemaProperty, schema);

      SAXHandler sh = new SAXHandler();
      ContentHandler h = sh;
      r.setContentHandler(h);

      InputSource s = new InputSource();
      s.setCharacterStream(new StringReader(input));
      r.parse(s);

      Document document = sh.getDocument();
      Element element = document.getRootElement().getChild("body", XHTML_NS);

      XMLOutputter output = new XMLOutputter();
      String fixed = "";
      if (element != null)
    	  fixed = output.outputString(element).substring(43).replace("</body>", "");
      
//	  Tidy td = new Tidy();
//	  byte[] bytes = fixed.getBytes("UTF-8");
//	  ByteArrayInputStream is = new ByteArrayInputStream(bytes);
//	  
//	  td.setXHTML(true);
//	  td.parseDOM(is, System.out);
	  
      fixed = "<div><p>"+fixed+"</p></div>";
      return fixed;
  }
  

  public static String convertStreamToString(InputStream is) {

    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    String line = null;
    try {
      while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }

  public static void main(String [] args) throws IOException, SAXException {
    String s = convertStreamToString(System.in);
    System.out.println(fixHtml(s));
  }
}
