package com.loglrs.inspectionservice.domain.inspection_req_status_type.repository;


import com.loglrs.inspectionservice.domain.inspection_req_status_type.entity.InspectionReqStatusType;
import com.loglrs.inspectionservice.domain.inspection_req_status_type.type.ReqStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InspectionReqStatusTypeRepository extends JpaRepository<InspectionReqStatusType, Long> {
    Optional<InspectionReqStatusType> findByReqStatusType(ReqStatusType reqStatusType);
}
