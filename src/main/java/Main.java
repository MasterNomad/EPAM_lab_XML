import demo.Demo;
import dto.Category;
import dto.Product;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new Demo().printJsonsByPathAndXmlElementNameAndElementClass(
                    "data/products.xml",
                    "data/products.xsd",
                    "category",
                    Category.class);
        } catch (XMLStreamException | JAXBException | IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("XML не соответствует схеме");
        }
    }
}
