package com.dev.laedson.crmColumna.service;

import com.dev.laedson.crmColumna.dto.CreateEnterpriseDto;
import com.dev.laedson.crmColumna.dto.EnterpriseIdDto;
import com.dev.laedson.crmColumna.model.Enterprise;
import com.dev.laedson.crmColumna.model.User;
import com.dev.laedson.crmColumna.repository.EnterpriseRepository;
import com.dev.laedson.crmColumna.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseService {

    private EnterpriseRepository enterpriseRepository;
    private UserRepository userRepository;


    public EnterpriseService(EnterpriseRepository enterpriseRepository, UserRepository userRepository) {
        this.enterpriseRepository = enterpriseRepository;
        this.userRepository = userRepository;
    }

    public Enterprise createEnterprise(CreateEnterpriseDto createEnterPriseDto) {

        User owner = userRepository.findById(createEnterPriseDto.owner())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var enterprise = new Enterprise(
                createEnterPriseDto.name(),
                createEnterPriseDto.CNPJ(),
                createEnterPriseDto.category(),
                owner
        );

        return enterpriseRepository.save(enterprise);
    }

    public Enterprise getEnterpriseById(EnterpriseIdDto dto) {
        var enterprise = enterpriseRepository.findById(dto.enterpriseId())
                .orElseThrow(() -> new RuntimeException("Enterprise not found"));

        return enterprise;
    }

    public void deleteEnterprise(EnterpriseIdDto dto) {
        var enterprise = enterpriseRepository.findById(dto.enterpriseId())
                .orElseThrow(() -> new RuntimeException("Enterprise not found"));

        enterpriseRepository.delete(enterprise);
    }
}
