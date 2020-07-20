package com.traulko.task6.model.comparator;

import com.traulko.task6.model.entity.CustomBook;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AuthorComparator implements Comparator<CustomBook> {
    @Override
    public int compare(CustomBook book1, CustomBook book2) {
        List<String> authors1 = book1.getAuthors();
        List<String> authors2 = book2.getAuthors();
        Collections.sort(authors1);
        Collections.sort(authors2);
        Iterator<String> iterator1 = authors1.iterator();
        Iterator<String> iterator2 = authors2.iterator();
        while (iterator1.hasNext()) {
            String author1 = iterator1.next();
            String author2 = iterator2.next();
            if (author1.compareTo(author2) != 0) {
                return author1.compareTo(author2);
            }
        }
        return 0;
    }
}
