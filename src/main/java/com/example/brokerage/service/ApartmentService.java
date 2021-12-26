package com.example.brokerage.service;


import com.example.brokerage.exception.ErrorCode;
import com.example.brokerage.exception.HouseUtilsException;
import com.example.brokerage.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPrice(Long id){
        return this.apartmentRepository.findById(id)
                .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND, "해당 ID가 존재하지않습니다."))
                .getPrice();
    }
}
