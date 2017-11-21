package model;

import java.util.List;

public class PartitionList<T> {
    private List<T> items;
    private int totalItems;
    private int currentPage;
    private int totalPages;

    public PartitionList(List<T> allItems, int itemsOnPage, int requestedPage) {
        int totalPages = (int) Math.ceil(allItems.size() / (double) itemsOnPage);

        if (requestedPage < 1 || requestedPage > totalPages) {
            requestedPage = 1;
        }

        int fromIndex = (requestedPage - 1) * itemsOnPage;
        int toIndex = Math.min(requestedPage * itemsOnPage, allItems.size());
        this.items = allItems.subList(fromIndex, toIndex);
        this.totalItems = allItems.size();
        this.currentPage = requestedPage;
        this.totalPages = totalPages;
    }

    public List<T> getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
