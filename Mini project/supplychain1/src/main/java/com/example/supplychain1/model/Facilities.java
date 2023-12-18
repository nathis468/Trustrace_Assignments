package com.example.supplychain1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection="facilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facilities {
    @Id
    private String _id;

    private ArrayList<String> certifications;

    @Field("created_by")
    private String createdBy;

    @Field("facilities_uid")
    private String facilitiesUid;

    @Field("facility_name")
    private String facilityName;

    private String location;

    private String material;

    @Field("supplier_uid")
    @DocumentReference(collection="suppliers")
    private Suppliers supplierUid;
}
