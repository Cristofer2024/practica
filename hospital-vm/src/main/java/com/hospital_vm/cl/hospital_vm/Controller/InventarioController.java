package com.hospital_vm.cl.hospital_vm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.Model.Inventario;
import com.hospital_vm.cl.hospital_vm.Service.InventarioService;

@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;
    @GetMapping
    public ResponseEntity<List<Inventario>> listar(){
        List<Inventario> inventario = inventarioService.findAll();
        if(inventario.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inventario);
    }

    @PostMapping
    public ResponseEntity<Inventario> guardar(@RequestBody Inventario inventario){
        Inventario productoNuevo = inventarioService.save(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body((productoNuevo));
        // return new ResponseEntity<>(productoNuevo, HttpStatus.ACEEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscar(@PathVariable Integer id){
        try{
            Inventario inventario = inventarioService.findById(id);
            return ResponseEntity.ok(inventario);
        }catch(Exception e ){
            return ResponseEntity.notFound().build();
        }}

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizar(@PathVariable Integer id, @RequestBody Inventario inventario){
        try{
            Inventario inv = inventarioService.findById(id);
            inv.setId(id);
            inv.setProducto(inventario.getProducto());
            inv.setDescripcion(inventario.getDescripcion());
            inv.setStock(inventario.getStock());
            inv.setFecha_ingreso(inventario.getFecha_ingreso());
            inventarioService.save(inv);
            return ResponseEntity.ok(inventario);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }}
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Inventario> eliminar(@PathVariable Long id){
            try{
                inventarioService.delete(id);
                return ResponseEntity.noContent().build();
            }catch(Exception e){
                return ResponseEntity.notFound().build();
            }
            
        }

}
