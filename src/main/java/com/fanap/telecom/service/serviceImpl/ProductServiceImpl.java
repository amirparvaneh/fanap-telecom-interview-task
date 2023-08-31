package com.fanap.telecom.service.serviceImpl;


import com.fanap.telecom.model.Product;
import com.fanap.telecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Product find(Long id) {
        return null;
    }
}
