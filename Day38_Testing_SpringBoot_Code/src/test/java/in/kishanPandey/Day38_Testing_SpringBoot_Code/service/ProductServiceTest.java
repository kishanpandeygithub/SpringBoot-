package in.kishanPandey.Day38_Testing_SpringBoot_Code.service;

import in.kishanPandey.Day38_Testing_SpringBoot_Code.entity.Product;
import in.kishanPandey.Day38_Testing_SpringBoot_Code.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private  ProductRepository productRepository;

    @InjectMocks
    private ProductService productService ;

    @Test
    void shouldReturnProductWhenProductExist(){
        //arranrement
        Product product
                = new Product(1L , "Laptop" , 50000 , 10);
        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        //act
        Product actualResult = productService.getProductById(1l);

        //Assert
        assertEquals(1L , actualResult.getId());
        assertEquals("Laptop" , actualResult.getName());
        assertEquals(50000 , actualResult.getPrice());
        assertEquals(10 , actualResult.getStock());

        verify(productRepository).findById(1L);
    }

    @Test
    void shouldThrowWhenProductDoseNotExist(){
        //arrangement
        when(productRepository.findById(99L))
                .thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class ,
                ()-> productService.getProductById(99L));

        //assertEquals
        assertEquals("Product not found: 99" , exception.getMessage());

        verify(productRepository).findById(99L);
    }

    @Test
    void shouldCreateProductWhenNameIsUnique(){
        //arrange
        Product request
                = new Product(null , "KeyBoard" , 200 , 5);

        Product savedProduct =
                new Product(10L , "KeyBoard" , 200 , 5);
        when(productRepository.existsByName("KeyBoard"))
                .thenReturn(false);
        when(productRepository.save(request))
                .thenReturn(savedProduct);
        //act
        Product result =
                productService.createProduct(request);
        //assert
        assertEquals(10L , result.getId());
        assertEquals("KeyBoard" , result.getName());

        verify(productRepository)
                .existsByName("KeyBoard");
        verify(productRepository)
                .save(request);
    }
}

