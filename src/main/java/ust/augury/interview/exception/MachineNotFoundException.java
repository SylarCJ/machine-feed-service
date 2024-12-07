package ust.augury.interview.exception;

public class MachineNotFoundException extends RuntimeException {
    public MachineNotFoundException(String machineId) {
        super("Machine not found for ID: " + machineId);
    }
}
