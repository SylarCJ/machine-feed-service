package ust.augury.interview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ust.augury.interview.service.impl.MachineFeedServiceImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MachineFeedServiceApplicationTests {

    private final MachineFeedServiceImpl service;

    public MachineFeedServiceApplicationTests() {
        this.service = new MachineFeedServiceImpl();
    }

    @Test
    void testGetMachineFeedById() {
        Map<String, Object> machineFeedMap = service.getMachineFeedById("5f54dd217546020001758b7b");

        assertNotNull(machineFeedMap);
        assertTrue(machineFeedMap.get("machines").toString().contains("5f54dd217546020001758b7b"));
    }

}
