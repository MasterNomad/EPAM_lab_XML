package dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute(name = "id")
    private long id;

    @XmlAttribute(name = "title")
    private String title;

    @XmlElement(name = "subcategory")
    private List<SubCategory> subCategories;
}
