// package com.example.supplychain1.controller;

// import com.example.supplychain1.model.Location;
// import com.example.supplychain1.model.Suppliers;
// import com.example.supplychain1.service.SuppliersService;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.boot.test.mock.mockito.SpyBean;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.MediaType;
// import org.springframework.mock.web.MockMultipartFile;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.File;
// import java.io.UnsupportedEncodingException;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// @WebMvcTest(value = SuppliersController.class)
// public class SuppliersControllerTest {
//     @Autowired
//     MockMvc mockMvc;

//     @MockBean
//     @SpyBean
//     SuppliersService service;

//     @Test
//     void SupplierGetAllData() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.getAllData()).thenReturn(Arrays.asList(newSuppliers));
//         String result=mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/alldata"))
//                 .andExpect(status().isOk())
//                 .andReturn().getResponse().getContentAsString();
//         System.out.println("_____________________________");
//         System.out.println(result);
//         System.out.println("_____________________________");

//         ArrayList op = new ObjectMapper().readValue(result, ArrayList.class);
//         System.out.println(op);
//         assertFalse(op.equals(null));
//     }

//    @Test
//    void SupplierNotGetAllData() throws Exception {
//        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//        Mockito.when(service.getAllData()).thenThrow(RuntimeException.class);
//        String result=mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/alldata"))
//                .andExpect(status().isBadRequest())
//                .andReturn().getResponse().getContentAsString();
//        System.out.println("_____________________________");
//        System.out.println(result);
//        System.out.println("_____________________________");

//        List<Suppliers> op = Arrays.asList(new ObjectMapper().readValue(result, Suppliers[].class));
//        assertEquals(op,Arrays.asList(new Suppliers()));
//    }


//     @Test
//     void testGetByIdWorks() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
//         String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/databyid/cd")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//         System.out.println("_____________________________");
//         System.out.println(result);
//         System.out.println("_____________________________");

//         Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
//         assertFalse(op.equals(null));
//     }

//     @Test
//     void testGetByIdNotFound() throws Exception {
//         Mockito.when(service.getById("id")).thenReturn(Optional.of(new Suppliers()));
//         String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/databyid/cd")).andExpect(status().isNotFound()).andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Suppliers())))
//         .andReturn().getResponse().getContentAsString();
//         System.out.println("_____________________________");
//         System.out.println(result);
//         System.out.println("_____________________________");

//         Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
//         System.out.println(op);
//         assertEquals(op,new Suppliers());
//     }

//     @Test
//     void testGetByIdNotWorks() throws Exception {
//         Mockito.when(service.getById("id")).thenThrow(RuntimeException.class);
//         String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/databyid/id"))
//                 .andExpect(status().isBadRequest())
//                 .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Suppliers())))
//                 .andReturn().getResponse().getContentAsString();
//         System.out.println("_____________________________");
//         System.out.println(result);
//         System.out.println("_____________________________");

//         Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
//         assertTrue(op.equals(new Suppliers()));
//     }

//     @Test
//     public void testInsertWorks() throws Exception{
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.insert(Mockito.any(Suppliers.class))).thenReturn(newSuppliers);
//         String result = mockMvc.perform(MockMvcRequestBuilders.post("/suppliers/insert").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//         Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
//         assertThat(actualOutput).isEqualTo(newSuppliers);
//     }

//     @Test
//     public void testInsertNotWorks() throws Exception{
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.insert(newSuppliers)).thenThrow(RuntimeException.class);
//         String result = mockMvc.perform(MockMvcRequestBuilders.post("/suppliers/insert").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isBadRequest()).andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Suppliers())))
//                 .andReturn().getResponse().getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//         Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
//         assertThat(actualOutput).isEqualTo(new Suppliers());
//     }

//     @Test
//     public void testUpdateWorks() throws Exception{
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.update(Mockito.any(Suppliers.class))).thenReturn(newSuppliers);
//         String result = mockMvc.perform(MockMvcRequestBuilders.put("/suppliers/update").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//         Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
//         assertThat(actualOutput).isEqualTo(newSuppliers);
//     }

//     @Test
//     public void testUpdateNotWorks() throws Exception{
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.update(newSuppliers)).thenThrow(RuntimeException.class);
//         String result = mockMvc.perform(MockMvcRequestBuilders.put("/suppliers/update").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isBadRequest()).andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Suppliers())))
//                 .andReturn().getResponse().getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//         Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
//         assertThat(actualOutput).isEqualTo(new Suppliers());
//     }

//     @Test
//     void testDeleteWorks() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
//         Mockito.when(service.delete("cd")).thenReturn(true);
//         String result = mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/cd")).andExpect(status().isOk()).andReturn().getResponse()
//                 .getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");

//         Boolean op = new ObjectMapper().readValue(result, Boolean.class);
//         assertEquals(true,op);
//     }

//     @Test
//     void testDeleteNotWorks() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.getById("cd")).thenReturn(Optional.of(newSuppliers));
//         Mockito.when(service.delete("id")).thenThrow(RuntimeException.class);
//         String result = mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/id"))
//                 .andExpect(status().isBadRequest())
//                 .andReturn().getResponse()
//                 .getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");

//         Boolean op = new ObjectMapper().readValue(result, Boolean.class);
//         assertEquals(false,op);
//     }

//     // @Test
//     // void testupdateImageWorks() throws JsonProcessingException, UnsupportedEncodingException, Exception{
//     //     Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier","C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images/img1.jpg");
//     //     String name = "image";
//     //     String originalFileName = "img1.jpg";
//     //     String contentType = "image/jpg";
//     //     byte[] content = null;
//     //     MultipartFile file = new MockMultipartFile(name,originalFileName, contentType, content);
//     //     Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
//     //     Mockito.when(service.uploadImageToDB(Mockito.any(),Mockito.any(MultipartFile.class))).thenReturn(true);
//     //     String result = mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT,"/suppliers/updateImage/cd")
//     //                                     .file(new MockMultipartFile(name,originalFileName,contentType,content)))
//     //                                     .andExpect(MockMvcResultMatchers.status().isOk())
//     //                                     .andReturn().getResponse().getContentAsString();
//     //     System.out.println("___________");
//     //     System.out.println(result);
//     //     System.out.println("___________");
//     // }


//     // @Test
//     // public void testUpdateImageNotWorks() throws JsonProcessingException, UnsupportedEncodingException, Exception
//     // {
//     //     Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier","C:\\Trustrace\\Assignments\\Mini project\\supplychain1\\src\\main\\java\\com\\example\\supplychain1\\images\\img1.jpg");
//     //     String name = "image";
//     //     String originalFileName = "img1.jpg";
//     //     String contentType = "image/jpg";
//     //     byte[] content = null;
//     //     MultipartFile file = new MockMultipartFile(name,originalFileName, contentType, content);
//     //     Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
//     //     Mockito.when(service.uploadImageToDB(newSuppliers,Mockito.any(MultipartFile.class))).thenReturn(false);
//     //     String result = mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT,"/suppliers/updateImage/cd")
//     //                                     .file(new MockMultipartFile("image",originalFileName,contentType,content)))
//     //                                     .andExpect(MockMvcResultMatchers.status().isNotFound())
//     //                                     .andReturn().getResponse().getContentAsString();
//     //     System.out.println("___________");
//     //     System.out.println(result);
//     //     System.out.println("___________");
//     // }

//     @Test
//     public void testUpdateImageThrowsException() throws JsonProcessingException, UnsupportedEncodingException, Exception
//     {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier","");
//         String name = "image";
//         String originalFileName = "img1.jpg";
//         String contentType = "image/jpg";
//         byte[] content = null;
//         MultipartFile file = new MockMultipartFile(name,originalFileName, contentType, content);
//         Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
//         Mockito.when(service.uploadImageToDB(Mockito.any(),Mockito.any(MultipartFile.class))).thenThrow(RuntimeException.class);
//         String result = mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT,"/suppliers/updateImage/cd")
//                                         .file(new MockMultipartFile("image",originalFileName,contentType,content)))
//                                         .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                                         .andReturn().getResponse().getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//     }

//    @Test
//     void testGetImageWorks() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier","C:\\Trustrace\\Assignments\\Mini project\\supplychain1\\src\\main\\java\\com\\example\\supplychain1\\images\\img1.jpg");
//         Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
//         Mockito.when(service.downloadImage(newSuppliers)).thenReturn(new byte[]{});
//         String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/downloadImage/cd")).andExpect(status().isOk()).andReturn().getResponse()
//                 .getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//     }

//     @Test
//     void testGetImageNotFound() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier",null);
//         Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
//         Mockito.when(service.downloadImage(newSuppliers)).thenReturn(new byte[]{});
//         String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/downloadImage/cd")).andExpect(status().isNotFound()).andReturn().getResponse()
//                 .getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//     }

//     @Test
//     void testGetImageThrowsException() throws Exception {
//         // Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier","C:\\Trustrace\\Assignments\\Mini project\\supplychain1\\src\\main\\java\\com\\example\\supplychain1\\images\\img1.jpg");
//         Mockito.when(service.getById(Mockito.anyString())).thenThrow(RuntimeException.class);
//         Mockito.when(service.downloadImage(Mockito.any(Suppliers.class))).thenReturn(new byte[]{});
//         String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/downloadImage/cd")).andExpect(status().isBadRequest()).andReturn().getResponse()
//                 .getContentAsString();
//         System.out.println("___________");
//         System.out.println(result);
//         System.out.println("___________");
//     }

// }