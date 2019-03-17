package org.keerthi.java.fileupload;
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
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;  
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/files")  
public class UploadResourse {
	
	Response response=null;
	  @POST  
	    @Path("/upload")  
	    @Consumes(MediaType.MULTIPART_FORM_DATA)  
	    public Response uploadFile(  
	    		 @FormDataParam("file") InputStream uploadedInputStream,  
	             @FormDataParam("file") FormDataContentDisposition fileDetail) {  
	             String fileLocation = "e:/here/" ;
	            System.out.println("fileLocation"+fileLocation);
	                     //saving file  
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
	             } catch (IOException e) {e.printStackTrace();}  
	             
	             String output = "File successfully uploaded to : " + fileLocation;  
	             return Response.status(200).entity(output).build();  
	         }  
	   
	  
	 
	  
	  @Path("/viewfiles")
	  @Produces(MediaType.TEXT_PLAIN)
	  @GET
	  public Response viewFile()
	  {
			File file = new File("e:\\here\\");

			if(file.isDirectory()){
				String[] files = file.list();
				for(String s:files){
					System.out.println(s);
					 String output = "You just uploaded::" + s;
				response =Response.status(200).entity(output).build();  
				}
		
			}
			 return response;
	  }
	 
}
