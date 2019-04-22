import demo.Demo;
import dto.Product;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Main {

    public static void main(String[] args) {
        try {
            new Demo().printJsonsByPathXmlElementNameAndElementClass(
                    "data/products.xml",
                    "product",
                    Product.class);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
