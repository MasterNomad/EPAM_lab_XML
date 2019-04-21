package demo;

import com.google.gson.Gson;
import xml.JavaBinder;
import xml.StaxStreamProcessor;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public <T> void printJsonsByPathXmlElementNameAndElementClass(String path, String xmlElement, Class<T> elementClass)
            throws XMLStreamException, JAXBException {

        try (StaxStreamProcessor processor = new StaxStreamProcessor(new StreamSource(path))) {
            JavaBinder javaBinder = new JavaBinder();
            while (processor.hasElements(xmlElement)) {
                System.out.println(new Gson().toJson(javaBinder.getObject(processor.getReader(), elementClass)));
            }
        }
    }

}
