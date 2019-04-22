package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

public class JavaBinder {

    public <T> T getObject(XMLStreamReader reader, Class<T> elementClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(elementClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBElement<T> jBiding = unmarshaller.unmarshal(reader, elementClass);
        return jBiding.getValue();
    }

}
