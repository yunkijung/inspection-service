package com.loglrs.inspectionservice.domain.inspection_req.entity;


import com.loglrs.inspectionservice.domain.inspection_req_status.entity.InspectionReqStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class InspectionReq {
    @Id
    @Column(name = "inspection_req_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime inspectionDateTime;
    private LocalDate moveInDate;
    private Boolean isDeletedByHost;
    private Boolean isDeletedByTenant;


    private Long roomId;

    private Long tenantId;

    @OneToMany(mappedBy = "inspectionReq", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<InspectionReqStatus> inspectionReqStatuses;

    public InspectionReq(LocalDateTime inspectionDateTime, LocalDate moveInDate, Boolean isDeletedByHost, Boolean isDeletedByTenant, Long roomId, Long tenantId) {
        this.inspectionDateTime = inspectionDateTime;
        this.moveInDate = moveInDate;
        this.isDeletedByHost = isDeletedByHost;
        this.isDeletedByTenant = isDeletedByTenant;
        this.roomId = roomId;
        this.tenantId = tenantId;
    }

    public void updateInspectionReqStatuses(List<InspectionReqStatus> inspectionReqStatuses) {
        this.inspectionReqStatuses = inspectionReqStatuses;
    }

    public void updateInspectionDateTime(LocalDateTime inspectionDateTime) {
        this.inspectionDateTime = inspectionDateTime;
    }

    public void updateIsDeletedByHost(Boolean isDeletedByHost) {
        this.isDeletedByHost = isDeletedByHost;
    }

    public void updateIsDeletedByTenant(Boolean isDeletedByTenant) {
        this.isDeletedByTenant = isDeletedByTenant;
    }
}
