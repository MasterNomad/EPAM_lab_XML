package xml;

import dto.Category;
import dto.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

public class Reader {

    public void parse(String path) throws Exception {

        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(path);
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(xml);
        streamReader.nextTag();
        while (streamReader.hasName()) {
            while (!streamReader.getLocalName().equals("subcategory")) {
                streamReader.nextTag();
            }

            JAXBContext context = JAXBContext.newInstance(Category.class, Product.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<Category> jb = unmarshaller.unmarshal(streamReader, Category.class);

            Category category = jb.getValue();
            System.out.println(category.getId());
            System.out.println(category.getTitle());
            System.out.println(category.getProducts());

//            Product product = jb.getValue();
//            System.out.println(product.getBrand());
//            System.out.println(product.getModel());
//            System.out.println(product.getColor());
//            System.out.println(product.getPrice());
//            System.out.println(product.getQuantity());
        }
        streamReader.close();
    }

}
