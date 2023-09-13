package com.example.crudBuild.controllers;

import com.example.crudBuild.models.Hospital;
import com.example.crudBuild.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Hospitals")
public class HospitalController  {
    @Autowired
    private HospitalRepository hospitalRepository;



    @GetMapping
    private List <Hospital> getAllHospitals () {
        return hospitalRepository.findAll();
    }

    @GetMapping("/{id}")
    private  Hospital  getHospitalById(@PathVariable Long id ) {
        return hospitalRepository.findById(id).get();
    }
    @PostMapping
    private  Hospital postNewHospital (@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @PutMapping ("/{id}")
    private String updateHospital (@PathVariable Long id,@RequestBody Hospital hospital) {
       if(hospitalRepository.existsById(id)) {
        Hospital exisingHospital = hospitalRepository.findById(id).get();
       exisingHospital.setAddress(hospital.getAddress());
       exisingHospital.setCapacity(hospital.getCapacity());
       exisingHospital.setSituation(hospital.getSituation());
       hospitalRepository.save(exisingHospital);
       return "The hospital was update ";

       } else {
           return "There is no user with this name";
       }
    }

    @DeleteMapping("/{id}")
    private  String deleteHospitalById (@PathVariable Long id) {
        if(hospitalRepository.existsById(id)) {
            hospitalRepository.deleteById(id);
            return "Hospital deleted from database";
        } else {
            return "The hospital is not in the database";
        }
    }

}
