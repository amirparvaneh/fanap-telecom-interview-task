package com.fanap.telecom.service;

import com.fanap.telecom.model.SaleOrder;
import com.fanap.telecom.model.dto.OrderListDto;

import java.util.List;

public interface SaleOrderService extends BaseService<SaleOrder> {
    List<OrderListDto> getAllOrder();
}
