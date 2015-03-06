/**
 * 
 */
package wifi.datedicted.de.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.util.Log;

public final class RestClient {

	/**
	 * send a httpRequest to the url and parse the json response to a string.
	 * 
	 * @param url
	 * @return String response
	 */
	public String sendHttpGet(String url) {

		InputStream inputStream = null;
		InputStreamReader isr = null;

		// List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		String result = null;

		try {
			// the HTTP request
			HttpParams p = new BasicHttpParams();
			HttpClient httpclient = new DefaultHttpClient(p);
			HttpGet httppost = new HttpGet(url);
			httppost.setHeader("charset", "UTF-8");
			httppost.setHeader("Content-Type", "application/json");
			// httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			inputStream = entity.getContent();
		} catch (Exception e) {
			Log.e("taghttppost", "" + e.toString());
		}

		if (inputStream != null) {

			// conversion of the httpResponse to a string
			try {
				isr = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader reader = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();

				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}

				result = new String(sb.toString().getBytes("UTF-8"));

			} catch (Exception e) {
				Log.e("tagconvertstr", "" + e.toString(), e);
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						Log.e("tagconvertstr", "", e);
					}
				}
				if (isr != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						Log.e("tagconvertstr", "", e);
					}
				}
			}
		}
		return result;
	}

}
