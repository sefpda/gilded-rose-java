package com.gildedrose;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StandardItemProcessorTest {

    @Test
    public void process_SellInPositive_decreasesQualityAndSellIn() throws Exception {
        Item item = new Item("Item", 5, 12);
        StandardItemProcessor processor = new StandardItemProcessor(item);
        processor.process();
        assertEquals(4, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    public void process_SellInNegative_decreasesQualityFaster() throws Exception {
        Item item = new Item("Item", -4, 8);
        StandardItemProcessor processor = new StandardItemProcessor(item);
        processor.process();
        assertEquals(-5, item.sellIn);
        assertEquals(6, item.quality);
    }

    @Test
    public void process_SellInPositive_MinQualityIsZero() throws Exception {
        Item item = new Item("Item", 2, 0);
        StandardItemProcessor processor = new StandardItemProcessor(item);
        processor.process();
        assertEquals(1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void process_SellInNegative_MinQualityIsZero() throws Exception {
        Item item = new Item("Item", -2, 1);
        StandardItemProcessor processor = new StandardItemProcessor(item);
        processor.process();
        assertEquals(-3, item.sellIn);
        assertEquals(0, item.quality);
    }


}
