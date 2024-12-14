package main.java.com.gildedrose.Items;

public class DexterityVest extends Item{
    public DexterityVest(String name, int sellIn, int quality) {
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
    }

    public void updateSellInValue(){
        this.decreaseSellInValue();
    }
}
