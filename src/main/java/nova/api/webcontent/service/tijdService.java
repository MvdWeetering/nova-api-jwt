package nova.api.webcontent.service;

import nova.api.webcontent.entity.Tijd;
import nova.api.webcontent.helper.DateTimeCalculations;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

@Service
public class tijdService {

    public String berekentijd(Tijd tijd) {

        return  DateTimeCalculations.ReadMissionTime(tijd.getLokaletijd(), ZoneId.of(tijd.getTijdzone()));
    }
}
