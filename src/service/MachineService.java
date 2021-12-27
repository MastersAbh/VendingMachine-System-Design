package service;

import datastore.MachineData;
import exceptions.DefaultException;
import models.Machine;
import models.Slot;

import java.util.List;

import static utils.ExceptionMessage.MACHINE_NOT_CREATED;

public class MachineService {
    // Singleton
    private Machine machine;
    private MachineData machineData;

    public MachineService() {
        this.machineData = new MachineData();
    }

    private Machine getInstance(final String id) {
        if (this.machine == null) {
            System.out.println("Creating Machine with id " + id);
            return new Machine(id);
        }
        System.out.println("Machine already exists");
        return this.machine;
    }

    public void createMachine(final String id) {
        this.machine = getInstance(id);
    }

    public void addSlot(final String id) throws DefaultException {
        if (this.machine != null) {
            this.machineData.addSlot(machine, id);
        } else {
            throw new DefaultException(MACHINE_NOT_CREATED);
        }
    }

    public void removeSlot(final String id) throws DefaultException {
        if (this.machine != null) {
            this.machineData.removeSlot(machine, id);
        } else {
            throw new DefaultException(MACHINE_NOT_CREATED);
        }
    }

    public List<Slot> getSlots() throws DefaultException {
        if (this.machine != null) {
            return this.machine.getSlots();
        } else {
            throw new DefaultException(MACHINE_NOT_CREATED);
        }
    }

}
