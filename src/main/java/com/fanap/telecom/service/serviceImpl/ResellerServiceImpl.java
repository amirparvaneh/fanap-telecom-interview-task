package com.fanap.telecom.service.serviceImpl;

import com.fanap.telecom.constants.ErrorMessage;
import com.fanap.telecom.exception.DuplicateException;
import com.fanap.telecom.exception.NotFoundException;
import com.fanap.telecom.model.ReSeller;
import com.fanap.telecom.repository.ResellerRepo;
import com.fanap.telecom.service.ResellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ResellerServiceImpl implements ResellerService {

    private final ResellerRepo resellerRepo;

    @Override
    public void save(ReSeller reSeller) {
        if (Objects.nonNull(resellerRepo.findReSellerByCode(reSeller.getCode()))){
            throw new DuplicateException(ErrorMessage.DUPLICATE_ENTITY + reSeller.getCode());
        }
        resellerRepo.save(reSeller);
    }

    @Override
    public void delete(Long resellerId) {
        if (!resellerRepo.existsById(resellerId)){
            throw new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + resellerId);
        }
        resellerRepo.deleteById(resellerId);
    }

    @Override
    public ReSeller find(Long resellerId) {
        return resellerRepo.findById(resellerId).
                orElseThrow(() -> new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + resellerId));
    }
}
