package com.loglrs.inspectionservice.domain.component_service.inspection_req.service;


import com.loglrs.inspectionservice.domain.inspection_req.entity.InspectionReq;
import com.loglrs.inspectionservice.domain.inspection_req.service.InspectionReqService;
import com.loglrs.inspectionservice.domain.inspection_req_status.entity.InspectionReqStatus;
import com.loglrs.inspectionservice.domain.inspection_req_status_type.entity.InspectionReqStatusType;
import com.loglrs.inspectionservice.domain.inspection_req_status_type.service.InspectionReqStatusTypeService;
import com.loglrs.inspectionservice.domain.inspection_req_status_type.type.ReqStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InspectionReqComponentService {
    private final InspectionReqService inspectionReqService;

    private final InspectionReqStatusTypeService inspectionReqStatusTypeService;
    @Transactional
    public InspectionReq createInspectionReq(
            LocalDateTime inspectionDateTime
            , LocalDate moveInDate
            , Boolean isDeletedByHost
            , Boolean isDeletedByTenant
            , Long roomId
            , Long memberId
            , ReqStatusType reqStatusType
            , String message) {

        InspectionReq inspectionReq = new InspectionReq(inspectionDateTime, moveInDate, isDeletedByHost, isDeletedByTenant, roomId, memberId);
        List<InspectionReqStatus> inspectionReqStatuses = new ArrayList<>();

        InspectionReqStatusType inspectionReqStatusType = inspectionReqStatusTypeService.findByReqStatusType(reqStatusType);
        inspectionReqStatuses.add(new InspectionReqStatus(inspectionReqStatusType, message, inspectionReq));

        inspectionReq.updateInspectionReqStatuses(inspectionReqStatuses);

        return inspectionReqService.saveInspectionReq(inspectionReq);
    }

    @Transactional
    public InspectionReq createInspectionReqStatus(
            Long inspectionReqId
            , LocalDateTime inspectionDateTime
            , ReqStatusType reqStatusType
            , String message) {
        InspectionReq inspectionReq = inspectionReqService.findById(inspectionReqId);

        if(inspectionDateTime != null) {
            inspectionReq.updateInspectionDateTime(inspectionDateTime);
        }

        InspectionReqStatusType inspectionReqStatusType = inspectionReqStatusTypeService.findByReqStatusType(reqStatusType);

        inspectionReq.getInspectionReqStatuses().add(new InspectionReqStatus(inspectionReqStatusType, message, inspectionReq));

        return inspectionReq;
    }

    @Transactional
    public InspectionReq updateInspectionReq(
            Long inspectionReqId
            , Boolean isDeletedByHost
            , Boolean isDeletedByTenant
            ) {
        InspectionReq inspectionReq = inspectionReqService.findById(inspectionReqId);

        if(isDeletedByHost != null) {
            inspectionReq.updateIsDeletedByHost(isDeletedByHost);
        }

        if(isDeletedByTenant != null) {
            inspectionReq.updateIsDeletedByTenant(isDeletedByTenant);
        }

        return inspectionReq;
    }

}
