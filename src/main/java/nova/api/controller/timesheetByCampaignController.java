package nova.api.controller;

import nova.api.entity.timesheetByCampaign;
import nova.api.service.timesheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/timesheet")

public class timesheetByCampaignController {
    private timesheetService timesheetService;

    public timesheetByCampaignController(nova.api.service.timesheetService timesheetService) {

        this.timesheetService = timesheetService;
    }
    @GetMapping ("/campaign")
    public ResponseEntity<List<timesheetByCampaign>> returnTimesheet(@RequestParam("query") String query) {
        return ResponseEntity.ok(timesheetService.returnTimeSheet(query));
    }
}
