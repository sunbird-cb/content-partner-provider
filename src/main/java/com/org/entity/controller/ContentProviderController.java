package com.org.entity.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.org.entity.dto.CustomResponse;
import com.org.entity.elasticsearch.dto.SearchCriteria;
import com.org.entity.service.ContentPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contentPartner")
public class ContentProviderController {
    @Autowired
    private ContentPartnerService partnerService;

    @PostMapping("/create")
    public ResponseEntity<CustomResponse> create(@RequestBody JsonNode contentPartnerDetails) {
        CustomResponse response = partnerService.createOrUpdate(contentPartnerDetails);
        return new ResponseEntity<>(response, response.getResponseCode());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody JsonNode contentPartnerDetails) {
        CustomResponse response = partnerService.createOrUpdate(contentPartnerDetails);
        return new ResponseEntity<>(response, response.getResponseCode());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {
        CustomResponse response = partnerService.read(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/filter")
    public ResponseEntity<?> search(@RequestBody SearchCriteria searchCriteria) {
        CustomResponse response = partnerService.searchEntity(searchCriteria);
        return new ResponseEntity<>(response, response.getResponseCode());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        String response = partnerService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
