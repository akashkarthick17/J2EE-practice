package io.zilker.rest.demo.RestAPI;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;



@Path("/image")
public class Image {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response getImage(@FormDataParam("file") InputStream inputStream,
			@FormDataParam("file") FormDataContentDisposition filedetails) {

		byte[] bytes = null;
		try {
			System.out.print("in try");
			bytes = org.apache.commons.io.IOUtils.toByteArray(inputStream);
		} catch (IOException e) {

			System.out.print("in catch");
			e.printStackTrace();
		}

		System.out.println("length: " + bytes.length);

		byte[] encoded = Base64.getEncoder().encode(bytes);
		System.out.println(new String(encoded));
		
		
		
		byte[] decoded = Base64.getDecoder().decode(encoded);

		System.out.println("filename: " + filedetails.getFileName()+" "+encoded.length);

		File file = new File("E://mypic.jpg");
	
		try {
			FileUtils.writeByteArrayToFile(file, decoded);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// uncomment line below to send streamed
		return Response.ok(new ByteArrayInputStream(decoded)).build();

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getText() {
		return "Sample text";
	}

}
