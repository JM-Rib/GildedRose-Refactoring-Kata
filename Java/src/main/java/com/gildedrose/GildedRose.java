package main.java.com.gildedrose;

import main.java.com.gildedrose.Items.Item;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    } //Itens do alojamento - Array - maybe switch to list

    public void updateQuality() {
        for (int i = 0; i < items.length; i++){
            items[i].updateQuality();
        }
    }
}
