package io.zilker.rest.delegate;

import io.zilker.rest.bean.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;

import com.google.gson.Gson;

public class RestDelegate {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public StudentList retrieveStudentList() {

		try {
			URL url = new URL("http://localhost:8080/RestAPI/webapi/students");
			
			

			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Accept", "application/json");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String input = "", temp;
			while ((temp = bufferedReader.readLine()) != null) {

				input += temp;
			}

			Gson gson = new Gson();

			StudentList studentList = gson.fromJson(input, StudentList.class);

			return studentList;

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Student insertStudentDetail(Student student) {

		URL url;
		Student studentResponse = null;
		try {

			Gson gson = new Gson();

			String json = gson.toJson(student);
			
			System.out.print(json);

			url = new URL("http://localhost:8080/RestAPI/webapi/students");
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestProperty("Content-type", "application/json");

			OutputStream outputStream = urlConnection.getOutputStream();
			outputStream.write(json.getBytes("UTF-8"));
			outputStream.close();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String input = "", temp;
			while ((temp = bufferedReader.readLine()) != null) {

				input += temp;
			}

			studentResponse = gson.fromJson(input, Student.class);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return studentResponse;

	}

}
