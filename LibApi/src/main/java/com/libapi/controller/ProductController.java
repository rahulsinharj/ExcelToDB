package com.libapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.libapi.entity.Product;
import com.libapi.helper.ExcelHelper;
import com.libapi.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	 @PostMapping("/product/upload")
	    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
	        if (ExcelHelper.checkExcelFormat(file)) {
	            //true

	            this.productService.save(file);

	            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
	    }


	    @GetMapping("/product")
	    public List<Product> getAllProduct() {
	        return this.productService.getAllProducts();
	    }

}
