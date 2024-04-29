package com.org.entity.repository;

import com.org.entity.entity.ContentPartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentPartnerRepository extends JpaRepository<ContentPartnerEntity, String>{

}