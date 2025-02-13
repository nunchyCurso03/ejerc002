package es.santander.ascender.ejerc002.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.santander.ascender.ejerc002.model.ColumnaArquitectonica;
import es.santander.ascender.ejerc002.repository.ColumnaArquitectonicaRepository;

/*
 * Esta anotación  Service marca la clase ColumnaArquitectonicaService como un servicio
 * dentro del contexto de Spring. En Spring, las clases anotadas con @Service
 * son componentes que contienen la lógica de negocio de la aplicación. Spring
 * se encarga de instanciar y gestionar este servicio (usando inyección de
 * dependencias).
 */

@Service

public class ColumnaArquitectonicaService {
    /*
     * La variable repository es de tipo ColumnaArquitectonicaRepository, que es el
     * repositorio que interactúa con la base de datos (a través de JPA). Este
     * repositorio hereda de la interfaz JpaRepository o alguna de sus
     * subinterfaces, lo que le permite realizar operaciones CRUD (Crear, Leer,
     * Actualizar, Eliminar) en la tabla correspondiente a la entidad
     * ColumnaArquitectonica.
     * 
     * Nota importante: Aquí, el repositorio no se inicializa explícitamente, sino
     * que se inyecta automáticamente por Spring (esto se realiza gracias a la
     * inyección de dependencias). El proceso de inyección se configura en el
     * contexto de Spring, por lo que no necesitas crear una instancia manualmente.
     * Spring se encarga de inyectar una implementación del repositorio en el
     * servicio.
     */

    private ColumnaArquitectonicaRepository repository; // representa las operaciones que puedo reañizar sobre la tabla
                                                        // en esa
                                                        // base de datos. Lleva la lógica de jpa

    /*
     * Este método create crea un nuevo registro en la base de datos utilizando el
     * repositorio.
     * Recibe un objeto ColumnaArquitectonica como parámetro. Este objeto contiene
     * los datos que se van a guardar en la base de datos.
     * Llama al método save() del repositorio, que guarda el objeto en la base de
     * datos. Si es un nuevo objeto (sin un ID asignado), lo inserta; si ya tiene un
     * ID, lo actualiza.
     * Después de guardar el objeto, save() devuelve el objeto guardado (con su ID
     * generado o actualizado, si es necesario) y este objeto es devuelto desde el
     * método create.
     */

    public ColumnaArquitectonica create(ColumnaArquitectonica columnaArquitectonica) {
        if(columnaArquitectonica.getId() != null){
            throw new CrudSecurityException ("Han tratado de modificar un registro columna utilizando la creación ",
             CRUDOperation.CREATE,
              columnaArquitectonica.getId());

        }

        return repository.save(columnaArquitectonica); // le pasamos un bean, un objeto. Es distinta variable pero mismo
                                                       // objeto.

    }

    /*
     * Este método lee un registro desde la base de datos usando un ID.
     * Recibe un Long id como parámetro, que es el identificador del objeto
     * ColumnaArquitectonica que deseas recuperar.
     * Llama al método findById(id) del repositorio, que busca una entidad de tipo
     * ColumnaArquitectonica en la base de datos con el ID proporcionado. Este
     * método devuelve un Optional<ColumnaArquitectonica>.
     * orElse(null): Si el Optional contiene un valor (es decir, si se encontró una
     * ColumnaArquitectonica con ese ID), se devuelve ese valor. Si el Optional está
     * vacío (es decir, no se encontró ninguna entidad con el ID), se devuelve null.
     */

    public ColumnaArquitectonica read(Long id) {

        return repository.findById(id).orElse(null);
    }

    public List<ColumnaArquitectonica> read() {
        return repository.findAll();
    }

    public ColumnaArquitectonica update(ColumnaArquitectonica columnaArquitectonica) {

        if (columnaArquitectonica.getId() == null) {
            throw new CrudSecurityException ("Han tratado de crear un registro columna utilizando la creación ",
            CRUDOperation.UPDATE,
            null);

        }

        return repository.save(columnaArquitectonica);

    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
