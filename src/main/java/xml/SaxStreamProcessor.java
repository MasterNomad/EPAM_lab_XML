package xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

public class SaxStreamProcessor implements AutoCloseable {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private final XMLStreamReader reader;

    public SaxStreamProcessor(StreamSource sourceStream) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(sourceStream);
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    public boolean nextElementByName(String elementName) throws XMLStreamException {
        while (reader.hasNext()) {
            if (reader.next() == XMLEvent.START_ELEMENT && elementName.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { // empty
            }
        }
    }

}
