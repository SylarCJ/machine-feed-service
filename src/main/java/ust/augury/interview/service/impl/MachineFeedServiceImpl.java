package ust.augury.interview.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ust.augury.interview.exception.MachineNotFoundException;
import ust.augury.interview.service.MachineFeedService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MachineFeedServiceImpl implements MachineFeedService {
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * @param machineId
     * @return
     */
    @Override
    public Map<String, Object> getMachineFeedById(String machineId) {

        String machineServiceUrl = "http://localhost:8081/machines/" + machineId;
        String repairsServiceUrl = "http://localhost:8082/repairs/machine/" + machineId;
        String sessionsServiceUrl = "http://localhost:8083/sessions/machine/" + machineId;

        Map<String, Object> machine = restTemplate.getForObject(machineServiceUrl, Map.class);
        List<Map<String, Object>> repairs = restTemplate.getForObject(repairsServiceUrl, List.class);
        List<Map<String, Object>> sessions = restTemplate.getForObject(sessionsServiceUrl, List.class);

        Map<String, Object> machineFeedMap = new HashMap<>();
        machineFeedMap.put("machine", machine);
        machineFeedMap.put("repairs", repairs);
        machineFeedMap.put("sessions", sessions);

        if (machine == null) {
            throw new MachineNotFoundException("Machine not found with ID: " + machineId);
        }

        return machineFeedMap;
    }
}
