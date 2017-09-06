package com.mooovi.business.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mooovi.business.entity.Product;
import com.mooovi.business.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository mockProductRepository;
    
    @Test
    public void testFindOne(){
        Product product = new Product(); // ①
        product.setId(1L);
        product.setTitle("テスト映画");
        when(mockProductRepository.findOne(1L)).thenReturn(product); // ②

        assertThat(productService.findOne(1L).getTitle(), is("テスト映画")); // ③
    }
    
    @Test
    public void testFindOneOrNew(){
        Product product = new Product(); // ①
        product.setId(1L);
        product.setTitle("テスト映画");
        when(mockProductRepository.findByTitle("テスト映画")).thenReturn(product); // ②
        when(mockProductRepository.findByTitle("映画")).thenReturn(null); // ③

        assertThat(productService.findOneOrNew("テスト映画").getId(), is(1L)); // ④
        assertThat(productService.findOneOrNew("映画").getId(), is(nullValue())); // ⑤
    }


}
