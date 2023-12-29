package com.example.supplychain1.service;

import com.example.supplychain1.model.Style;

import java.util.List;
import java.util.Optional;

public interface StyleService {
    Style insert(Style theStyle);
    void update(Style theStyle);
    void delete(String id);
    List<Style> getAllData();
    Optional<Style> getById(String id);
}
