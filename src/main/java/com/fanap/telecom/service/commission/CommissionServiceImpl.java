package com.fanap.telecom.service.commission;

import com.fanap.telecom.constants.ErrorMessage;
import com.fanap.telecom.exception.NotAllowedCommission;
import com.fanap.telecom.model.Commission;
import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.ReSeller;
import com.fanap.telecom.model.SaleOrder;
import com.fanap.telecom.model.dto.CommissionRequestDto;
import com.fanap.telecom.model.dto.SaleOrderRequestDto;
import com.fanap.telecom.repository.CommissionRepo;
import com.fanap.telecom.service.serviceImpl.ProductServiceImpl;
import com.fanap.telecom.service.serviceImpl.ResellerServiceImpl;
import com.fanap.telecom.service.serviceImpl.SaleOrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommissionServiceImpl implements CommissionService {

    private final CommissionRepo commissionRepo;
    private final ProductServiceImpl productService;
    private final SaleOrderServiceImpl saleOrderService;
    private final ResellerServiceImpl resellerService;
    private final ModelMapper mapper;


    @Value("${commission.percent}")
    private BigDecimal commissionPercent;

    @Override
    public BigDecimal calculateCommissionPerSale(Long productId,Integer number) {
        Product product = productService.find(productId);
        BigDecimal amount = BigDecimal.valueOf(Math.multiplyExact(product.getPrice(), number));
        return commissionCalculate(amount);
    }

    @Override
    public void saveCommission(CommissionRequestDto commissionRequestDto) {
        Commission commission = mapper.map(commissionRequestDto, Commission.class);
        commissionRepo.save(commission);
    }

    @Override
    public void assignCommissionToReseller(Long saleOrderId) {
        SaleOrder saleOrder = saleOrderService.find(saleOrderId);
        checkSaleCommission(saleOrder);
        Long resellerId = saleOrder.getUser().getUserId();
        checkReseller(resellerId);
        BigDecimal orderAmount = calculateCommissionPerSale(saleOrder.getProduct().getProductId(),saleOrder.getNumber());
        Date currentDate = new Date();
        CommissionRequestDto commissionRequestDto = CommissionRequestDto.builder()
                .resellerId(resellerId)
                .saleOrderId(saleOrderId)
                .amount(orderAmount)
                .createdAt(currentDate)
                .updateAt(currentDate)
                .build();
        saveCommission(commissionRequestDto);
    }


    private BigDecimal commissionCalculate(BigDecimal amount) {
        return amount.multiply(commissionPercent);
    }

    private void checkReseller(Long resellerId) {
        if (Objects.isNull(resellerService.find(resellerId))) {
            throw new NotAllowedCommission(ErrorMessage.NOT_ALLOWED);
        }
    }

    private void checkSaleCommission(SaleOrder saleOrder) {
        if (Objects.nonNull(saleOrder.getCommissionId())) {
            throw new NotAllowedCommission(ErrorMessage.COMMISSION_CALCULATED + saleOrder.getCommissionId());
        }
    }
}
