package com.gildedrose;

public abstract class BaseItemProcessor {

    static final int MAX_QUALITY_LIMIT = 50;
    static final int MIN_QUALITY_LIMIT = 0;

    protected Item item;

    public BaseItemProcessor(Item item) {
        this.item = item;
    }

    public void process() {
        enforceQualityLimits();
        updateQuality();
        updateSellIn();
    }

    private void enforceQualityLimits() {
        if(item.quality < MIN_QUALITY_LIMIT) {
            item.quality = MIN_QUALITY_LIMIT;
        }
        if(item.quality > MAX_QUALITY_LIMIT) {
            item.quality = MAX_QUALITY_LIMIT;
        }
    }

    protected abstract void updateQuality();

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected void incrementQualityWithinLimit() {
        if(item.quality < MAX_QUALITY_LIMIT) {
            item.quality++;
        }
    }

    protected void decrementQualityBy(int amount){

        item.quality -= amount;

        if(item.quality < MIN_QUALITY_LIMIT) {
            item.quality = MIN_QUALITY_LIMIT;
        }
    }

    public boolean canProcess() {
        return false;
    };

    public void setItem(Item item) {
        this.item = item;
    }
}
