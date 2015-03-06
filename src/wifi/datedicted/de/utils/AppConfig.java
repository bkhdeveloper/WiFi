package wifi.datedicted.de.utils;

import java.io.Serializable;

public class AppConfig implements Serializable {


	
	private static final long serialVersionUID = 1L;
	
	private String product;
	private String state;
	private String wifi;
	private String url;
	private String sms;
	/**
	 * constructor.
	 * 
	 * @param product
	 * @param state
	 * @param wifi
	 * @param url
	 * @param sms
	 */

	public AppConfig(String product, String state, String wifi, String url,
			String sms) {
		super();
		this.product = product;
		this.state = state;
		this.wifi = wifi;
		this.url = url;
		this.sms = sms;
	}

	public AppConfig(AppConfig aConfig) {
		super();

		this.product = aConfig.product;
		this.state = aConfig.state;
		this.wifi = aConfig.wifi;
		this.url = aConfig.url;
		this.sms = aConfig.sms;
		
		
	}

	public AppConfig() {
	}

	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}


}
