package nova.api.webcontent.repository;

import nova.api.webcontent.entity.timesheetByCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<timesheetByCampaign, Long> {

    @Query(value = """
SELECT tbl_timesheet.id, tbl_campaign.campaign_name, tbl_mission.mission_name, tbl_user.UserName, tbl_timesheet.time_total 
FROM csar.tbl_user INNER JOIN (((csar.tbl_campaign INNER JOIN csar.tbl_mission ON csar.tbl_campaign.Id = csar.tbl_mission.fk_campaign_id) 
INNER JOIN csar.tbl_entity ON csar.tbl_mission.Id = csar.tbl_entity.fk_mission_id) 
INNER JOIN csar.tbl_timesheet ON (csar.tbl_entity.Id = csar.tbl_timesheet.fk_entity_id) 
AND (csar.tbl_entity.Id = csar.tbl_timesheet.fk_entity_id)) ON (csar.tbl_user.Id = tbl_timesheet.fk_user_id) 
AND (csar.tbl_user.Id = csar.tbl_timesheet.fk_user_id) WHERE (((tbl_campaign.campaign_name)= :query )) """, nativeQuery=true)

    List<timesheetByCampaign> returnTimesheet(String query);

}
