package com.fanap.telecom.service.serviceImpl;

import com.fanap.telecom.constants.ErrorMessage;
import com.fanap.telecom.exception.DuplicateException;
import com.fanap.telecom.exception.NotFoundException;
import com.fanap.telecom.model.ReSeller;
import com.fanap.telecom.model.dto.ResellerAllResponseDto;
import com.fanap.telecom.repository.ResellerRepo;
import com.fanap.telecom.service.ResellerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ResellerServiceImpl implements ResellerService {

    private final ResellerRepo resellerRepo;
    private final UserServiceImpl userService;
    private final ModelMapper mapper;

    @Override
    public void save(ReSeller reSeller) {
        if (Objects.nonNull(resellerRepo.findReSellerByCode(reSeller.getCode()))
                && Objects.nonNull(userService.getUserByUserName(reSeller.getUserName()))) {
            throw new DuplicateException(ErrorMessage.DUPLICATE_ENTITY + reSeller.getUserId());
        }
        resellerRepo.save(reSeller);
    }

    @Override
    public void delete(Long resellerId) {
        if (!resellerRepo.existsById(resellerId)) {
            throw new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + resellerId);
        }
        resellerRepo.deleteById(resellerId);
    }

    @Override
    public ReSeller find(Long resellerId) {
        return resellerRepo.findById(resellerId).
                orElseThrow(() -> new NotFoundException(ErrorMessage.ERROR_NOT_FOUND + resellerId));
    }


    @Override
    public List<ResellerAllResponseDto> findAllReseller() {
        List<ReSeller> reSellers = resellerRepo.findAll();
        return reSellers.stream().map(reSeller -> mapper.map(reSeller, ResellerAllResponseDto.class)).toList();
    }
}
