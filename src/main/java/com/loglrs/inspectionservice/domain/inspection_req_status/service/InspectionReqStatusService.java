package com.loglrs.inspectionservice.domain.inspection_req_status.service;


import com.loglrs.inspectionservice.domain.inspection_req_status.repository.InspectionReqStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InspectionReqStatusService {
    private final InspectionReqStatusRepository inspectionReqStatusRepository;


}
