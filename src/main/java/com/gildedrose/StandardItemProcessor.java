package com.gildedrose;

public class StandardItemProcessor extends BaseItemProcessor {

    public StandardItemProcessor(Item item) {
        super(item);
    }

    protected void updateQuality() {
        decrementQualityBy(1);

        if (item.sellIn <= 0) {
            decrementQualityBy(1);
        }
    }

    @Override
    public boolean canProcess() {
        return true;
    }
}
