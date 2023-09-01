package com.fanap.telecom.service.commission;

import com.fanap.telecom.model.Commission;
import com.fanap.telecom.model.dto.CommissionRequestDto;
import com.fanap.telecom.model.dto.SaleOrderRequestDto;

import java.math.BigDecimal;

public interface CommissionService {
    BigDecimal calculateCommissionPerSale(Long productId,Integer number);
    void saveCommission(CommissionRequestDto commissionRequestDto);
    void assignCommissionToReseller(Long saleOrderId);
}
