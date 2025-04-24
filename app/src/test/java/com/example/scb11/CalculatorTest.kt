package com.example.scb11

import junit.framework.TestCase

class CalculatorTest : TestCase() {
    lateinit var calc:Calculator

    public override fun setUp() {
        super.setUp()
        calc = Calculator()
    }

    public override fun tearDown() {}

    fun testAdd() {
        var expectation = 40
        var actual = calc.add(10,20)
        assertEquals(expectation,actual)
    }
}