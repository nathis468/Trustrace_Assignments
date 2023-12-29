package com.example.supplychain1.controller;

import com.example.supplychain1.model.Suppliers;
import com.example.supplychain1.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @GetMapping("/alldata")
    public ResponseEntity<List<Suppliers>> GetAllData(){
        try{
            return new ResponseEntity<List<Suppliers>>( suppliersService.getAllData(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<Suppliers>(Arrays.asList(new Suppliers())),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/databyid/{id}")
    public ResponseEntity<Optional<Suppliers>> GetById(@PathVariable("id") String _id){
        try{
            Optional<Suppliers> storeSuppliers=suppliersService.getById(_id);
            if(suppliersService.getById((_id)).isPresent()){
                return new ResponseEntity<>(storeSuppliers,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(Optional.of(new Suppliers()),HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(Optional.of(new Suppliers()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Suppliers> InsertData(@RequestBody Suppliers theSuppliers){
        try{
            suppliersService.insert(theSuppliers);
            return new ResponseEntity<Suppliers> (theSuppliers, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Suppliers> (new Suppliers(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Suppliers> UpdateData(@RequestBody Suppliers theSuppliers){
        try{
            suppliersService.update(theSuppliers);
            return new ResponseEntity<Suppliers> (theSuppliers, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Suppliers> (new Suppliers(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<Boolean> delete(@PathVariable String _id){
        try {
            suppliersService.delete(_id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("updateImage/{_id}")
    public ResponseEntity<Boolean> updateImage(@PathVariable String _id, @RequestParam("image") MultipartFile file) {
        try {
            if(file.isEmpty()){
                throw new Exception();
            }
            Optional<Suppliers> theSuppliers=suppliersService.getById(_id);
            Suppliers theSupplier2=theSuppliers.get();
            if(suppliersService.uploadImageToDB(theSupplier2, file))
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            else
                return new ResponseEntity<Boolean>(false, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("downloadImage/{_id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String _id) {
        try {
            Suppliers theSuppliers=suppliersService.getById(_id).get();
            String path=theSuppliers.getImageFilePath();
            System.out.println(path);
            if(path!= null){
                return ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.valueOf("image/jpg"))
                        .body(suppliersService.downloadImage(theSuppliers));
            }
            else{
                return new ResponseEntity<byte[]>(new byte[1], HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(new byte[1], HttpStatus.BAD_REQUEST);
        }
    }
}
