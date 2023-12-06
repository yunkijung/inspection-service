package com.loglrs.inspectionservice.api.inspection_req.dto.get_inspection_reqs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TenantInfoDto {
    private String gender;
    private String nationality;
    private String race;
    private String occupation;
    private String religion;
    private String name;
    private String age;
}
