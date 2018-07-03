package com.gildedrose;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SulfurasProcessorTest {

    @Test
    public void process_PositiveSellInAndQuality_AttributesNeverChange() throws Exception {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 4, 5);
        SulfurasProcessor processor = new SulfurasProcessor(item);
        processor.process();
        assertEquals(5, item.quality);
        assertEquals(4, item.sellIn);
    }
    @Test
    public void process_ZeroSellIn_AttributesNeverChange() throws Exception {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 8);
        SulfurasProcessor processor = new SulfurasProcessor(item);
        processor.process();
        assertEquals(8, item.quality);
        assertEquals(0, item.sellIn);
    }
    @Test
    public void process_ZeroQuality_AttributesNeverChange() throws Exception {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 9, 0);
        SulfurasProcessor processor = new SulfurasProcessor(item);
        processor.process();
        assertEquals(0, item.quality);
        assertEquals(9, item.sellIn);
    }
}