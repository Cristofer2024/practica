package com.hospital_vm.cl.hospital_vm.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_vm.cl.hospital_vm.Model.Paciente;



@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findById(Integer id);
    // Encuentra pacientes por apellido
    //List<Paciente>  findByApellido(String apellido);

    // Encuentra paciente por correo
    //Paciente findByCorreo(String correo);

    

}
