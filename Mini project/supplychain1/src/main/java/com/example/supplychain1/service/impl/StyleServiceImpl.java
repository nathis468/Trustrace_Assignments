package com.example.supplychain1.service.impl;

import com.example.supplychain1.model.Style;
import com.example.supplychain1.repository.StyleRepository;
import com.example.supplychain1.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StyleServiceImpl implements StyleService {
    @Autowired
    StyleRepository repo;

    public Style insert(Style theStyle){
        Style newStyle=new Style();
        try{
            newStyle=repo.save(theStyle);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newStyle;
    }

    public void update(Style theStyle){
        repo.save(theStyle);
    }

    public List<Style> getAllData(){
        return repo.findAll();
    }

    public Optional<Style> getById(String _id){
        return repo.findById(_id);
    }

    public void delete(String _id){
        repo.deleteById(_id);
    }
}
