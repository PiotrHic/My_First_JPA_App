package com.example.my_first_jpa_app.domain;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DancerTest {

    Dancer dancer;

    @BeforeEach
    void setup(){

    }

    @Test
    void setId(){
        //given
        Integer expected = 10;
        //when
        dancer.setId(expected);
        //then
        Assert.assertEquals(expected, dancer.getId());
    }

    @Test
    void getId(){
        //given
        Integer expected = 10;
        //when
        dancer.setId(10);
        //then
        Assert.assertEquals(expected, dancer.getId());
    }

    @Test
    void setName(){
        //given
        String expected = "expected";
        //when
        dancer.setName(expected);
        //then
        Assert.assertEquals(expected, dancer.getName());
    }

    @Test
    void getName(){
        //given
        String expected = "expected";
        //when
        dancer.setName(expected);
        //then
        Assert.assertEquals(expected, dancer.getName());
    }

    @Test
    void setDanceStyle(){
        //given
        String expected = "Rumba";
        //when
        dancer.setDanceStyle(expected);
        //then
        Assert.assertEquals(expected, dancer.getDanceStyle());
    }

    @Test
    void getDanceStyle(){
        //given
        String expected = "Samba";
        //when
        dancer.setDanceStyle(expected);
        //then
        Assert.assertEquals(expected, dancer.getDanceStyle());
    }
}
