package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

public class BackstagePassProcessorTest {


    @Test
    public void WhenUpdateQualityCalled_AndSellInIsGreaterThanTen_BackstagePass_IncreaseQualityByOne() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 8);
        BackstagePassProcessor processor = new BackstagePassProcessor(item);
        processor.process();
        assertEquals(9, item.quality);
    }

    @Test
    public void WhenUpdateQualityCalled_AndSellInIsTenOrLess_BackstagePass_IncreaseQualityByTwo() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 8);

        BackstagePassProcessor processor = new BackstagePassProcessor(item);
        processor.process();
        assertEquals(10, item.quality);
    }

    @Test
    public void WhenUpdateQualityCalled_AndSellInIsFiveOrLess_BackstagePass_IncreaseQualityByThree() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 8);

        BackstagePassProcessor processor = new BackstagePassProcessor(item);
        processor.process();
        assertEquals(11, item.quality);
    }

    @Test
    public void WhenUpdateQualityCalled_WhenSellInIsZeroOrLess_BackstagePass_QualityIsZero() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 8);
        BackstagePassProcessor processor = new BackstagePassProcessor(item);
        processor.process();
        assertEquals(0, item.quality);
    }

    @Test
    public void canProcess_ShouldBeTrue_WhenNameStartsWith_BackstagePass() {
        Item item = new Item("Backstage passes to some concert", -1, 49);
        BackstagePassProcessor processor = new BackstagePassProcessor(item);
        assertEquals(true, processor.canProcess());
    }

    @Test
    public void canProcess_ShouldBeFalse_ForAnyOtherItem() {
        Item item = new Item("Old Brie", -1, 49);
        BackstagePassProcessor processor = new BackstagePassProcessor(item);
        assertEquals(false, processor.canProcess());
    }
}
