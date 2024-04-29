package com.org.entity.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.org.entity.dto.CustomResponse;
import com.org.entity.elasticsearch.dto.SearchCriteria;

public interface ContentPartnerService {
    CustomResponse createOrUpdate(JsonNode demandsJson);

    CustomResponse read(String id);

    CustomResponse searchEntity(SearchCriteria searchCriteria);

    String delete(String id);

}
