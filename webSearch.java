package date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class webSearch {
    private static Document docGiftHoliday = null;

    static {
        try {
            docGiftHoliday = Jsoup.connect("https://shos.com.ua/184-gifts-by-holidays")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public webSearch() {
    }

    static List<String> giftSearchHoliday(String holidayName) throws IOException {
        String url;
        List<String> v = new ArrayList<>();
        Elements hrefs = docGiftHoliday.select("div#subcategories a[href][title]");

        for (Element el : hrefs) {
            if (el.attr("title").equals(holidayName)) {
                url = el.attr("href");
                List<String> list = new ArrayList<>(Arrays.asList(url.split("/")));
                String elem = list.get(list.size() - 1);
                List<String> list_ = new ArrayList<>(Arrays.asList(elem.split("-")));
                String id_category = list_.get(0);
                String url_new = url+"?id_category="+id_category+"&n=120";

                Document doc_new = Jsoup.connect(url_new)
                        .userAgent("Chrome/4.0.249.0 Safari/532.5")
                        .get();

                Elements inputElements = doc_new.select("div.product-container a[href][title]");

                for (Element inputElement : inputElements) {
                    String key = inputElement.attr("href");
                    String value = inputElement.attr("title");
                    if (!value.equals("До кошика")) v.add(value);
                }
            }
        }
        return v;
    }

    static List<String> giftSearchBday(Person person) throws IOException {
        String sex;
        if (Objects.equals(person.getSex(), "M")){
            if (person.getAge() >= 18){
                sex = "Мужчині";
            } else {
                sex = "Хлопцю";
            }
        } else {
            if (person.getAge() >= 18){
                sex = "Жінці";
            } else {
                sex = "Дівчині";
            }
        }
        String url;
        List<String> v = new ArrayList<>();
        Elements mainSubcategories = docGiftHoliday.select("div#subcategories a[href][title]");

        for (Element el : mainSubcategories) {
            if (el.attr("title").equals("День народження")) {
                url = el.attr("href");

                Document docGiftHolidaySub = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
                Elements subcategories = docGiftHolidaySub.select("div#subcategories a[href]");

                for (Element subcategory : subcategories) {
                    if (subcategory.text().equals(sex)){
                        url = subcategory.attr("href");
                        List<String> list = new ArrayList<>(Arrays.asList(url.split("/")));
                        String elem = list.get(list.size() - 1);
                        List<String> list_ = new ArrayList<>(Arrays.asList(elem.split("-")));
                        String id_category = list_.get(0);
                        String url_new = url+"?id_category="+id_category+"&n=120";

                        Document docGiftHolidaySub_new = Jsoup.connect(url_new).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
                        Elements inputElements = docGiftHolidaySub_new.select("div.product-image-container a[href][title]");

                        for (Element inputElement : inputElements) {
                            String key = inputElement.attr("href");
                            String value = inputElement.attr("title");
                            if (!value.equals("До кошика")) v.add(value);
                        }
                    }
                }
            }
        }
        return v;
    }
}
