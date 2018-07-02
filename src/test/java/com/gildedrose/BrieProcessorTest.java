package com.gildedrose;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BrieProcessorTest {

    @Test
    public void process_SellInPositive_decreasesSellInIncreasesQuality() throws Exception {
        Item item = new Item("Aged Brie", 10,10);
        BrieProcessor processor = new BrieProcessor(item);
        processor.process();
        assertEquals(9, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    public void process_SellInNegative_DecreasesSellInIncreasesQualityBy2 () throws Exception {
        Item item = new Item("Aged Brie", -1,10);
        BrieProcessor processor = new BrieProcessor(item);
        processor.process();
        assertEquals(-2, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    public void process_QualityNeverGoesOverFifty() {
        Item item = new Item("Aged Brie", 5, 50);
        BrieProcessor processor = new BrieProcessor(item);
        processor.process();
        assertEquals(50, item.quality);
    }
}
