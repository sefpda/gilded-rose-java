package com.gildedrose;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GildedRoseTest {


    // Name tests
    @Test
    public void WhenUpdateQualityCalled_ItemName_DoesNotChange() throws Exception {
        Item items[] = new Item[] {
                new Item("PastSellIn", 0, 4)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("PastSellIn", items[0].name);
    }

    // Quality tests
    @Test
    public void WhenUpdateQualityCalled_Quality_GoesDownByOne() throws Exception {
        Item items[] = new Item[] {
                new Item("PreSellIn", 4, 4)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalledAndPastSellinDate_QualityGoesDownByTwo() throws Exception {
        Item items[] = new Item[] {
                new Item("PastSellIn", 0, 4),
                new Item("PastSellIn2", 0, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, items[0].quality);
        assertEquals(0, items[1].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_ZeroQualityItem_DoesNotDecrease() throws Exception {
        Item items[] = new Item[] {
                new Item("PreSellInZeroQualityItem", 4, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_QualityZero_QualityNotNegative() throws Exception {
        Item items[] = new Item[] {
                new Item("PostSellInZeroQualityItem", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_Brie_IncreasesQuality() {
        Item items[] = new Item[] {
                new Item("Aged Brie", 10, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_BriePastSelIn_QualityIncreasesByTwo() {
        Item items[] = new Item[] {
                new Item("Aged Brie", -1, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_QualityOver50_Not51() {
        Item items[] = new Item[] {
                new Item("Aged Brie", 10, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
        assertEquals(50, items[1].quality);
        assertEquals(50, items[2].quality);
    }

    // SellIn tests
    @Test
    public void WhenUpdateQualityCalled_SellIn_GoesDownByOne() throws Exception {
        Item items[] = new Item[] {
                new Item("PreSellIn", 4, 4),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 4),
                new Item("Aged Brie", 10, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, items[0].sellIn);
        assertEquals(3, items[1].sellIn);
        assertEquals(9, items[2].sellIn);
    }

    @Test
    public void WhenUpdateQualityCalled_SellInZero_SellInDecreases() throws Exception {
        Item items[] = new Item[] {
                new Item("PostSellInZeroQualityItem", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
    }
    @Test
    public void WhenUpdateQualityCalled_SellInZero_QualityDecreasesByTwo() throws Exception {
        Item items[] = new Item[] {
                new Item("PostSellInZeroQualityItem", 0, 2)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }
    // Sulfuras tests

    @Test
    public void WhenUpdateQualityCalled_Sulfuras_AttributesNeverChange() throws Exception {
        Item items[] = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 4, 5),
                new Item("Sulfuras, Hand of Ragnaros", 0, 8),
                new Item("Sulfuras, Hand of Ragnaros", 9, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, items[0].quality);
        assertEquals(4, items[0].sellIn);
        assertEquals(8, items[1].quality);
        assertEquals(0, items[1].sellIn);
        assertEquals(0, items[2].quality);
        assertEquals(9, items[2].sellIn);
    }

    // Backstage Passes

    @Test
    public void WhenUpdateQualityCalled_AndSellInIsGreaterThanTen_BackstagePass_IncreaseQualityByOne() throws Exception {
        Item items[] = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 8)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_AndSellInIsTenOrLess_BackstagePass_IncreaseQualityByTwo() throws Exception {
        Item items[] = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 8)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_AndSellInIsFiveOrLess_BackstagePass_IncreaseQualityByThree() throws Exception {
        Item items[] = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 8)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
    }

    @Test
    public void WhenUpdateQualityCalled_WhenSellInIsZeroOrLess_BackstagePass_QualityIsZero() throws Exception {
        Item items[] = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 8)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }


    // Conjured Item tests

    @Test
    public void WhenUpdateCalled_WithAConjuredItem_ItDegradeQualityFaster() {
        Item items[] = new Item[] {
                new Item("Conjured Mana Cake", 2, 8)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, items[0].quality);
    }

    @Test
    public void ProcessorFactory_WithAConjuredItem_BuildsAConjuredItemProcessor() {
        Item item = new Item("Conjured Mana Cake", 2, 8);
        GildedRose app = new GildedRose(new Item[]{});
        BaseItemProcessor processor = app.buildProcessorFor(item);
        assertTrue(processor instanceof ConjuredItemProcessor);
    }
}