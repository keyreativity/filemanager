package org.keerthi.java.fileupload;

import java.io.File;
import java.text.NumberFormat;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/downloadfile")
public class FileService {

	private static final String api_version = "1.01A rev.1";
	private static final String FILE_FOLDER = "e://here/";

	@GET
	@Path("/version")

	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version: " + api_version + "</p>";
	}

	@GET
	@Path("/download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadFilebyQuery(@QueryParam("filename") String fileName) {
		return download(fileName);
	}

	@GET
	@Path("/download/{filename}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadFilebyPath(@PathParam("filename") String fileName) {
		return download(fileName);
	}

	private Response download(String fileName) {
		String fileLocation = FILE_FOLDER + fileName;
		Response response = null;
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);

		// Retrieve the file
		File file = new File(FILE_FOLDER + fileName);
		if (file.exists()) {
			ResponseBuilder builder = Response.ok(file);
			builder.header("Content-Disposition", "attachment; filename=" + file.getName());
			response = builder.build();

			long file_size = file.length();
		} else {

			response = Response.status(404).entity("FILE NOT FOUND at the uploaded location. ").type("text/plain")
					.build();
		}

		return response;
	}
}
