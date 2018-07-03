package com.gildedrose;

public class BrieProcessor extends BaseItemProcessor {

    public BrieProcessor(Item item) {
        super(item);
    }

    protected void updateQuality() {
        incrementQualityWithinLimit();
        if(item.sellIn < 0) {
            incrementQualityWithinLimit();
        }
    }

}
