package com.gildedrose;

public class BackstagePassProcessor extends BaseItemProcessor {

    public BackstagePassProcessor(Item item) {
        super(item);
    }

    protected void updateQuality() {
        incrementQualityWithinLimit();
        if(item.sellIn <= 10){
            incrementQualityWithinLimit();
        }
        if(item.sellIn <= 5){
            incrementQualityWithinLimit();
        }
        if(item.sellIn <= 0){
            item.quality = 0;
        }
    }
}
