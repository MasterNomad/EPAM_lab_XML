package dto;

import javax.xml.bind.annotation.*;
import java.util.List;

//@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute(name = "id")
    private long id;

    @XmlAttribute(name = "title")
    private String title;

    @XmlElementWrapper(name="subcategory")
    @XmlElement(name="product")
    private List<Product> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
