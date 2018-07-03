package com.gildedrose;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(Enclosed.class)
public class StandardItemProcessorTest {

    public static class WhenSellInPositive {
        private Item item;
        private StandardItemProcessor processor;

        @Before
        public void setUp() throws Exception {
            item = new Item("Some Item", 5, 12);
            processor = new StandardItemProcessor(item);
        }

        @Test
        public void process_decreasesQuality() throws Exception {
            processor.process();
            assertEquals(11, item.quality);
        }

        @Test
        public void process_decreasesSellIn() throws Exception {
            processor.process();
            assertEquals(4, item.sellIn);
        }
    }

    public static class WhenSellInNegative {
        private Item item;
        private StandardItemProcessor processor;


        @Before
        public void setUp() throws Exception {
            item = new Item("Some Item", -4, 8);
            processor = new StandardItemProcessor(item);
        }

        @Test
        public void process_decreasesSellIn() throws Exception {
            processor.process();
            assertEquals(-5, item.sellIn);
        }

        @Test
        public void process_decreasesQualityFaster() throws Exception {
            processor.process();
            assertEquals(6, item.quality);
        }


    }

    public static class MinQualityTests {

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


}
