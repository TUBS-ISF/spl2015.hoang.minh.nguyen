package de.tubs.isf.spl.task2;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) {
		Validate.isTrue(args.length == 2, "java -cp jsoup.jar de.tubs.isf.spl.task2.Main [--sp] url");
		String url = args[1];
		String params = args[0];
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception ex) {}
		
		if (params.contains("p")) {
			if (doc != null) {
				System.out.println(url+" is alive");
			}
			else {
				System.err.println("Ping failed after 3 seconds");
			}
		}
		
		if (params.contains("s")) {
			if (doc != null) {
				System.out.println(doc.toString());
			}
			else {
				System.err.println("URL does not exist");
			}
		}
		
		if (!params.contains("p") && !params.contains("s")) {
			System.err.println("Unknown command options");
		}
	}

}
