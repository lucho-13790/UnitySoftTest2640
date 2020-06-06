package co.com.javeriana.service;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import co.com.javeriana.entity.*;
import co.com.javeriana.repository.mongoRepository;

@ComponentScan("Repository")
@Service
public  class SaveClients  {
	
	@Autowired
	private  mongoRepository dao ;
	public Client save(Client contact){
		System.out.println("entro");
		Client result = dao.save(contact);
		 return dao.save(contact);
		
     
    }
	public List<Client> findAll(){
		List<Client> users;
		users = dao.findAll();
		 return users;
		
    
   }
	
	public void delete(String user) {
		
		dao.deleteById(user);
				
			
		}
		//dao.delete(usuarioBorrar);
		
	
	public Client update(Client user) {
		
		return dao.save(user);
	}
	public Optional<Client> findbyId(String id) {
		Optional<Client> user = dao.findById(id);
		return dao.findById(id); 
	}
}