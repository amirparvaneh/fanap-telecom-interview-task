package com.fanap.telecom.controller;

import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiVersion.VERSION_1 + "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;
}
