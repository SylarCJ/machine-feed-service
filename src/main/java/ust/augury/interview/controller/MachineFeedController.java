package ust.augury.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ust.augury.interview.service.MachineFeedService;

import java.util.Map;

@RestController
@RequestMapping("/machine-feeds")
public class MachineFeedController {

    MachineFeedService machineFeedService;

    @Autowired
    public MachineFeedController(MachineFeedService machineFeedService) {
        this.machineFeedService = machineFeedService;
    }

    @GetMapping("/{machineId}")
    public ResponseEntity<Map<String, Object>> getMachineFeeds(@PathVariable String machineId) {
        return ResponseEntity.ok(machineFeedService.getMachineFeedById(machineId));
    }
}
