package com.cs544.project.email.service;

import com.cs544.project.email.domain.Email;
import com.cs544.project.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    public Collection<Email> get() {
        return emailRepository.findAll();
    }
//    public Email get(Integer id) throws CustomNotFoundException {
//        Optional<Email> location =  emailRepository.findById(id);
//        return location.orElseThrow(() -> new CustomNotFoundException("Could not find locationType with id=:" + id));
//    }

    public void create(Email email) {
//        Email locationType=EmailAdapter.INSTANCE.toEntity(locationTypeCreateRequest);
        emailRepository.save(email);
    }
//
//    public Email update(Integer id, EmailCreateRequest locationTypeCreateRequest) throws CustomNotFoundException{
//        Email locationType = get(id);
//        EmailAdapter.INSTANCE.updateEntityWithRequest(locationTypeCreateRequest, locationType);
//        return locationTypeRepository.save(locationType);
//    }
//
//    public void delete(Integer id) throws CustomNotFoundException{
//        Email locationType = get(id);
//        Collection<Location> locations = locationRepository.findByEmail(locationType);
//        for(Location location: locations){
//            location.setEmail(null);
//            locationRepository.save(location);
//        }
//        locationTypeRepository.delete(locationType);
//    }
}
