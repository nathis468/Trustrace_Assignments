package com.example.supplychain1.controller;

import com.example.supplychain1.model.Style;
import com.example.supplychain1.model.Suppliers;
import com.example.supplychain1.model.Style;
import com.example.supplychain1.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/style")
public class StyleController {
    @Autowired
    StyleService styleService;

    @GetMapping("/alldata")
    public ResponseEntity<List<Style>> GetAllData(){
        try{
            return new ResponseEntity<List<Style>>(styleService.getAllData(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<Style>(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/databyid/{id}")
    public ResponseEntity<Optional<Style>> GetById(@PathVariable("id") String _id){
        try{
            Optional<Style> storeStyle=styleService.getById(_id);
            if(styleService.getById((_id)).isPresent()){
                return new ResponseEntity<>(storeStyle,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(Optional.of(new Style()),HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(Optional.of(new Style()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Style> InsertData(@RequestBody Style theStyle){
        try{
            styleService.insert(theStyle);
            return new ResponseEntity<Style> (theStyle, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Style> (new Style(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateData(@RequestBody Style theStyle){
        try{
            styleService.update(theStyle);
            return new ResponseEntity<String>("Updated document successfully",HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<String> delete(@PathVariable String _id){
        try {
            if (styleService.getById((_id)).isPresent()) {
                styleService.delete(_id);
                return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
            }
            else{
                return new ResponseEntity<String>( "Id not found",HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            return new ResponseEntity<String>("Internal error",HttpStatus.BAD_REQUEST);
        }
    }

}
