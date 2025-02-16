package Pack.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Pack.entity.FileData;

@Repository
public interface FileRepo extends JpaRepository<FileData,Integer> {

	FileData findByName(String fileName);

}
