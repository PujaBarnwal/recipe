package com.example.recipe.repositories;

import com.example.recipe.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext
    public void findByUom() throws Exception {
        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByUom("Teaspoon");
        assertEquals("Teaspoon",optional.get().getUom());
    }
    @Test
    public void findByOunce()throws Exception{
        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByUom("Ounce");
        assertEquals("Ounce", optional.get().getUom());

    }
}