package nova.api.webcontent.service.impl;

import nova.api.webcontent.entity.timesheetByCampaign;
import nova.api.webcontent.repository.TimesheetRepository;
import nova.api.webcontent.service.timesheetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class timeSheetServiceImpl implements timesheetService {
    public timeSheetServiceImpl(TimesheetRepository timesheetRepository) {

        this.timesheetRepository = timesheetRepository;
    }

    private TimesheetRepository timesheetRepository;

    @Override
    public List<timesheetByCampaign> returnTimeSheet(String query) {
        List<timesheetByCampaign> timesheet = timesheetRepository.returnTimesheet(query);
        return timesheet;
    }
}
