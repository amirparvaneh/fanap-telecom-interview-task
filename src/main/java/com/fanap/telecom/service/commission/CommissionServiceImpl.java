package com.fanap.telecom.service.commission;

import com.fanap.telecom.model.Commission;
import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.dto.CommissionRequestDto;
import com.fanap.telecom.model.dto.SaleOrderRequestDto;
import com.fanap.telecom.repository.CommissionRepo;
import com.fanap.telecom.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CommissionServiceImpl implements CommissionService{

    private final CommissionRepo commissionRepo;
    private final ProductServiceImpl productService;
    private final ModelMapper mapper;


    @Value("${commission.percent}")
    private BigDecimal commissionPercent;

    @Override
    public BigDecimal calculateCommissionPerSale(SaleOrderRequestDto saleOrderRequestDto) {
        Product product = productService.find(saleOrderRequestDto.getProduct());
        BigDecimal amount = BigDecimal.valueOf(Math.multiplyExact(product.getPrice(),saleOrderRequestDto.getNumber()));
        return commissionCalculate(amount);
    }

    @Override
    public void saveCommission(CommissionRequestDto commissionRequestDto) {
        Commission commission = mapper.map(commissionRequestDto,Commission.class);
        commissionRepo.save(commission);
    }


    private BigDecimal commissionCalculate(BigDecimal amount){
        return amount.multiply(commissionPercent);
    }
}
