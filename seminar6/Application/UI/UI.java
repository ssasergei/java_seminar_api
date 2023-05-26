package Application.UI;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class UI {
    private LinkedList<Object> stack;
    private Map<Integer, String> menu;
    private Integer dataBaseSize;

    public UI() {
        this.stack = new LinkedList<>();
        this.stack.add(this);
        this.dataBaseSize = 10_000;
        this.setMenu();
    }

    public void handler() {
        Scanner scanner = new Scanner(System.in);
        while (!this.stack.isEmpty()) {
            Object temp = this.stack.getLast();
            int responseCode = 500;
            if (temp instanceof UI ui) {
                this.showMenu();
                System.out.printf("%s", "\n>>> ");
                switch (scanner.nextInt()) {
                    case 1: {
                        this.stack.add(new CatalogueHandlers(this.dataBaseSize));
                        responseCode = 101;
                        break;
                    }
                    case 2: {
                        System.out.printf("\n%s:\n%s", "Specify the database size", ">>> ");
                        this.dataBaseSize = scanner.nextInt();
                        break;
                    }
                    case 3: {
                        responseCode = 200;
                        break;
                    }
                    default: {
                        responseCode = 404;
                        break;
                    }
                }

            } else if (temp instanceof CatalogueHandlers catalogueHandlers) {
                responseCode = catalogueHandlers.handler();
            }
            this.responseHandler(responseCode);
        }
    }

    private void setMenu() {
        this.menu = new HashMap<>();
        this.menu.put(1, "Catalogue");
        this.menu.put(2, "Set catalog size");
        this.menu.put(3, "Exit");
    }

    private void showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> row :
                this.menu.entrySet()) {
            stringBuilder.append(String.format("\n%d. %s", row.getKey(), row.getValue()));
        }
        System.out.println(stringBuilder);
    }

    private void responseHandler(Integer responseCode) {
        switch (responseCode) {
            case 100: {
                System.out.println("\nResponse: ...Continue...");
                break;
            }
            case 200: {
                System.out.println("\nResponse: ...Exit...");
                this.stack.clear();
                break;
            }
            case 205: {
                System.out.println("\nResponse: ...Back...");
                this.stack.removeLast();
                break;
            }
        }
    }
}
