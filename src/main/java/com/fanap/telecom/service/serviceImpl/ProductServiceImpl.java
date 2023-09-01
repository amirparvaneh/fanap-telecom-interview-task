package com.fanap.telecom.service.serviceImpl;


import com.fanap.telecom.constants.ErrorMessage;
import com.fanap.telecom.exception.DuplicateException;
import com.fanap.telecom.exception.NotFoundException;
import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.dto.ProductResponseAllDto;
import com.fanap.telecom.repository.ProductRepo;
import com.fanap.telecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper mapper;

    @Override
    public void save(Product product) {
        if (Objects.nonNull(productRepo.findProductByName(product.getName()))) {
            throw new DuplicateException(ErrorMessage.DUPLICATE_ENTITY + product.getName());
        }
        productRepo.save(product);
    }

    @Override
    public void delete(Long productId) {
        if (!productRepo.existsById(productId)) {
            throw new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + productId);
        }
        productRepo.deleteById(productId);
    }

    @Override
    public Product find(Long productId) {
        return productRepo.findById(productId).
                orElseThrow(() -> new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + productId));
    }

    @Override
    public List<ProductResponseAllDto> getAllProduct() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(product -> mapper.map(product, ProductResponseAllDto.class)).toList();
    }

}
