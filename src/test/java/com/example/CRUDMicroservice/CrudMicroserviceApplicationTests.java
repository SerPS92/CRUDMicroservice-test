package com.example.CRUDMicroservice;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CrudMicroserviceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	@Order(4)
	void CoursesTest() throws Exception {
		mockMvc.perform(get("/courses")).andDo(print());
	}

	@Test
	@Order(0)
	void DeleteCoursesTest() throws Exception{
		mockMvc.perform(delete("/course/Python")).andDo(print());
	}

	@Test
	@Order(1)
	void courseTest() throws Exception{
		mockMvc.perform(get("/course")).andDo(print());
	}

	@Test
	@Order(2)
	void addTest() throws Exception{
		mockMvc.perform(post("/course")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Angular 10\",\"duration\":40,\"timetable\":\"Tuesday\"}"))
				.andDo(print());
	}

	@Test
	@Order(3)
	void putTest() throws Exception{
		mockMvc.perform(put("/course")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Angular 10\",\"duration\":80,\"timetable\":\"Tuesday\"}")
		).andDo(print());
	}


}
