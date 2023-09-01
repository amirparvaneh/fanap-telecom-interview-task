package com.fanap.telecom.controller;

import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.constants.Messages;
import com.fanap.telecom.model.SaleOrder;
import com.fanap.telecom.model.dto.BaseResponseDto;
import com.fanap.telecom.model.dto.OrderListDto;
import com.fanap.telecom.model.dto.SaleOrderRequestDto;
import com.fanap.telecom.service.serviceImpl.SaleOrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiVersion.VERSION_1 + "/orders")
@RequiredArgsConstructor
public class SaleOrderController {

    private final SaleOrderServiceImpl saleOrderService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<BaseResponseDto<Object>> addNewSaleOrder(@RequestBody SaleOrderRequestDto saleOrderRequestDto) {
        SaleOrder saleOrder = modelMapper.map(saleOrderRequestDto, SaleOrder.class);
        saleOrderService.save(saleOrder);
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.ORDER_SAVED)
                .result(saleOrder)
                .build());
    }

    @GetMapping
    public ResponseEntity<List<OrderListDto>> getAllSaleOrder(){
        return ResponseEntity.ok().body(saleOrderService.getAllOrder());
    }

}
