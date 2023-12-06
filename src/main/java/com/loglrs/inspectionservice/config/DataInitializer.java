package com.loglrs.inspectionservice.config;



import com.loglrs.inspectionservice.domain.inspection_req_status_type.entity.InspectionReqStatusType;
import com.loglrs.inspectionservice.domain.inspection_req_status_type.repository.InspectionReqStatusTypeRepository;
import com.loglrs.inspectionservice.domain.inspection_req_status_type.type.ReqStatusType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(
            InspectionReqStatusTypeRepository inspectionReqStatusTypeRepository
    ) {
        return args -> {

            if (inspectionReqStatusTypeRepository.count() == 0) {
                InspectionReqStatusType type1 = new InspectionReqStatusType(
                        ReqStatusType.INIT_BY_TENANT
                        , true
                        , true
                        , true
                        , false
                        , false
                        , true
                        , false
                        , true
                        , false
                        , false);

                InspectionReqStatusType type2 = new InspectionReqStatusType(
                        ReqStatusType.REJECTED_BY_HOST
                        , false
                        , false
                        , false
                        , false
                        , true
                        , false
                        , false
                        , false
                        , false
                        , true);

                InspectionReqStatusType type3 = new InspectionReqStatusType(
                        ReqStatusType.UPDATED_BY_HOST
                        , true
                        , true
                        , false
                        , false
                        , false
                        , false
                        , true
                        , true
                        , true
                        , false);

                InspectionReqStatusType type4 = new InspectionReqStatusType(
                        ReqStatusType.ACCEPTED_BY_HOST
                        , true
                        , true
                        , false
                        , false
                        , false
                        , false
                        , true
                        , true
                        , true
                        , false);

                InspectionReqStatusType type5 = new InspectionReqStatusType(
                        ReqStatusType.CANCELED_BY_HOST
                        , false
                        , false
                        , false
                        , false
                        , true
                        , false
                        , false
                        , false
                        , false
                        , true);


                InspectionReqStatusType type6 = new InspectionReqStatusType(
                        ReqStatusType.CANCELED_BY_TENANT
                        , false
                        , false
                        , false
                        , false
                        , true
                        , false
                        , false
                        , false
                        , false
                        , true);

                InspectionReqStatusType type7 = new InspectionReqStatusType(
                        ReqStatusType.REJECTED_BY_TENANT
                        , false
                        , false
                        , false
                        , false
                        , true
                        , false
                        , false
                        , false
                        , false
                        , true);

                InspectionReqStatusType type8 = new InspectionReqStatusType(
                        ReqStatusType.UPDATED_BY_TENANT
                        , true
                        , true
                        , true
                        , false
                        , false
                        , true
                        , false
                        , true
                        , false
                        , false);

                InspectionReqStatusType type9 = new InspectionReqStatusType(
                        ReqStatusType.CONFIRMED_BY_TENANT
                        , false
                        , false
                        , false
                        , true
                        , false
                        , true
                        , false
                        , false
                        , false
                        , false);


                inspectionReqStatusTypeRepository.save(type1);
                inspectionReqStatusTypeRepository.save(type2);
                inspectionReqStatusTypeRepository.save(type3);
                inspectionReqStatusTypeRepository.save(type4);
                inspectionReqStatusTypeRepository.save(type5);
                inspectionReqStatusTypeRepository.save(type6);
                inspectionReqStatusTypeRepository.save(type7);
                inspectionReqStatusTypeRepository.save(type8);
                inspectionReqStatusTypeRepository.save(type9);

            }



        };
    }
}
