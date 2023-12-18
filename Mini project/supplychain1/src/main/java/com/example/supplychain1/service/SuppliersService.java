package com.example.supplychain1.service;

import com.example.supplychain1.model.Suppliers;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface SuppliersService {
    Suppliers insert(Suppliers theSuppliers);
    Suppliers update(Suppliers theSuppliers);
    Boolean delete(String id);
    List<Suppliers> getAllData();
    Optional<Suppliers> getById(String id);

    Boolean uploadImageToDB(Suppliers theSuppliers , MultipartFile file);

    byte[] downloadImage(Suppliers theSuppliers);
}
