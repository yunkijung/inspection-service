package com.loglrs.inspectionservice.api.inspection_req.dto.create_inspection_req;


import com.loglrs.inspectionservice.domain.inspection_req_status_type.type.ReqStatusType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InspectionReqForm {
    private LocalDateTime inspectionDateTime;
    private LocalDate moveInDate;
    private Long roomId;
    private ReqStatusType reqStatusType;
    private String message;
}
