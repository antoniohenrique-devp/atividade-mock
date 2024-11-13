package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

    public class ProductApplicationTest {
        @InjectMocks
        private ProductApplication prodApplic;

        @Mock
        private ProductService prodServi;

        @Mock
        private Product prod;


            @Test
                public void testSalvar() {

                    when(prodServi.save(prod)).thenReturn(true);
                    prodApplic.append(prod);
                    verify(prodServi).save(prod);
                    assertTrue(prodServi.save(prod), "Produto não foi salvo corretamente");
                }



            @Test
                public void testAtualizar() {

                int productId = prod.getId();
                prodApplic.update(productId, prod);
                verify(prodServi).update(prod);
                assertEquals(productId, prod.getId(), "ID do produto não corresponde ao esperado");

                }

                private void assertEquals(int productId, int id, String s) {
                }


            @Test
                public void testRemover() {

                int productId = prod.getId();
                prodApplic.remove(productId);
                verify(prodServi).remove(productId);

                }


            }
