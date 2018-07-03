package com.gildedrose;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConjuredItemProcessorTest {

    @Test
    public void updateQuality_shouldDegradeQualityByTwo_WhenSellInIsPositive() {
        Item item = new Item("Conjured whatever", 2, 10);
        ConjuredItemProcessor processor = new ConjuredItemProcessor(item);
        processor.process();
        assertEquals(8, item.quality);
    }

    @Test
    public void updateQuality_shouldDegradeQualityBy4_AfterSellIn() {
        Item item = new Item("Conjured thingy", 0, 10);
        ConjuredItemProcessor processor = new ConjuredItemProcessor(item);
        processor.process();
        assertEquals(6, item.quality);
    }

    @Test
    public void updateQuality_BeforeSellIn_ShouldNotDropQuality_BelowZero() {
        Item item = new Item("Conjured thingy", 2, 1);
        ConjuredItemProcessor processor = new ConjuredItemProcessor(item);
        processor.process();
        assertEquals(0, item.quality);
    }

    @Test
    public void updateQuality_AfterSellIn_ShouldNotDropQuality_BelowZero() {
        Item item = new Item("Conjured thingy", -1, 3);
        ConjuredItemProcessor processor = new ConjuredItemProcessor(item);
        processor.process();
        assertEquals(0, item.quality);
    }
}
