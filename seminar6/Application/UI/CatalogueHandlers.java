package Application.UI;

import Application.BusinessLogic.Catalogue;
import Application.Classes.Laptop;

import java.util.*;

public class CatalogueHandlers {
    private Catalogue catalogue;
    private List<Laptop> articles;
    private FilterHandlers filters;
    private Map<Laptop, Integer> currentPage;
    private Integer itemsAtATime;
    private Integer firstIndexOfPage;
    private Integer lastIndexOfPage;
    private Map<Integer, String> menu;

    public CatalogueHandlers(Integer dataBaseSize) {
        this.catalogue = new Catalogue(dataBaseSize);
        this.setArticles();
        this.itemsAtATime = 10;


        this.setMenu();
        this.setIndexesOfPage(0);
    }

    public void setArticles() {
        this.articles = new ArrayList<>(this.catalogue.getArticles());
    }

    public Integer handler() {
        int exitCode = 400;

        this.fillCurrentPage();
        this.showCurrentPage();
        this.showMenu();

        System.out.printf("\n%s", ">>> ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1: {
                this.setCurrentPage();
                this.showCurrentPage();
                break;
            }
            case 2: {
                this.setItemsAtATime();
                exitCode = 100;
                break;
            }
            case 3: {
                if (this.filters == null) {
                    this.filters = new FilterHandlers(this.catalogue);
                }
                exitCode = this.filters.handler();
                this.setIndexesOfPage(0);
                this.setArticles();
                break;
            }
            case 4: {
                this.setIndexesOfPage(this.firstIndexOfPage + this.itemsAtATime);
                this.fillCurrentPage();
                this.showCurrentPage();
                exitCode = 100;
                break;
            }
            case 5: {
                this.setIndexesOfPage(this.firstIndexOfPage - this.itemsAtATime);
                this.fillCurrentPage();
                this.showCurrentPage();
                exitCode = 100;
                break;
            }
            case 6: {
                exitCode = 205;
                break;
            }
            case 7: {
                exitCode = 200;
                break;
            }
            default: {
                exitCode = 404;
            }
        }
        return exitCode;
    }

    private void setMenu() {
        this.menu = new HashMap<>();
        this.menu.put(1, "Set current page (...)");
        this.menu.put(2, String.format("Set number of items to show at a time (%d)", this.itemsAtATime));
        this.menu.put(3, "Filtering");
        this.menu.put(4, "Next page");
        this.menu.put(5, "Previous page");
        this.menu.put(6, "Go back");
        this.menu.put(7, "Exit");
    }

    private void showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> row :
                this.menu.entrySet()) {
            stringBuilder.append(String.format("\n%d. %s", row.getKey(), row.getValue()));
        }
        System.out.println(stringBuilder);
    }

    private void fillCurrentPage() {
        Map<Laptop, Integer> temp = this.catalogue.getCatalogue();
        this.currentPage = new HashMap<>();
        for (int i = firstIndexOfPage; i <= lastIndexOfPage; i++) {
            this.currentPage.put(this.articles.get(i), temp.get(this.articles.get(i)));
        }
    }

    private void showCurrentPage() {
        StringBuilder stringBuilder = new StringBuilder();
        int increment = this.firstIndexOfPage + 1;
        for (Map.Entry<Laptop, Integer> item :
                this.currentPage.entrySet()) {
            stringBuilder.append(String.format("\n%d) %s – %d.00 RUB", increment++, item.getKey(), item.getValue()));
        }
        System.out.println(stringBuilder);
    }

    private void setCurrentPage() {
        int numberOfPages;
        if (this.articles.size() % this.itemsAtATime == 0) {
            numberOfPages = this.articles.size() / this.itemsAtATime;
        } else {
            numberOfPages = this.articles.size() / this.itemsAtATime + 1;
        }
        System.out.printf("\nThere are %d pages in the catalog right now. Specify the page number:\n%s", numberOfPages, ">>> ");
        Scanner scanner = new Scanner(System.in);
        int page = scanner.nextInt();
        if (0 < page && page < numberOfPages) {
            this.setIndexesOfPage(this.itemsAtATime * (page - 1));
            this.fillCurrentPage();
        } else {
            System.out.println("Page is out of range...");
        }
    }

    private void setItemsAtATime() {
        String text = "How many items to display on the page?";
        String invitation = ">>> ";
        System.out.printf("%s\n%s", text, invitation);
        Scanner scanner = new Scanner(System.in);
        this.itemsAtATime = scanner.nextInt();
        this.setIndexesOfPage();
        this.updateMenu(2, this.itemsAtATime);
    }

    private void setIndexesOfPage() {
        if (this.firstIndexOfPage == null) this.firstIndexOfPage = 0;

        if (this.lastIndexOfPage == null) {
            this.lastIndexOfPage = this.firstIndexOfPage + this.itemsAtATime - 1;
        } else if (this.lastIndexOfPage + this.itemsAtATime - 1 < this.articles.size()) {
            this.lastIndexOfPage = this.firstIndexOfPage + this.itemsAtATime - 1;
        } else {
            this.lastIndexOfPage = this.articles.size() - 1;
        }

        this.updateMenu(1, this.lastIndexOfPage / this.itemsAtATime + 1);
    }

    private void setIndexesOfPage(Integer firstIndexOfPage) {
        if (0 <= firstIndexOfPage) {
            this.firstIndexOfPage = firstIndexOfPage;
        } else {
            this.firstIndexOfPage = 0;
        }

        if (this.lastIndexOfPage == null) {
            this.lastIndexOfPage = this.firstIndexOfPage + this.itemsAtATime - 1;
        } else if (this.lastIndexOfPage + this.itemsAtATime - 1 < this.articles.size()) {
            this.lastIndexOfPage = this.firstIndexOfPage + this.itemsAtATime - 1;
        } else {
            this.lastIndexOfPage = this.articles.size() - 1;
        }

        this.updateMenu(1, this.lastIndexOfPage / this.itemsAtATime + 1);
    }

    private void updateMenu(Integer rowKey, Integer currentValue) {
        String rowValue = this.menu.get(rowKey);
        this.menu.put(rowKey, rowValue.replaceFirst("\\(.+?\\)", String.format("(%d)", currentValue)));
    }
}
