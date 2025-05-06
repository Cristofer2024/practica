package com.hospital_vm.cl.hospital_vm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.Model.Inventario;
import com.hospital_vm.cl.hospital_vm.Repository.InventarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InventarioService {
    @Autowired
    private InventarioRepository inInventarioRepository;

        public List<Inventario> findAll(){
        return inInventarioRepository.findAll();
    }

    public Inventario findById(Integer id){
        return inInventarioRepository.findById(id).get();
    }

    public Inventario save(Inventario inventario){
        return inInventarioRepository.save(inventario);
    }

    public void delete(Long id){
        inInventarioRepository.deleteById(id);
    }

    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
