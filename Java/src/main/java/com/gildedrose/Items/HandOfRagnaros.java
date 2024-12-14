package main.java.com.gildedrose.Items;

public class HandOfRagnaros extends Item{
    public HandOfRagnaros(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() { //take this out because the item doesnt change
    }
}
