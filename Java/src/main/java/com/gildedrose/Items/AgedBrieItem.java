package main.java.com.gildedrose.Items;

public class AgedBrieItem extends Item {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.decreaseSellInValue();
        this.quality++;
        fixThreshold();
    }

    public void fixThreshold(){
        if (this.quality > 50){
            this.quality = 50;
        }
    }
}
