package com.org.entity.elasticsearch.service;

import com.org.entity.elasticsearch.dto.SearchCriteria;
import com.org.entity.elasticsearch.dto.SearchResult;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.Map;

public interface EsUtilService {

  RestStatus addDocument(String esIndexName, String type, String id, Map<String, Object> document);

  RestStatus updateDocument(String index, String indexType, String entityId, Map<String, Object> document);

  void deleteDocument(String documentId, String esIndexName);

  void deleteDocumentsByCriteria(String esIndexName, SearchSourceBuilder sourceBuilder);

  SearchResult searchDocuments(String esIndexName, SearchCriteria searchCriteria) throws Exception;
}
