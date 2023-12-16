package com.example.supplychain1.service;

import com.example.supplychain1.model.Suppliers;

import java.util.List;
import java.util.Optional;

public interface SuppliersService {
    void save(Suppliers theSuppliers);
    void update(Suppliers theSuppliers);
    Boolean delete(String id);
    List<Suppliers> getAllData();
    Optional<Suppliers> getById(String id);
}
