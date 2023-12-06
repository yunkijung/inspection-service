package com.loglrs.inspectionservice.api.inspection_req.controller;


import com.loglrs.inspectionservice.api.inspection_req.dto.create_inspection_req.InspectionReqForm;
import com.loglrs.inspectionservice.api.inspection_req.dto.create_inspection_req_status.InspectionReqStatusForm;
import com.loglrs.inspectionservice.api.inspection_req.dto.get_inspection_reqs.BusinessInspectionReqResponseDto;
import com.loglrs.inspectionservice.api.inspection_req.dto.inspection_req.MemberInspectionReqResponseDto;
import com.loglrs.inspectionservice.api.inspection_req.dto.update_inspection_req.InspectionReqUpdateForm;
import com.loglrs.inspectionservice.domain.component_service.inspection_req.service.InspectionReqComponentService;
import com.loglrs.inspectionservice.domain.inspection_req.entity.InspectionReq;
import com.loglrs.inspectionservice.domain.inspection_req.service.InspectionReqService;
import com.loglrs.inspectionservice.security.jwt.util.IfLogin;
import com.loglrs.inspectionservice.security.jwt.util.LoginUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/inspection-req")
public class InspectionReqController {
    private final InspectionReqComponentService inspectionReqComponentService;
    private final InspectionReqService inspectionReqService;
    @PostMapping
    public ResponseEntity createInspectionReq(@IfLogin LoginUserDto loginUserDto, @RequestBody @Valid InspectionReqForm inspectionReqForm, BindingResult bindingResult) {
        log.info("time: {}", inspectionReqForm.getInspectionDateTime());
        inspectionReqComponentService.createInspectionReq(inspectionReqForm.getInspectionDateTime(), inspectionReqForm.getMoveInDate(), false, false, inspectionReqForm.getRoomId(), loginUserDto.getMemberId(), inspectionReqForm.getReqStatusType(), inspectionReqForm.getMessage());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity createInspectionReqStatus(@IfLogin LoginUserDto loginUserDto, @RequestBody @Valid InspectionReqStatusForm inspectionReqStatusForm, BindingResult bindingResult) {

        inspectionReqComponentService.createInspectionReqStatus(
                inspectionReqStatusForm.getInspectionReqId()
                , inspectionReqStatusForm.getInspectionDateTime()
                , inspectionReqStatusForm.getReqStatusType()
                , inspectionReqStatusForm.getMessage()
                );

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateInspectionReq(@IfLogin LoginUserDto loginUserDto, @RequestBody InspectionReqUpdateForm inspectionReqUpdateForm) {
        inspectionReqComponentService.updateInspectionReq(
                inspectionReqUpdateForm.getInspectionReqId()
                , inspectionReqUpdateForm.getIsDeletedByHost()
                , inspectionReqUpdateForm.getIsDeletedByTenant()
        );

        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getMyInspectionReqs(@IfLogin LoginUserDto loginUserDto) {
        Long memberId = loginUserDto.getMemberId();
        List<InspectionReq> inspectionReqs = inspectionReqService.findByMemberId(memberId);

        List<MemberInspectionReqResponseDto> inspectionReqResponseDtos = new ArrayList<>();

        for (InspectionReq inspectionReq : inspectionReqs) {
            inspectionReqResponseDtos.add(new MemberInspectionReqResponseDto(inspectionReq));
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("inspectionReqList", inspectionReqResponseDtos);

        return new ResponseEntity(resultMap, HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity getInspectionReqs(@PathVariable(name = "roomId") Long roomId) {

        List<InspectionReq> inspectionReqs = inspectionReqService.findByRoomId(roomId);

        List<BusinessInspectionReqResponseDto> inspectionReqResponseDtos = new ArrayList<>();

        for (InspectionReq inspectionReq : inspectionReqs) {
            inspectionReqResponseDtos.add(new BusinessInspectionReqResponseDto(inspectionReq));
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("inspectionReqList", inspectionReqResponseDtos);

        return new ResponseEntity(resultMap, HttpStatus.OK);
    }

}
