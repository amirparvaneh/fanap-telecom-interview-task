package com.fanap.telecom.service;

import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.dto.ProductResponseAllDto;

import java.util.List;

public interface ProductService extends BaseService<Product>{
    List<ProductResponseAllDto> getAllProduct();
}
