package main.java.com.gildedrose.Items;

public class ElixirOTMongoose extends Item{
    public ElixirOTMongoose(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.decreaseSellInValue();
        if (this.checkBiggerThanZero()){
            this.decreaseQuality();
        } else if (this.sellInExpiredDatePassed()){
            this.decreaseQualityTwice();
        }
        fixThreshold();
    }
    public void fixThreshold(){
        if (this.quality < 0){
            this.quality = 0;
        }
    }
}
