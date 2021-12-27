package models;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private String id;
    private List<Slot> slots;

    public Machine(String id) {
        this.id = id;
        this.slots = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
