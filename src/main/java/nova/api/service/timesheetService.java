package nova.api.service;

import nova.api.entity.timesheetByCampaign;

import java.util.List;

public interface timesheetService {

    List<timesheetByCampaign> returnTimeSheet(String query);


}
