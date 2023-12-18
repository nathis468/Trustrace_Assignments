package com.example.supplychain1.service.impl;

import com.example.supplychain1.model.Suppliers;
import com.example.supplychain1.repository.SuppliersRepository;
import com.example.supplychain1.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuppliersServiceImpl implements SuppliersService {
    @Autowired
    SuppliersRepository repo;

    public Suppliers insert(Suppliers theSuppliers){
        Suppliers newSuppliers=new Suppliers();
        try{
            newSuppliers= repo.save(theSuppliers);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newSuppliers;
    }

    public Suppliers update(Suppliers theSuppliers){
        Suppliers newSuppliers=new Suppliers();
        try{
            newSuppliers= repo.save(theSuppliers);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newSuppliers;
    }

    public List<Suppliers> getAllData(){
        try{
            return repo.findAll();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Suppliers> getById(String _id){
        try {
            return repo.findById(_id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean delete(String _id){
        try{
            repo.deleteBy_id(_id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean uploadImageToDB(Suppliers theSuppliers ,MultipartFile file) {
        try {
            String filePath="C:\\Trustrace\\Assignments\\Mini project\\supplychain1\\src\\main\\java\\com\\example\\supplychain1\\images"+file.getOriginalFilename();
            theSuppliers.setImageFilePath(filePath);
            file.transferTo(new File(filePath));
            if(update(theSuppliers)!=null) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public byte[] downloadImage(Suppliers theSuppliers) {
        String filePath=theSuppliers.getImageFilePath();
        try {
            if(filePath==null)
                return null;
            byte[] images = Files.readAllBytes(new File(filePath).toPath());
            return images;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
