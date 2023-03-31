package nova.api.webcontent.controller;

import nova.api.webcontent.entity.timesheetByCampaign;
import nova.api.webcontent.service.timesheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/timesheet")

public class timesheetByCampaignController {
    private timesheetService timesheetService;

    public timesheetByCampaignController(nova.api.webcontent.service.timesheetService timesheetService) {

        this.timesheetService = timesheetService;
    }
    @CrossOrigin("http://localhost:8080")
    @GetMapping ("/campaign")
    public ResponseEntity<List<timesheetByCampaign>> returnTimesheet(@RequestParam("query") String query) {
        return ResponseEntity.ok(timesheetService.returnTimeSheet(query));
    }
}
