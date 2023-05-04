package org.servlet;
import java.util.ArrayList;

public class Menu {

    static ArrayList<String> getMenu() {
        ArrayList<String> htmlmenu = new ArrayList<String>();
        htmlmenu.add("<ul>");
        htmlmenu.add("<li><a href=\"#\">Todas las cartas</a></li>");
        htmlmenu.add("<li><a href=\"#\">Item 2</a>");
        htmlmenu.add("</ul>");
        return htmlmenu;
    }

}
