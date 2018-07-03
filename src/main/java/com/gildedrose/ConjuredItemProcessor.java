package com.gildedrose;

public class ConjuredItemProcessor extends BaseItemProcessor {
    public ConjuredItemProcessor(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decrementQualityBy(2);
        if(item.sellIn <= 0) {
            decrementQualityBy(2);
        }
    }

    @Override
    public boolean canProcess() {
        return item.name.startsWith("Conjured");
    }
}