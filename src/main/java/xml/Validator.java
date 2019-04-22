package xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {

    private SchemaFactory schemaFactory = SchemaFactory
            .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    public void validate(StreamSource streamSource, String schemaPath) throws SAXException, IOException {
        Schema schema = schemaFactory.newSchema(new File(schemaPath));
        javax.xml.validation.Validator validator = schema.newValidator();
        validator.validate(streamSource);
    }
}
