package com.traulko.task6.model.comparator;

import com.traulko.task6.model.entity.CustomBook;

import java.util.Comparator;

public class PagesCountComparator implements Comparator<CustomBook> {
    @Override
    public int compare(CustomBook book1, CustomBook book2) {
        if (book1.getPagesCount() == book2.getPagesCount()) {
            return 0;
        } else {
            return book1.getPagesCount() > book2.getPagesCount() ? 1 : -1;
        }
    }
}
