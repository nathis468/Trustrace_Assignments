package com.example.supplychain1.repository;

import com.example.supplychain1.model.RawMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RawMaterialRepository extends MongoRepository<RawMaterial, String> {
}
