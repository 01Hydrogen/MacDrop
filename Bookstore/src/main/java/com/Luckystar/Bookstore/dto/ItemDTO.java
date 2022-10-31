package com.Luckystar.Bookstore.dto;

//import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Getter
@Setter
public class ItemDTO {
    private String id;
    private String itemName;
    private Double price;
}
