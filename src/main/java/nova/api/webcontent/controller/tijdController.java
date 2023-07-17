package nova.api.webcontent.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import nova.api.webcontent.entity.Tijd;
import nova.api.webcontent.service.tijdService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class tijdController {

    @Autowired
    private tijdService tijdService;

    @PostMapping("/tijdservice")
    public String postDetails(@RequestBody Tijd tijd) {
        return tijdService.berekentijd(tijd);
    }
}
