package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc002.model.ColumnaArquitectonica;
import jakarta.transaction.Transactional;

@SpringBootTest
public class ColumnaArquitectonicaRepositoryTest {

    @Autowired
    private ColumnaArquitectonicaRepository repository;

    @Test
    public void testCreate(){
        ColumnaArquitectonica columnaArquitectonica = new ColumnaArquitectonica();
        columnaArquitectonica.setA2(5l); // a2 tiene que ser mayor o igual a 5 por validacion
        columnaArquitectonica.setA1(4l); 
        repository.save(columnaArquitectonica);// guardamos 

        //
        assertTrue (
            repository
                .findById(columnaArquitectonica.getId())
                .isPresent());

    }

    @Test
    public void testCreatePeroNoLLegaAlValorMinimoDeA2(){
        ColumnaArquitectonica columnaArquitectonica = new ColumnaArquitectonica();
        columnaArquitectonica.setA2(4l); // a2 tiene que ser mayor o igual a 5 por validacion
        
        
         
        assertThrows(
            new Exception().getClass(),
            ()-> repository.save(columnaArquitectonica)// guardamos 

        );

    }

     // Test de eliminación
    @Test
    public void testDelete(){
        ColumnaArquitectonica columnaArquitectonica = new ColumnaArquitectonica();
        columnaArquitectonica.setA2(25L);
        
        
        repository.save(columnaArquitectonica);

       
        repository.delete(columnaArquitectonica);

        // Verificamos que ya no está presente en la base de datos
        assertFalse(
            repository
            .findById(columnaArquitectonica.getId())
            .isPresent());
    }


    @Test
    @Transactional // lo necesitamos en la capa de servicio.
    public void updateRaro() {
    
        ColumnaArquitectonica columna = new ColumnaArquitectonica();
        columna.setA2(7l);
        columna.setA1(20l);
        repository.save(columna); // lo guarda en la BBDD. Para actualizar y crear.

        assertTrue(repository.existsById(columna.getId()));

        columna.setA2(10l);// cambiamos a 10 el valor
        repository.flush();

        Optional<ColumnaArquitectonica> updatedColumna = repository.findById(columna.getId());

        assertTrue(updatedColumna.isPresent());
        assertTrue(updatedColumna.get().getA2() == 10);
    }


    


    
}


