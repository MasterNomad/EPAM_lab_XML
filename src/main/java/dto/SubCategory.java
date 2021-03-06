package dto;

import javax.xml.bind.annotation.*;
import java.util.List;

public class SubCategory {

    @XmlAttribute(name = "title")
    private String title;

    @XmlElement(name = "product")
    private List<Product> products;

}
