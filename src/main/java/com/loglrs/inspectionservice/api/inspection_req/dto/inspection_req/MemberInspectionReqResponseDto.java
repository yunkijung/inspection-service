package com.loglrs.inspectionservice.api.inspection_req.dto.inspection_req;


import com.loglrs.inspectionservice.domain.inspection_req.entity.InspectionReq;
import com.loglrs.inspectionservice.domain.inspection_req_status.entity.InspectionReqStatus;
import com.loglrs.inspectionservice.domain.inspection_req_status_type.entity.InspectionReqStatusType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

@Data
public class MemberInspectionReqResponseDto {
    private Long inspectionReqId;
    private LocalDateTime inspectionDateTime;
    private LocalDate moveInDate;
    private Boolean isDeletedByTenant;
//    private RoomDto room;
    private MemberReqStatusTypeDto memberReqStatusType;
    private String message;

    public MemberInspectionReqResponseDto(InspectionReq inspectionReq) {
        this.inspectionReqId = inspectionReq.getId();
        this.inspectionDateTime = inspectionReq.getInspectionDateTime();
        this.moveInDate = inspectionReq.getMoveInDate();
        this.isDeletedByTenant = inspectionReq.getIsDeletedByTenant();
//        this.room = new RoomDto(inspectionReq.getRoom());
        InspectionReqStatus mostRecentStatus = inspectionReq.getInspectionReqStatuses()
                .stream()
                .max(Comparator.comparing(InspectionReqStatus::getCreatedDate))
                .orElse(null);
        InspectionReqStatusType inspectionReqStatusType = mostRecentStatus.getInspectionReqStatusType();
        this.memberReqStatusType = new MemberReqStatusTypeDto(inspectionReqStatusType);

        this.message = mostRecentStatus.getMessage();
    }
}
