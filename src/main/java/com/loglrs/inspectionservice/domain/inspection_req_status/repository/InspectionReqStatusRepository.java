package com.loglrs.inspectionservice.domain.inspection_req_status.repository;


import com.loglrs.inspectionservice.domain.inspection_req_status.entity.InspectionReqStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionReqStatusRepository extends JpaRepository<InspectionReqStatus, Long> {

}
