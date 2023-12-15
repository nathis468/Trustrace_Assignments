package com.example.supplychain1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection="material")
@Data
public class Style {
    @Id
    private long _id;
    public Availability availability;

    @Field("facility_name")
    private String facilityName;

    @Field("material_composition")
    private ArrayList<Material> materialComposition;

    @Field("required_certificate")
    private String requiredCertificate;

    private String season;

    @Field("style_name")
    private String styleName;

    @Field("style_number")
    private String styleNumber;

    @Field("style_uid")
    private String styleUid;

    @Field("supplier_name")
    private String supplierName;

    private String type;
    private String year;


    @Data
    public static class Availability{
        private String amount;
    }

    @Data
    public static class Material{
        @Field("m_id")
        @DocumentReference(collection="material")
        private Material mid;
        private int composition;
    }
}
