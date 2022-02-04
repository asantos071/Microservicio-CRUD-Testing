package com.map_json.example.map_json;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class MapJsonApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	@Order(0)
	void deleteCurso() throws Exception {
		mock.perform(MockMvcRequestBuilders.delete("/cursos/Python"));
	}

	@Test
	@Order(1)
	void ListCursos() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/cursos")).andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(2)
	void insertCurso() throws Exception {
		mock.perform(MockMvcRequestBuilders.post("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Angular 10\",\"duracion\":40,\"horario\":\"tarde\"}"))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(3)
	void updateCurso() throws Exception {
		mock.perform(MockMvcRequestBuilders.put("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Angular 10\",\"duracion\":80,\"horario\":\"mañana\"}"))
				.andDo(MockMvcResultHandlers.print());
	}

}
