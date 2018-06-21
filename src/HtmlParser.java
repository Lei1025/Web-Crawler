import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

    public ArrayList<String> parseData(String html) {
        if (html == null || html.length() < 1) {
            return null;
        }
       // List<Info> infoList = new ArrayList<Info>();
        Document document = Jsoup.parse(html, "UTF-8");
        Elements elements = document.getElementsByClass("content");
       // Elements p = elements.get(0).getElementsByTag("p");
        
        ArrayList<String> news = new ArrayList<>();
        for (Element element : elements) {
        	Elements text = element.getElementsByTag("p");
        	
        	news.add(text.text());     	
			//System.out.println(text.text());
		}
//
//        Elements liElements = elements.get(0).getElementsByTag("li");
//        
//
//        for (Element element : liElements) {
//
//            Elements books = element.getElementsByTag("a");
//            Elements times = element.getElementsByTag("p");
//
//            Info user = new Info();
//            user.setUrl(books.get(0).attr("href"));
//            user.setTitle(books.get(0).text());
//            user.setTime(times.get(0).text());
//
//            infoList.add(user);
//
//        }
        return news;
    }
}