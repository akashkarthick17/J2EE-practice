package io.zilker.resttest.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part part = request.getPart("file");
		InputStream inputStream = part.getInputStream();
		
		
		byte[] bytes = null;
		try {
			System.out.print("in try test");
			bytes = IOUtils.toByteArray(inputStream);
		} catch (IOException e) {

			System.out.print("in catch");
			e.printStackTrace();
		}

		System.out.println("length: " + bytes.length);

		byte[] encoded = Base64.getEncoder().encode(bytes);
		System.out.println(new String(encoded));
		String encodedString = new String(encoded);
		
		URL url = new URL("http://localhost:8080/RestApi/webapi/image");
		
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); 
		
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Accept", "image/jpeg");
		OutputStream outputStream = httpURLConnection.getOutputStream();
		outputStream.write(encoded);
		outputStream.close();

		
		InputStream rInputStream = httpURLConnection.getInputStream();

	
		
		
		byte[] decoded = Base64.getDecoder().decode(rInputStream.readAllBytes());

		

		File file = new File("E://mypic1.jpg");
	
		try {
			FileUtils.writeByteArrayToFile(file, decoded);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
