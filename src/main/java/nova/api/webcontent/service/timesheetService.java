package nova.api.webcontent.service;

import nova.api.webcontent.entity.timesheetByCampaign;

import java.util.List;

public interface timesheetService {

    List<timesheetByCampaign> returnTimeSheet(String query);


}
