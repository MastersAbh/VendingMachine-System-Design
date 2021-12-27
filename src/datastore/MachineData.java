package datastore;

import exceptions.DefaultException;
import models.Machine;
import models.Slot;

import java.util.HashMap;
import java.util.Map;

import static utils.ExceptionMessage.SLOT_ALREADY_EXISTS;
import static utils.ExceptionMessage.SLOT_DOESNT_EXISTS;

public class MachineData {
    private Map<String, Slot> slotIdToSlotMap;

    public MachineData() {
        this.slotIdToSlotMap = new HashMap<>();
    }

    public void addSlot(final Machine machine, final String slotId) throws DefaultException {
        if (doesSlotExist(slotId)) {
            throw new DefaultException(SLOT_ALREADY_EXISTS);
        }
        System.out.println("Adding Slot " + slotId);
        final Slot slot = new Slot(slotId);
        machine.getSlots().add(slot);
        slotIdToSlotMap.put(slotId, slot);
    }

    public void removeSlot(final Machine machine, final String slotId) throws DefaultException {
        if (!doesSlotExist(slotId)) {
            throw new DefaultException(SLOT_DOESNT_EXISTS);
        }
        System.out.println("Removing slot " + slotId);
        final Slot slot = slotIdToSlotMap.get(slotId);
        machine.getSlots().remove(slot);
        slotIdToSlotMap.remove(slotId);
    }

    public Slot getSlot(final String slotId) throws DefaultException {
        if (!doesSlotExist(slotId)) {
            throw new DefaultException(SLOT_DOESNT_EXISTS);
        }
        return slotIdToSlotMap.get(slotId);
    }

    public boolean doesSlotExist(final String slotId) {
        return slotIdToSlotMap.containsKey(slotId);
    }
}
