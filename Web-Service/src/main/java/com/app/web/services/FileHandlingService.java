package com.app.web.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/files")
public class FileHandlingService {

	@GET
	@Path("/image")
	@Produces("image/jpg")
	public Response getImageFile() {
		File file = new File("C:/sample.jpg");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"sample.jpg\"");
		return response.build();

	}

	@GET
	@Path("/txt")
	@Produces("text/plain")
	public Response getFile() {
		File file = new File("C:/sample.txt");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"sample.txt\"");
		return response.build();

	}

	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPDFFile() {
		File file = new File("C:/sample.pdf");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"sample.pdf\"");
		return response.build();
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		String fileLocation = "C:/Accenture/" + fileDetail.getFileName();
		try {
			FileOutputStream out = new FileOutputStream(new File(fileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
			out = new FileOutputStream(new File(fileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			String output = "File could not be uploaded to : " + fileLocation;
			return Response.status(500).entity(output).build();
		}
		String output = "File successfully uploaded to : " + fileLocation;
		return Response.status(200).entity(output).build();
	}
}
