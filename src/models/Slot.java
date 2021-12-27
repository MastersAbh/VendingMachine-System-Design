package models;

public class Slot {

    private String id;
    private Item item;

    public Slot(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void freeItem() {
        this.item = null;
    }
}
