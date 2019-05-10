package me.jmll.utm.restFile;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import me.jmll.utm.model.Link;
import me.jmll.utm.model.Resource;
import me.jmll.utm.rest.exception.CustomExceptionHandler;
import me.jmll.utm.rest.exception.ResourceNotFoundException;
import me.jmll.utm.service.FileService;
import me.jmll.utm.view.DownloadView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
public class FileRest {
	@Autowired
	FileService fileService;
	public class IndexRest {
		
		@RequestMapping(value = "file", method = RequestMethod.OPTIONS)
		public ResponseEntity<Void> showOptions() {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Allow", "OPTIONS");
			return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
		}
		@RequestMapping(value = "file", method = RequestMethod.GET)
		public View downloadFile(@RequestParam("foo") String filename) {
			
			
			try {
				Path file = fileService.getFile(filename);
				String contentType = Files.probeContentType(file);
				byte[] content = Files.readAllBytes( Paths.get(filename));
				DownloadView dv = new DownloadView(filename, contentType, content);
				return dv;
				
			}catch(ResourceNotFoundException ex) {
				CustomExceptionHandler ceh = new CustomExceptionHandler();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		/*public String deleteFile(String filename) {
			
		}
		public void uploadFile(MultipartFile mpf, string filename, string filename) {
			
		}
		public boolean uploadFile(MultipartFile file, String name, String path) {
			try {
	        	Path filePath = Paths.get(path);
	        	if (Files.notExists(filePath)){
	        		logger.warn("Target path does not exist. Creating {}", path);
	        		Files.createDirectory(filePath);
	        	}
	            BufferedOutputStream stream = new BufferedOutputStream(
	                    new FileOutputStream(new File(filePath.toString() + File.separator + name)));
	            FileCopyUtils.copy(file.getInputStream(), stream);
	            stream.close();
	            logger.info("Successfully uploaded {} ", filePath.toString() + File.separator + name);
	            return true;
	        }
	        catch (Exception ex) {
	        	logger.error("{}: {}", ex.getClass(), ex.getMessage());
	        }
			return false;
		}*/
	}


}
