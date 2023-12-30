// package com.example.supplychain1.service;

// import com.example.supplychain1.model.Location;
// import com.example.supplychain1.model.Suppliers;
// import com.example.supplychain1.repository.SuppliersRepository;
// import com.example.supplychain1.service.impl.SuppliersServiceImpl;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.mock.web.MockMultipartFile;
// import org.springframework.web.multipart.MultipartFile;

// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotEquals;

// @ExtendWith(MockitoExtension.class)
// public class SuppliersServiceTest {
//     @Mock
//     private SuppliersRepository repo;

//     @InjectMocks
//     private SuppliersServiceImpl service;

//     @Test
//     public void testThatSuppliersCanGetAllData() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.findAll()).thenReturn(List.of(newSuppliers));
//         List<Suppliers> result = service.getAllData();
//         assertEquals(List.of(newSuppliers), result);
//     }

//     @Test
//     public void testThatSuppliersCanNotGetAllData() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.findAll()).thenThrow(RuntimeException.class);
//         List<Suppliers> result = service.getAllData();
//         assertNotEquals(List.of(newSuppliers), result);
//     }

//     @Test
//     public void testThatSuppliersCanbeCreated() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.save(newSuppliers)).thenReturn(newSuppliers);
//         Suppliers result = service.insert(newSuppliers);
//         assertEquals(newSuppliers, result);
//     }

//     @Test
//     public void testThatSuppliersCanNotbeCreated() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.save(newSuppliers)).thenThrow(RuntimeException.class);
//         Suppliers result = service.insert(newSuppliers);
//         assertNotEquals(newSuppliers, result);
//     }

//     @Test
//     public void testThatSuppliersCanGetById() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.findById("cd")).thenReturn(Optional.of(newSuppliers));
//         Optional<Suppliers> result = service.getById("cd");
//         assertEquals(Optional.of(newSuppliers), result);
//     }

//     @Test
//     public void testThatSuppliersCanNotGetById() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.findById("snffdk")).thenThrow(RuntimeException.class);
//         Optional<Suppliers> result = service.getById("snffdk");
//         assertNotEquals(Optional.of(newSuppliers), result);
//     }

//     @Test
//     public void testThatSuppliersCanUpdate() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.save(newSuppliers)).thenReturn(newSuppliers);
//         Suppliers result = service.update(newSuppliers);
//         assertEquals(newSuppliers, result);
//     }

//     @Test
//     public void testThatSuppliersCanNotUpdate() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.save(newSuppliers)).thenThrow(RuntimeException.class);
//         Suppliers result = service.update(newSuppliers);
//         assertNotEquals(newSuppliers, result);
//     }

//     @Test
//     public void testThatSuppliersCanDeleteById() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.deleteBy_id("cd")).thenReturn(true);
//         Boolean result = service.delete("cd");
//         assertEquals(true, result);
//     }

//     @Test
//     public void testThatSuppliersCanNotDeleteById() throws Exception {
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         Mockito.when(repo.deleteBy_id("cd")).thenThrow(RuntimeException.class);
//         Boolean result = service.delete("cd");
//         assertEquals(false, result);
//     }

//     @Test
//     public void testThatUploadImageWorks() throws Exception{
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         String name = "image";
//         String originalFileName = "img1.jpg";
//         String contentType = "image/jpg";
//         byte[] content = null;
//         MultipartFile file = new MockMultipartFile(name,originalFileName, contentType, content);
//         Mockito.when(repo.save(newSuppliers)).thenReturn(newSuppliers);
//         Boolean result = service.uploadImageToDB(newSuppliers,file);
//         assertEquals(true, result);
//     }

//     @Test
//     public void testThatUploadImageNotWorks() throws Exception{
//         Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "C:/Trustrace/Assignments/Mini project/supplychain1/src/main/java/com/example/supplychain1/images");
//         String name = "image";
//         String originalFileName = "img1.jpg";
//         String contentType = "image/jpg";
//         byte[] content = null;
//         MultipartFile file = new MockMultipartFile(name,originalFileName, contentType, content);
//         Mockito.when(service.update(newSuppliers)).thenThrow(RuntimeException.class);
//         Boolean result = service.uploadImageToDB(newSuppliers,file);
//         System.out.println(result);
//     }
// }
