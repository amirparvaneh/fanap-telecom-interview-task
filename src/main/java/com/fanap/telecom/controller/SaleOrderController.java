package com.fanap.telecom.controller;

import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.constants.Messages;
import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.SaleOrder;
import com.fanap.telecom.model.User;
import com.fanap.telecom.model.dto.BaseResponseDto;
import com.fanap.telecom.model.dto.OrderListDto;
import com.fanap.telecom.model.dto.SaleOrderRequestDto;
import com.fanap.telecom.service.serviceImpl.ProductServiceImpl;
import com.fanap.telecom.service.serviceImpl.SaleOrderServiceImpl;
import com.fanap.telecom.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = ApiVersion.VERSION_1 + "/orders")
@RequiredArgsConstructor
public class SaleOrderController {

    private final SaleOrderServiceImpl saleOrderService;
    private final ProductServiceImpl productService;
    private final UserServiceImpl userService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<BaseResponseDto<Object>> addNewSaleOrder(@RequestParam Long productId,
                                                                   @RequestParam Long userId,
                                                                   @RequestParam Integer number) {
        SaleOrderRequestDto saleOrderRequestDto = getSaleOrderRequestDto(productId, userId, number);
        SaleOrder saleOrder = mapper.map(saleOrderRequestDto, SaleOrder.class);
        saleOrderService.save(saleOrder);
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.ORDER_SAVED)
                .result(saleOrder)
                .build());
    }

    private SaleOrderRequestDto getSaleOrderRequestDto(Long productId, Long userId, Integer number) {
        Date currentDate = new Date();
        User user = userService.find(userId);
        Product product = productService.find(productId);
        return SaleOrderRequestDto.builder()
                .user(user)
                .product(product)
                .number(number)
                .createdAt(currentDate)
                .updatedAt(currentDate)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<OrderListDto>> getAllSaleOrder() {
        return ResponseEntity.ok().body(saleOrderService.getAllOrder());
    }

}
