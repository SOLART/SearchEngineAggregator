package aggregator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.google.gson.Gson;

import aggregator.Config;
import aggregator.SearchProvider;
import aggregator.SearchResult;

public class BingSearchProvider implements SearchProvider {

	private static String accountId;
	private static String searchPhrase;
	private static int size;
	String searchResult;	

	public List<SearchResult> search(String phrase) throws Exception {
				
		searchPhrase = phrase;
		size = 10;
		
		// Add your binID to this file ./src/conf.properties
		
		accountId = Config.getBingID();

		final String bingUrlPattern = "https://api.datamarket.azure.com/Bing/Search/Web?$top=" + size + "&$skip=0&$format=JSON&Query=%%27%s%%27";
		final String query = URLEncoder.encode(searchPhrase, Charset.defaultCharset().name());
		final String bingUrl = String.format(bingUrlPattern, query);
		final String accountKeyEnc = Base64.getEncoder().encodeToString((accountId + ":" + accountId).getBytes());
		final URL url = new URL(bingUrl);
		final URLConnection connection = url.openConnection();
		connection.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
		
		BingResult results = null;
		try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

			Gson gson = new Gson();
			results = gson.fromJson(in, BingResult.class);			
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<SearchResult>();
		}
		return results.d.results;
	}
		
	public class BingResult {
		D d;
	}

	class D {
		List<SearchResult> results;
	}
}


