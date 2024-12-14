package main.java.com.gildedrose.Items;

public class ManaCake extends Item{
    public ManaCake(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.decreaseSellInValue();
        if (this.checkBiggerThanZero()){
            this.decreaseQualityTwice();
        }
    }

}

