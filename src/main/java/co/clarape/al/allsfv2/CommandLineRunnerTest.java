package co.clarape.al.allsfv2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.clarape.al.allsfv2.persistence.ProductoRepository;
import co.clarape.al.allsfv2.persistence.crud.ProductoCrudRepository;
import co.clarape.al.allsfv2.persistence.entity.Producto;

@Component
public class CommandLineRunnerTest implements CommandLineRunner{

    private final ProductoCrudRepository productoCrudRepository;
    private final ProductoRepository productoRepository;
    private List<Producto> all;

    public CommandLineRunnerTest(ProductoCrudRepository productoCrudRepository,
                                ProductoRepository productoRepository ) {
        this.productoRepository = productoRepository;
        this.productoCrudRepository = productoCrudRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=====================");
        all = (List<Producto>) productoCrudRepository.findAll();
        System.out.println(">>>Cant. registros Productos :: " + all.size());

        System.out.println(">>>Cant. registros por Categoía [1] :: " + productoCrudRepository.findByIdCategoriaOrderByNombreAsc(1).size() );

        all = productoRepository.getAll();
        System.out.println(">>>Cant. registros Productos(v2) :: " + all.size());

        all = productoRepository.getProductosByCategoriaOrderedAsc(2);
        System.out.println(">>>Cant. registros Productos-Por-Categoría(v2) :: " + all.size());
        for (Producto producto : all){
            System.out.println("Producto.nombre: " + producto.getNombre());
        }


        

        
    }
    
}
