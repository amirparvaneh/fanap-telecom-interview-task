package com.fanap.telecom.service;

import com.fanap.telecom.model.ReSeller;
import com.fanap.telecom.model.dto.ResellerAllResponseDto;

import java.util.List;

public interface ResellerService extends BaseService<ReSeller> {
    List<ResellerAllResponseDto> findAllReseller();
}
