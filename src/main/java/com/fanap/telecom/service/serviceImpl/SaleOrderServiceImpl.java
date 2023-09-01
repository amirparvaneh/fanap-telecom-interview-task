package com.fanap.telecom.service.serviceImpl;

import com.fanap.telecom.constants.ErrorMessage;
import com.fanap.telecom.exception.NotFoundException;
import com.fanap.telecom.model.SaleOrder;
import com.fanap.telecom.model.dto.OrderListDto;
import com.fanap.telecom.repository.SaleOrderRepo;
import com.fanap.telecom.service.SaleOrderService;
import com.fanap.telecom.service.commission.CommissionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService {

    private final SaleOrderRepo saleOrderRepo;
    private final ModelMapper mapper;

    @Override
    public void save(SaleOrder saleOrder) {
        saleOrderRepo.save(saleOrder);
    }

    @Override
    public void delete(Long saleOrderId) {
        saleOrderRepo.deleteById(saleOrderId);
    }

    @Override
    public SaleOrder find(Long saleOrderId) {
        return saleOrderRepo.findById(saleOrderId).orElseThrow(() ->
                new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + saleOrderId));
    }

    @Override
    public List<OrderListDto> getAllOrder() {
        List<SaleOrder> saleOrderList = saleOrderRepo.findAll();
        return saleOrderList.stream().map(saleOrder -> mapper.map(saleOrder,OrderListDto.class)).toList();
    }
}
