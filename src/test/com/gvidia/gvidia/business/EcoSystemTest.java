package com.gvidia.gvidia.business;


import com.gvidia.gvidia.business.db4outil.DB4OUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class EcoSystemTest {

    EcoSystem system;

    @BeforeAll
    public void setUp() throws Exception {

        system = EcoSystem.getInstance(true);
    }


    @AfterAll
    public void tearDown() throws Exception {
        DB4OUtil.getInstance().storeSystem(system);
    }
}