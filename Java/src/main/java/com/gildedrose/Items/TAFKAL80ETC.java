package main.java.com.gildedrose.Items;

public class TAFKAL80ETC extends Item{
    public TAFKAL80ETC(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.decreaseSellInValue();
        if (this.sellIn <= 10 && this.sellIn > 5){
            increaseQualityTwoTimes();
            fixThreshold();
        } else if (this.sellIn <= 5 && this.sellIn > 0){
            increaseQualityThreeTimes();
            fixThreshold();
        } else if (sellIn <= 0){
            this.quality = 0;
        } else {
            quality++;
            fixThreshold();
        }
    }

    public void fixThreshold(){
        if (this.quality > 50){
            this.quality = 50;
        }
    }

}
