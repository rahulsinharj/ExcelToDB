package com.libapi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.libapi.entity.Product;
import com.libapi.helper.ExcelHelper;
import com.libapi.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	// Ise hum excel file denge, aur ye excel file se data ko convert karega products me, usko db me save karega
	public void save(MultipartFile file) {

		try {
			List<Product> products = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			this.productRepo.saveAll(products);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ye return karega sare list of products ko
	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}

}
