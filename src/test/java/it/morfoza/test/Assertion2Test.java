package it.morfoza.test;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class Assertion2Test {

    @Test
    public void should() {
        long a = 10;
        long b = 10;
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.assertEquals(a, b);
        Assert.assertNotEquals(12, b);
        Assert.assertNotNull("", b);
        Assert.assertNotSame("", a);


        BigDecimal x4 = new BigDecimal(Math.PI);
        System.out.println(x4);
    }


    }


