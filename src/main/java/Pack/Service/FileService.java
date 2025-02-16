package Pack.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import Pack.Repository.FileRepo;
import Pack.entity.FileData;

@Service
public class FileService
{

	@Autowired
	FileRepo repo;
	
	private String folderPath="\"E:\\FileUpload_in_Edrive\"";
	
	public String uploadFile(MultipartFile file) throws Exception, IOException
	{
		
		
		String Path=folderPath+file.getOriginalFilename();
		
		FileData data=new FileData();
		data.setName(file.getOriginalFilename()); 
		data.setFileType(file.getContentType());
		data.setFilePath(Path);
		
		FileData result=repo.save(data);
		
		file.transferTo(new File(Path));//storing the file into folder
		
		if(result == null)
		{
			return " file not upload please select file";
		}
		
		
		return "file upload successsfull.....";
	}
	
	public byte[] downloadFile(String fileName) throws IOException
	{
		
		
		FileData data=repo.findByName(fileName);
		
		if(data !=null)
		{
		String filePath=data.getFilePath();
		
		
		byte[] result=Files.readAllBytes( new File(filePath).toPath());
 		
		return result;
		}		
		
		
		return null;
	}
	
	
	
	
}
