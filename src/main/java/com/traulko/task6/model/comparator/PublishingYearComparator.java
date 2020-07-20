package com.traulko.task6.model.comparator;

import com.traulko.task6.model.entity.CustomBook;

import java.util.Comparator;

public class PublishingYearComparator implements Comparator<CustomBook> {
    @Override
    public int compare(CustomBook book1, CustomBook book2) {
        if (book1.getPublishingYear() == book2.getPublishingYear()) {
            return 0;
        } else {
            return book1.getPublishingYear() > book2.getPublishingYear() ? 1 : -1;
        }
    }
}
