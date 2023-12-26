package com.fanap.telecom.service.serviceImpl;

import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.ProductDummy;
import com.fanap.telecom.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void save_validInput_successfullySave() {
        //given
        Product product = ProductDummy.productBuilder();
        //when
        //then
        productService.save(product);
        verify(productRepo,times(1)).save(product);
    }

    @Test
    void delete() {
    }

    @Test
    void find() {
    }

    @Test
    void getAllProduct() {
    }
}