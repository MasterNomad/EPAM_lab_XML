package dto;

import javax.xml.bind.annotation.*;
import java.util.List;

public class Category {

    @XmlAttribute(name = "id")
    private long id;

    @XmlAttribute(name = "title")
    private String title;

    @XmlElement(name = "subcategory")
    private List<SubCategory> subCategories;
}
