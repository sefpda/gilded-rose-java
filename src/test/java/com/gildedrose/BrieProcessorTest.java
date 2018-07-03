package com.gildedrose;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(Enclosed.class)
public class BrieProcessorTest {

    public static class WhenSellInIsPositive {
        private Item item;
        private BrieProcessor processor;

        @Before
        public void setup() {
            item = new Item("Aged Brie", 10, 10);
            processor = new BrieProcessor(item);
        }

        @Test
        public void process_IncreasesQuality() throws Exception {
            processor.process();
            assertEquals(11, item.quality);
        }

        @Test
        public void process_decreasesSellIn() throws Exception {
            processor.process();
            assertEquals(9, item.sellIn);
        }

        @Test
        public void process_QualityNeverGoesOverFifty() {
            Item item = new Item("Aged Brie", 5, 50);
            BrieProcessor processor = new BrieProcessor(item);
            processor.process();
            assertEquals(50, item.quality);
        }


        @Test
        public void process_QualityNeverGoesBelowZero() {
            Item item = new Item("Aged Brie", 5, -3);
            BrieProcessor processor = new BrieProcessor(item);
            processor.process();
            assertEquals(1, item.quality);
        }

    }

    public static class WhenSellIn_IsNegative {

        private Item item;
        private BrieProcessor processor;

        @Before
        public void setUp() throws Exception {
            item = new Item("Aged Brie", -1, 10);
            processor = new BrieProcessor(item);
        }


        @Test
        public void process_DecreasesSellIn() throws Exception {
            processor.process();
            assertEquals(-2, item.sellIn);
        }

        @Test
        public void process_IncreasesQualityBy2() throws Exception {
            processor.process();
            assertEquals(12, item.quality);
        }

        @Test
        public void process_QualityNeverGoesOverFifty() {
            Item item = new Item("Aged Brie", -1, 49);
            BrieProcessor processor = new BrieProcessor(item);
            processor.process();
            assertEquals(50, item.quality);
        }
    }

    public static class CanProcessItem {

        @Test
        public void canProcess_ShouldBeTrue_ForAgedBrie() {
            Item item = new Item("Aged Brie", -1, 49);
            BrieProcessor processor = new BrieProcessor(item);
            assertEquals(true, processor.canProcess());
        }

        @Test
        public void canProcess_ShouldBeFalse_ForOtherItems() {
            Item item = new Item("Old Brie", -1, 49);
            BrieProcessor processor = new BrieProcessor(item);
            assertEquals(false, processor.canProcess());
        }
    }
}
