package com.loglrs.inspectionservice.api.inspection_req.dto.update_inspection_req;

import lombok.Data;

@Data
public class InspectionReqUpdateForm {
    private Long inspectionReqId;
    private Boolean isDeletedByHost;
    private Boolean isDeletedByTenant;
}
