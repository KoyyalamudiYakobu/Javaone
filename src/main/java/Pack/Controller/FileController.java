package Pack.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Pack.Service.FileService;



@RestController
@RequestMapping("/image")
public class FileController 
{

	@Autowired
	FileService service;
	
	
	@PostMapping("/upload")
	public String fileinsert(@RequestParam("file") MultipartFile file) throws IOException, Exception {
		
		
		return service.uploadFile(file);
	}
	
	@GetMapping("/download/{filename}")
	public byte[] getMethodName(@PathVariable String filename) throws IOException {
		return service.downloadFile(filename);
	}
	
	
	
	
	
	
	
	
	
	
	
}
