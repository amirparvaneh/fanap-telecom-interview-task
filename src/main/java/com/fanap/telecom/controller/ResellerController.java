package com.fanap.telecom.controller;

import com.fanap.telecom.ApiVersion;
import com.fanap.telecom.constants.Messages;
import com.fanap.telecom.model.BaseEntity;
import com.fanap.telecom.model.ReSeller;
import com.fanap.telecom.model.dto.BaseResponseDto;
import com.fanap.telecom.model.dto.ResellerAllResponseDto;
import com.fanap.telecom.model.dto.ResellerRequestDto;
import com.fanap.telecom.service.serviceImpl.ResellerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiVersion.VERSION_1 + "/resellers")
@RequiredArgsConstructor
public class ResellerController {

    private final ResellerServiceImpl resellerService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<BaseResponseDto<Object>> addReseller(@RequestBody ResellerRequestDto resellerRequestDto) {
        resellerService.save(mapper.map(resellerRequestDto, ReSeller.class));
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.ENTITY_ADDED + resellerRequestDto.getCode())
                .build());
    }

    @GetMapping(value = "/{resellerId}")
    public ResponseEntity<BaseResponseDto<Object>> getResellerById(@PathVariable Long resellerId) {
        return ResponseEntity.ok().body(BaseResponseDto.builder()
                .message(Messages.ENTITY_FOUNDED + resellerId)
                .result(resellerService.find(resellerId))
                .build());
    }

    @GetMapping
    public ResponseEntity<List<ResellerAllResponseDto>> getAllReseller() {
        return ResponseEntity.ok().body(resellerService.findAllReseller());
    }
}
