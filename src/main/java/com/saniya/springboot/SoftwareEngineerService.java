package com.saniya.springboot;
import com.saniya.springboot.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;
    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository
    )
    {
        this.softwareEngineerRepository=softwareEngineerRepository;

    }
    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(
            SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }
    public void updateEngineer(Integer id, SoftwareEngineer engineer) {

        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Engineer with id " + id + " not found"));

        existingEngineer.setName(engineer.getName());
        existingEngineer.setTechStack(engineer.getTechStack());

        softwareEngineerRepository.save(existingEngineer);
    }
    public SoftwareEngineer getSoftwareEngineerById(
            Integer id
    ) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("Engineer with id " + id + " not found"));
    }
   
}
