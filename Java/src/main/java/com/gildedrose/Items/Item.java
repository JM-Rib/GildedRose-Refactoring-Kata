package main.java.com.gildedrose.Items;

public abstract class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn; //number of days we have to sell the item
        this.quality = quality; //value which denotes how valuable the item is
    }  //At the end of each day our system lowers both values for every item

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public boolean checkBiggerThanZero(){
        return this.sellIn >= 0;
    }

    public boolean sellInExpiredDatePassed(){ //Not sure if it is necessary to have this method
        return this.sellIn < 0;
    }
    public abstract void updateQuality(); //sell-in will be overwritten
    public void increaseQualityTwoTimes(){
        this.quality++;
        this.quality++;
    }
    public void increaseQualityThreeTimes(){
        this.quality++;
        this.quality++;
        this.quality++;
    }

    public void decreaseQualityTwice(){
        this.quality--;
        this.quality--;
    }

    public void decreaseQuality(){
        this.quality--;
    }

    public void decreaseSellInValue(){
        this.sellIn--;
    }
}
