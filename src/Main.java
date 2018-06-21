import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.omg.CORBA.ObjectHolder;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		Output output = new Output();
		output.main(null);
		
        String url = "https://twitter.com/cbcnews";
        String html = HttpUtil.sendGet(url, null);
        HtmlParser parser = new HtmlParser();
        ArrayList<String> news = parser.parseData(html);
        
        for (String str : news) {
			System.out.println(str);
		}
              
        String fisrtNews = news.get(0);
        
        
        do {
        	html = HttpUtil.sendGet(url, null);
			news = parser.parseData(html);
			try {
				if(!news.get(0).equals(fisrtNews)) {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        		Date date = new Date();
	        		//System.out.println(dateFormat.format(date));
	        		output.setText("New-coming message:"+ dateFormat.format(date)+"\n"+news.get(0));
//	        		System.out.println("New-coming message:"+ dateFormat.format(date));
//	        		System.out.println(news.get(0));
	        		fisrtNews = news.get(0);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			Thread.sleep(10000);
		} while (true);

    }

}
