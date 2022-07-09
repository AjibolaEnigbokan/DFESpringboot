package com.qa.dfespringboot.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfespringboot.entities.Student;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql","classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mvc; // used for sending mock request
	
	@Autowired
	private ObjectMapper mapper; // used for converting objects to JSON
	
	@Test
	
	public void readAll() throws Exception{
		
		List<Student> output = new ArrayList<>();
		
		Student entry = new Student(1L, "Bola","Enigbokan","jibolaenny@hotmail.com");
		output.add(entry);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		mvc.perform(get("/student/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));
		
	}
}
