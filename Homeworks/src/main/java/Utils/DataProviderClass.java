package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "booksSelectorsAndLinks")
    public Object[][] booksLinks() {
        Object[][] data = new Object[6][2];
        data[0][0] = "div.first div.sc_column_item h3>a[href='the-forest']";
        data[0][1] = "https://keybooks.ro/shop/the-forest/";
        data[1][0] = "div.first div.sc_column_item h3>a[href='the-son']";
        data[1][1] = "https://keybooks.ro/shop/the-son/";
        data[2][0] = "div.first div.sc_column_item h3>a[href='life-in-the-garden']";
        data[2][1] = "https://keybooks.ro/shop/life-in-the-garden/";
        data[3][0] = "div.first div.sc_column_item h3>a[href='the-long-road-to-the-deep-silence']";
        data[3][1] = "https://keybooks.ro/shop/the-long-road-to-the-deep-silence/";
        data[4][0] = "div.first div.sc_column_item h3>a[href='its-a-really-strange-story']";
        data[4][1] = "https://keybooks.ro/shop/its-a-really-strange-story/";
        data[5][0] = "div.first div.sc_column_item h3>a[href='storm']";
        data[5][1] = "https://keybooks.ro/shop/storm/";
        return data;
    }

}
