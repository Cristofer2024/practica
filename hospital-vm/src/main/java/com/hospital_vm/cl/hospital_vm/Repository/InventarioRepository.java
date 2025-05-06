package com.hospital_vm.cl.hospital_vm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_vm.cl.hospital_vm.Model.Inventario;
import java.util.Optional;


@Repository

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findById(Integer id);
}
