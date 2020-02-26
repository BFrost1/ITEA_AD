package homeWork.homeWork11.SaxParser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MainSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new File("pom.xml"), new SaxParser());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
