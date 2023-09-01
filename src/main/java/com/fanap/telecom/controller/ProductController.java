package com.fanap.telecom.controller;

import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.constants.Messages;
import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.dto.BaseResponseDto;
import com.fanap.telecom.model.dto.ProductRequestDto;
import com.fanap.telecom.model.dto.ProductResponseAllDto;
import com.fanap.telecom.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiVersion.VERSION_1 + "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.save(mapper.map(productRequestDto, Product.class));
        return ResponseEntity.ok(Messages.ENTITY_ADDED + productRequestDto.getName());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<BaseResponseDto<Object>> getProductById(@PathVariable Long productId) {
        Product product = productService.find(productId);
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.ENTITY_FOUNDED + productId)
                .result(product)
                .build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseAllDto>> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }
}
