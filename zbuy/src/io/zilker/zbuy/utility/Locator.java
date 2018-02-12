package io.zilker.zbuy.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Locator {

	public String stateName;

	public String getCityName(double lattitude, double longitude) {
		JSONObject jsonObject = null, firstIndex = null;
		JSONArray results = null, addressList = null;

		try {
			jsonObject = new JSONObject(
					IOUtils.toString(new URL(getURL(lattitude, longitude)), Charset.forName("UTF-8")));

			results = (JSONArray) jsonObject.get("results");
			firstIndex = (JSONObject) results.get(0);
			addressList = (JSONArray) firstIndex.get("address_components");

			for (int i = 0; i < addressList.length(); i++) {
				JSONObject address = addressList.getJSONObject(i);

				String types = (String) address.getJSONArray("types").get(0);

				if (types.equals("administrative_area_level_1")) {
					stateName = (String) (address.get("long_name"));

					return stateName;
				}

			}

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getURL(double lattitude, double longitude) {
		return "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lattitude + "," + longitude + "&key="
				+ Constants.API_KEY;
	}

	// Calculate the distance between user and the grocery shop in Kilometers.
	public  int distanceInKilometers(double userLatitude, double groceryLatitude, double groceryLongitude,
			double userLongitude) {
		double theta = userLongitude - groceryLongitude;
		double dist = Math.sin(degreeToRadians(userLatitude)) * Math.sin(degreeToRadians(groceryLatitude))
				+ Math.cos(degreeToRadians(userLatitude)) * Math.cos(degreeToRadians(groceryLatitude))
						* Math.cos(degreeToRadians(theta));
		dist = Math.acos(dist);
		dist = radiansToDegree(dist);
		dist = dist * 60 * 1.1515;

		dist = dist * 1.609344;

		return (int) dist;
	}

	// This function converts decimal degrees to radians

	private  double degreeToRadians(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// This function converts radians to decimal degrees
	private double radiansToDegree(double rad) {
		return (rad * 180 / Math.PI);
	}

}
