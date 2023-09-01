package com.fanap.telecom.controller;


import com.fanap.telecom.constants.Messages;
import com.fanap.telecom.model.SaleOrder;
import com.fanap.telecom.model.User;
import com.fanap.telecom.model.dto.BaseResponseDto;
import com.fanap.telecom.model.dto.CommissionAllResponseDto;
import com.fanap.telecom.service.commission.CommissionServiceImpl;
import com.fanap.telecom.service.serviceImpl.SaleOrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/commissions")
@RequiredArgsConstructor
public class CommissionController {

    private final CommissionServiceImpl commissionService;
    private final SaleOrderServiceImpl saleOrderService;


    @PostMapping(value = "/{saleOrderId}")
    public ResponseEntity<BaseResponseDto<Object>> assignCommissionToReseller(@PathVariable Long saleOrderId) {
        commissionService.assignCommissionToReseller(saleOrderId);
        SaleOrder saleOrder = saleOrderService.find(saleOrderId);
        User user = saleOrder.getUser();
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.COMMISSION_ASSIGNED_TO_RESELLER + user.getUserId() + "user : " + user.getUserName())
                .build());
    }

    @GetMapping(value = "/{commissionId}")
    public ResponseEntity<BaseResponseDto<Object>> getCommissionById(@PathVariable Long commissionId) {
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .result(commissionService.findCommissionById(commissionId))
                .build());
    }

    @GetMapping
    public ResponseEntity<List<CommissionAllResponseDto>> getAllCommission() {
        return ResponseEntity.ok().body(commissionService.getAllCommission());
    }
}
