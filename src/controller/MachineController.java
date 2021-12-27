package controller;

import exceptions.DefaultException;
import models.Slot;
import service.MachineService;

import java.util.List;

public class MachineController {

    private MachineService machineService;

    public MachineController() {
        this.machineService = new MachineService();
    }

    public void createMachine(final String id) {
        this.machineService.createMachine(id);
    }

    public void addSlot(final String slotId) {
        try {
            this.machineService.addSlot(slotId);
        } catch (DefaultException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeSlot(final String slotId) {
        try {
            this.machineService.removeSlot(slotId);
        } catch (DefaultException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllSlots() {
        List<Slot> slots = null;
        try {
            slots = this.machineService.getSlots();
            for (Slot slot : slots) {
                System.out.print(slot.getId());
                if (slot.getItem() != null) {
                    System.out.println(" has item " + slot.getItem().getId());
                }
                System.out.println();
            }
        } catch (DefaultException e) {
            System.out.println(e.getMessage());
        }
    }
}
