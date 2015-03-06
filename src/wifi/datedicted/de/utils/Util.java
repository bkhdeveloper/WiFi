package wifi.datedicted.de.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.TextView;

public final class Util {

	private static final String MY_PREFERENCES = "my_preferences";

	/**
	 * is the first lunch of the application
	 */
	private static final String IS_FIRST_LUNCH = null;

	/**
	 * Internal constructor; not to be called as this class provides static
	 * utilities only.
	 */
	private Util() {
		throw new UnsupportedOperationException("No instances permitted");
	}

	/**
	 * Test if a given Integer is not empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isNotEmpty(final Integer value) {
		return (value != null && value.intValue() != 0);
	}

	/**
	 * Test if a given Integer is empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isEmpty(final Integer value) {
		return (value == null || value.intValue() == 0);
	}

	/**
	 * Test if a given Long is not empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isNotEmpty(final Long value) {
		return (value != null && value.longValue() != 0);
	}

	/**
	 * Test if a given Long is empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isEmpty(final Long value) {
		return (value == null || value.longValue() == 0);
	}

	/**
	 * Test if a given float number is not empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isNotEmpty(final Float value) {
		return (value != null && value.floatValue() != 0.0);
	}

	/**
	 * Test if a given float number is empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isEmpty(final Float value) {
		return (value == null || value.floatValue() == 0.0);
	}

	/**
	 * Test if a given double number is not empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isNotEmpty(final Double value) {
		return (value != null && value.doubleValue() != 0.0);
	}

	/**
	 * Test if a given double number is empty (null or 0).
	 * 
	 * @param value
	 *            to test.
	 * @return <code> true </code> value is empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isEmpty(final Double value) {
		return (value == null || value.doubleValue() == 0.0);
	}

	/**
	 * Test if a given string is empty.
	 * 
	 * @param s
	 *            the string to test
	 * @return <code> true </code> string is empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isEmpty(final String s) {
		return (s == null || s.length() == 0);
	}

	/**
	 * Test if a given string is not empty.
	 * 
	 * @param s
	 *            the string to test
	 * @return <code> true </code> string is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static boolean isNotEmpty(final String s) {
		return (s != null && s.length() != 0);
	}

	/**
	 * Test if a given collection is not empty.
	 * 
	 * @param <T>
	 *            the type of the collection.
	 * @param collection
	 *            to test
	 * @return <code> true </code> collection is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isNotEmpty(final Collection<T> collection) {
		return (collection != null && !collection.isEmpty());
	}

	/**
	 * Test if a given collection is empty.
	 * 
	 * @param <T>
	 *            the type of the collection.
	 * @param collection
	 *            to test
	 * @return <code> true </code> collection is empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isEmpty(final Collection<T> collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * Test if a given arguments is not empty.
	 * 
	 * @param <T>
	 *            the type of the arguments.
	 * @param args
	 *            to test
	 * @return <code> true </code> arguments is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isNotEmpty(final T... args) {
		return (args != null && args.length != 0);
	}

	/**
	 * Test if a given arguments is empty.
	 * 
	 * @param <T>
	 *            the type of the arguments.
	 * @param args
	 *            to test
	 * @return <code> true </code> arguments is empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isEmpty(final T... args) {
		return (args == null || args.length == 0);
	}

	/**
	 * Test if a given argument is not empty.
	 * 
	 * @param <T>
	 *            the type of the argument.
	 * @param t
	 *            to test
	 * @return <code> true </code> argument is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isNotEmpty(final T t) {
		return (t != null);
	}

	/**
	 * Test if a given argument is not empty.
	 * 
	 * @param <T>
	 *            the type of the argument.
	 * @param t
	 *            to test
	 * @return <code> true </code> argument is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isNotEmpty(final Editable t) {
		return (t != null && t.length() > 0);
	}

	/**
	 * Test if a given argument is empty.
	 * 
	 * @param <T>
	 *            the type of the argument.
	 * @param t
	 *            to test
	 * @return <code> true </code> argument is empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isEmpty(final Editable t) {
		return (t == null || t.length() == 0);
	}

	/**
	 * Test if a given argument is not empty.
	 * 
	 * @param <T>
	 *            the type of the argument.
	 * @param t
	 *            to test
	 * @return <code> true </code> argument is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isEmpty(final T t) {
		return (t == null);
	}

	/**
	 * Test if a given Map is not empty.
	 * 
	 * @param <T>
	 *            type of the key
	 * @param <E>
	 *            type of the value
	 * @param args
	 *            the map to test
	 * @return <code> true </code> map is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T, E> boolean isNotEmpty(final Map<T, E> args) {
		return (args != null && !args.isEmpty());
	}

	/**
	 * Test if a given Map is empty.
	 * 
	 * @param <T>
	 *            type of the key
	 * @param <E>
	 *            type of the value
	 * @param args
	 *            the map to test
	 * @return <code> true </code> map is empty, otherwise <code> false </code>.
	 */
	public static <T, E> boolean isEmpty(final Map<T, E> args) {
		return (args == null || args.isEmpty());
	}

	/**
	 * Test if a given Set is not empty.
	 * 
	 * @param <T>
	 *            the type of the Set.
	 * @param args
	 *            to test
	 * @return <code> true </code> list is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isNotEmpty(final Set<T> args) {
		return (args != null && !args.isEmpty());
	}

	/**
	 * Test if a given Set is empty.
	 * 
	 * @param <T>
	 *            the type of the Set.
	 * @param args
	 *            to test
	 * @return <code> true </code> list is empty, otherwise <code> false </code>
	 *         .
	 */
	public static <T> boolean isEmpty(final Set<T> args) {
		return (args == null || args.isEmpty());
	}

	/**
	 * Test if a given list is not empty.
	 * 
	 * @param <T>
	 *            the type of the list.
	 * @param list
	 *            to test
	 * @return <code> true </code> list is not empty, otherwise
	 *         <code> false </code>.
	 */
	public static <T> boolean isNotEmpty(final List<T> list) {
		return (list != null && !list.isEmpty());
	}

	/**
	 * Test if a given list is empty.
	 * 
	 * @param <T>
	 *            the type of the list.
	 * @param list
	 *            to test
	 * @return <code> true </code> list is empty, otherwise <code> false </code>
	 */
	public static <T> boolean isEmpty(final List<T> list) {
		return (list == null || list.isEmpty());
	}

	/**
	 * Checks if the application is first time lunched.
	 * 
	 * <code> boolean isFirstTime = util.isFirst(this); </code>
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isFirst(Context context) {
		final SharedPreferences reader = context.getSharedPreferences(
				MY_PREFERENCES, Context.MODE_PRIVATE);
		final boolean first = reader.getBoolean("is_first", false);
		if (!first) {
			final SharedPreferences.Editor editor = reader.edit();
			editor.putBoolean(IS_FIRST_LUNCH, first);
			editor.commit();
		}
		return first;
	}

	/**
	 * set x for every version of android.
	 * 
	 * @params Float x, View view
	 * 
	 */
	//	public static void setX(View view, Float x) {
	//		if (ApplicationProperties.SDK_API < 11) {
	//			Float currentX = getX(view);
	//			final Animation animation = new TranslateAnimation(currentX, x, 0,
	//					0);
	//			animation.setDuration(0);
	//			animation.setFillAfter(true);
	//			view.startAnimation(animation);
	//		} else {
	//			view.setX(x);
	//		}
	//	}
	//
	//	/**
	//	 * get x for every version of android.
	//	 * 
	//	 * @params View view
	//	 * 
	//	 */
	//	public static Float getX(View view) {
	//		if (ApplicationProperties.SDK_API < 11) {
	//			int x = view.getLeft();
	//			View vParent = (View) view.getParent();
	//			while (vParent instanceof ViewGroup) {
	//				x = x + vParent.getLeft();
	//				vParent = (View) vParent.getParent();
	//			}
	//
	//			return (float) x;
	//		} else {
	//			return view.getX();
	//		}
	//	}
	//
	//	/**
	//	 * get y for every version of android.
	//	 * 
	//	 * @params View view
	//	 * 
	//	 */
	//	public static Float getY(View view) {
	//		if (ApplicationProperties.SDK_API < 11) {
	//			int y = view.getTop();
	//			View vParent = (View) view.getParent();
	//			while (vParent instanceof ViewGroup) {
	//				y = y + vParent.getTop();
	//				vParent = (View) vParent.getParent();
	//			}
	//
	//			return (float) y;
	//		} else {
	//			return view.getY();
	//		}
	//	}
	//
	//	/**
	//	 * set y for every version of android.
	//	 * 
	//	 * @param view
	//	 * @param y
	//	 */
	//	public static void setY(View view, Float y) {
	//		if (ApplicationProperties.SDK_API < 11) {
	//			Float currentY = getY(view);
	//			final Animation animation = new TranslateAnimation(currentY, y, 0,
	//					0);
	//			animation.setDuration(0);
	//			animation.setFillAfter(true);
	//			view.startAnimation(animation);
	//		} else {
	//			view.setY(y);
	//		}
	//	}

	/**
	 * blink view
	 * 
	 * @param View
	 * */
	public static void blink(final View v, final int blinkInterval) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(blinkInterval);
					} catch (Exception e) {
					}

					if (v.getVisibility() == View.VISIBLE) {
						v.setVisibility(View.INVISIBLE);
					} else {
						v.setVisibility(View.VISIBLE);
					}
				}
			}
		}).start();
	}

	/**
	 * Set text into TextView handling the HMTL characters
	 * 
	 * @param textView
	 * @param str
	 */
	public static void setText(TextView textView, String str) {
		if (Util.isNotEmpty(str)) {

			textView.setText(Html.fromHtml(Html.fromHtml(str).toString()));

			// clear!
		} else {
			textView.setText("");
		}
	}

	/**
	 * blink view
	 * 
	 * @param View
	 * */
	public static void glow(final View v, final int glowInterval) {
		AnimationSet set = new AnimationSet(true);

		Animation alphaAnimation = new AlphaAnimation(1f, 0f);
		alphaAnimation.setRepeatCount(Animation.INFINITE);
		alphaAnimation.setRepeatMode(Animation.REVERSE);
		alphaAnimation.setFillAfter(true);
		alphaAnimation.setFillBefore(true);
		alphaAnimation.setDuration(glowInterval);
		alphaAnimation.setStartOffset(0);

		set.addAnimation(alphaAnimation);
		v.startAnimation(set);
	}

	/**
	 * check if the user has Internet connection.
	 * 
	 * @return boolean
	 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo() != null
				&& cm.getActiveNetworkInfo().isConnectedOrConnecting();
	}

	/**
	 * @return haveNetworkConnection
	 */
	public static boolean haveNetworkConnection(Context context) {

		boolean haveConnectedWifi = false;
		boolean haveConnectedMobile = false;
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] netInfo = cm.getAllNetworkInfo();
		for (NetworkInfo ni : netInfo) {
			if (ni.getTypeName().equalsIgnoreCase("WIFI"))
				if (ni.isConnected())
					haveConnectedWifi = true;
			if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
				if (ni.isConnected())
					haveConnectedMobile = true;
		}
		return haveConnectedWifi || haveConnectedMobile;
	}

	/**
	 * enable the Wifi.
	 */
	public static void enableWifi(Context context) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		if (!wifi.isWifiEnabled()) {

			wifi.setWifiEnabled(true);
		}
	}

	/**
	 * test , never used .
	 * 
	 * convert polish string from ANS to UTF8 encoding.
	 * 
	 * @param Ans
	 *            encoded polish string
	 * @return UTF8 encoded polish string
	 */
	public static String handlePolishCaracters(String str) {
		// a
		String res = null;
		res = str.replace("Ä„", "&#260;");
		res = res.replace("Ä…", "&#261;");
		// e
		res = res.replace("Ä˜ ", "&#280;");
		res = res.replace("Ä™", "&#281;");
		// o
		res = res.replace("Ã“", "&#211;");
		res = res.replace("Ã³", "&#243;");
		// c
		res = res.replace("Ä†", "&#262;");
		res = res.replace("Ä‡", "&#263;");
		// l
		res = res.replace("Å", "&#321;");
		res = res.replace("Å‚", "&#322;");
		// n
		res = res.replace("Åƒ", "&#323;");
		res = res.replace("Å„", "&#324;");
		// s
		res = res.replace("Åš", "&#346;");
		res = res.replace("Å›", "&#347;");
		// z
		res = res.replace("Å¹", "&#377;");
		res = res.replace("Åº", "&#378;");
		// zp
		res = res.replace("Å»", "&#379;");
		res = res.replace("Å¼", "&#380;");
		return res;
	}

	/**
	 * get time stamp.
	 * 
	 * @return TimeStamp
	 * @value milliseconds
	 */
	public static Long getTimeStamp() {
		return System.currentTimeMillis();
	}

	/**
	 * fix the URL by adding missing "www." and "http://"
	 * 
	 * @param url
	 * @return fixed url
	 */
	public static String fixUrl(String url) {
		if (!Util.isEmpty(url)) {
			if (!url.startsWith("www.") && !url.startsWith("http://")) {
				url = "www." + url;
			}
			if (!url.startsWith("http://")) {
				url = "http://" + url;
			}
		}
		return url;
	}


	/**
	 * To save MSISDN and UserID inside the app preferences
	 * @param pMSISDN
	 * @param pUserID
	 * @param pAPPSFID
	 * @param pTinyURL
	 * 
	 */

	public static void saveUserID(Context context,long pUserID){

		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);

		lPreferences.edit().putLong("PrefUserID",pUserID ).commit();
	}

	public static void saveMSIDDN(Context context,String pMSISDN){

		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefMISSDN",pMSISDN ).commit();
	}
	
	public static void saveAPPSFlyerID(Context context,String pAPPSFID){

		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefAPPSFlyerID",pAPPSFID ).commit();
	}
	
	
	public static void saveTinyURL(Context context,String pTinyURL){

		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);

		lPreferences.edit().putString("PrefTinyURL", pTinyURL ).commit();
	}
	
	
	public static long getUserIdfromPref(Context context){
		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);
		return lPreferences.getLong("PrefUserID", 0);
	}

	public static String getMSISDNfromPref(Context context){
		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefMISSDN", "");
	}
	
	public static String getAPPSFlyerIDfromPref(Context context){
		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefAPPSFlyerID", "");
	}
	
	public static String getTinyURLfromPref(Context context){
		SharedPreferences lPreferences=PreferenceManager.getDefaultSharedPreferences(context);
		return lPreferences.getString("PrefTinyURL", "");
	}
	
	
}
