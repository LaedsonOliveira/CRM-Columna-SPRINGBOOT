package com.dev.laedson.crmColumna.controller;

import com.dev.laedson.crmColumna.dto.CreateEnterpriseDto;
import com.dev.laedson.crmColumna.dto.EnterpriseIdDto;
import com.dev.laedson.crmColumna.model.Enterprise;
import com.dev.laedson.crmColumna.service.EnterpriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping
    public ResponseEntity<Enterprise> createEnterprise(@RequestBody CreateEnterpriseDto createEnterPriseDto) {
        var enterprise = enterpriseService.createEnterprise(createEnterPriseDto);
        return ResponseEntity.ok().body(enterprise);
    }

    @GetMapping
    public  ResponseEntity<Enterprise> getEnterpriseById(@RequestBody EnterpriseIdDto dto) {
        var enterprise = enterpriseService.getEnterpriseById(dto);

        return ResponseEntity.ok().body(enterprise);
    }


    @DeleteMapping
    public void deleteEnterprise (@RequestBody EnterpriseIdDto dto) {
        enterpriseService.deleteEnterprise(dto);
    }
}
