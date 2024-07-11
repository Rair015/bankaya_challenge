package com.bankaya.pokeapiconsumer.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
@CucumberContextConfiguration
public class CucumberConfig {}
