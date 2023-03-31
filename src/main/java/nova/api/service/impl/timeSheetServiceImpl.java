package nova.api.service.impl;

import nova.api.entity.timesheetByCampaign;
import nova.api.repository.TimesheetRepository;
import nova.api.service.timesheetService;
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
