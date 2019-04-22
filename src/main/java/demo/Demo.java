package demo;

import com.google.gson.Gson;
import org.xml.sax.SAXException;
import xml.JavaBinder;
import xml.StaxStreamProcessor;
import xml.Validator;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class Demo {

    public <T> void printJsonsByPathAndXmlElementNameAndElementClass(String xmlPath, String xsdPath, String xmlElement, Class<T> elementClass)
            throws XMLStreamException, JAXBException, IOException, SAXException {
        StreamSource streamSource = new StreamSource(xmlPath);
        new Validator().validate(streamSource, xsdPath);
        try (StaxStreamProcessor processor = new StaxStreamProcessor(streamSource)) {
            JavaBinder javaBinder = new JavaBinder();
            while (processor.hasElements(xmlElement)) {
                System.out.println(new Gson().toJson(javaBinder.getObject(processor.getReader(), elementClass)));
            }
        }
    }

}
