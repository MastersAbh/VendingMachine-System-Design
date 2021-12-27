package datastore;

import exceptions.DefaultException;
import models.Item;
import models.Slot;

import java.util.HashMap;
import java.util.Map;

import static utils.ExceptionMessage.*;

public class InventoryData {
    private Map<String, Item> itemIdToItemMap;
    private MachineData machineData;

    public InventoryData() {
        itemIdToItemMap = new HashMap<>();
        machineData = new MachineData();
    }

    public void addItemToSlot(final String slotId, final Item item) throws DefaultException {
        if (!machineData.doesSlotExist(slotId)) {
            throw new DefaultException(SLOT_DOESNT_EXISTS);
        }
        Slot slot = machineData.getSlot(slotId);
        if (slot.getItem() != null) {
            throw new DefaultException(SLOT_OCCUPIED);
        }
        slot.setItem(item);
    }

    public void removeItemFromSlot(final String slotId) throws DefaultException {
        if (!machineData.doesSlotExist(slotId)) {
            throw new DefaultException(SLOT_DOESNT_EXISTS);
        }
        Slot slot = machineData.getSlot(slotId);
        if (slot.getItem() == null) {
            throw new DefaultException(SLOT_UNOCCUPIED);
        }
        slot.freeItem();
    }
}
