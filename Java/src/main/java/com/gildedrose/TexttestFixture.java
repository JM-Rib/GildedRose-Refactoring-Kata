package main.java.com.gildedrose;

import main.java.com.gildedrose.Items.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TexttestFixture {
    public static void main(String[] args) { //TODO should the backstage passes reach 0 in day 0, or the day after (-1)
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new DexterityVest("+5 Dexterity Vest", 2, 20), //
                new AgedBrieItem("Aged Brie", 2, 0), //should this increase in quality by 2 times when sellin has passed?
                new ElixirOTMongoose("Elixir of the Mongoose", 5, 7), //
                new HandOfRagnaros("Sulfuras, Hand of Ragnaros", 0, 80), //
                new HandOfRagnaros("Sulfuras, Hand of Ragnaros", 0, 80),
                new TAFKAL80ETC("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new TAFKAL80ETC("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new TAFKAL80ETC("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new ManaCake("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 8;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();

            // Validate item behaviors before updating quality
            for (Item item : items) {
                validateItemBeforeUpdate(item);
            }
            app.updateQuality();

            // Validate item behaviors after updating quality
            for (Item item : items) {
                validateItemAfterUpdate(item);
            }
        }
    }

    private static void validateItemBeforeUpdate(Item item) {
        if (item instanceof AgedBrieItem) {
            // Aged Brie should not exceed quality of 50
            assertTrue(item.quality <= 50);
        } else if (item instanceof HandOfRagnaros) {
            // Sulfuras should not change in quality or sellIn
            assertEquals(80, item.quality);
        } else if (item instanceof TAFKAL80ETC) {
            // Backstage passes' quality must remain <= 50 before update
            assertTrue(item.quality <= 50);
        } else if (!(item instanceof ManaCake)) {
            // General items cannot have negative quality
            assertTrue(item.quality >= 0);
        }
    }

    private static void validateItemAfterUpdate(Item item) {
        if (item instanceof AgedBrieItem) {
            // Aged Brie should improve in quality unless maxed
            assertTrue(item.quality <= 50);
        } else if (item instanceof HandOfRagnaros) {
            // Sulfuras should not change
            assertEquals(80, item.quality);
            //assertTrue(item.sellIn <= 0);
        } else if (item instanceof TAFKAL80ETC) {
            if (item.sellIn < 0) {
                // Backstage passes should drop to 0 quality after the concert
                assertEquals(0, item.quality);
            } else if (item.sellIn <= 5) {
                // Backstage passes quality increases by 3 when sellIn <= 5
                assertTrue(item.quality <= 50);
            } else if (item.sellIn <= 10) {
                // Backstage passes quality increases by 2 when 5 < sellIn <= 10
                assertTrue(item.quality <= 50);
            }
        } else if (!(item instanceof ManaCake)) {
            // General items cannot have negative quality
            assertTrue(item.quality >= 0);
        }
    }
}
