package dto;

import enums.Brands;
import enums.Colors;
import xml.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    private Brands brand;
    private String model;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateOfManufacture;

    private Colors color;
    private BigDecimal price;
    private int quantity;
}
