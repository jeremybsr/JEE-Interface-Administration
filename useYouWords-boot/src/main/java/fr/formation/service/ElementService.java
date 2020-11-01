package fr.formation.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import fr.formation.dao.IElementRepository;
import fr.formation.exception.ElementNotFoundException;
import fr.formation.model.Element;

@Service
public class ElementService {
	@Autowired
	private IElementRepository daoElement;
	@Autowired
	private Cloudinary cloudinary; 

	public List<Element> findAll() {
		return this.daoElement.findAll();
	}
public void odd(Element element) throws IOException {
		
				
		this.daoElement.save(element);
		
	}

	public void add(Element element, MultipartFile file ) throws IOException {
		
		uploadToCloudinary(element, file);	
		
		this.daoElement.save(element);
		
	}
	
	private void uploadToCloudinary(Element element, MultipartFile file) throws IOException {
		
        Map params = ObjectUtils.asMap(
                "publicid", element.getStatement() ,
                "overwrite", true,
                "notification_url", "https://mysite/notify_endpoint",
                "resource_type", "auto"
        );
        File f = Files.createTempFile("temp", file.getOriginalFilename()).toFile();
        file.transferTo(f);
        Map uploadResult = cloudinary.uploader().upload(f, params);
        element.setUrl(uploadResult.get("secure_url").toString());
    }

	public void edit(int id, Element element) {
		this.daoElement.save(element);
	}

	public Element findById(int id) {
		return this.daoElement.findById(id).orElseThrow(ElementNotFoundException::new);
	}

	public void deleteById(int id) {
		this.daoElement.deleteById(id);
	}

}
