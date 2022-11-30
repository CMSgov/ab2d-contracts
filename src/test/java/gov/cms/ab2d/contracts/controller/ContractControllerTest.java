//package gov.cms.ab2d.contracts.controller;
//
//import gov.cms.ab2d.properties.AB2DPostgresqlContainer;
//import gov.cms.ab2d.properties.SpringBootApp;
//import gov.cms.ab2d.properties.repository.PropertiesRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(classes = SpringBootApp.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//@Testcontainers
//class ContractControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private PropertiesRepository propertiesRepository;
//
//    @Container
//    private static final PostgreSQLContainer POSTGRE_SQL_CONTAINER = new AB2DPostgresqlContainer();
//
//    @BeforeEach
//    void cleanUp() {
//        propertiesRepository.deleteAll();
//    }
//
//    @AfterEach
//    void cleanUpAfter() {
//        propertiesRepository.deleteAll();
//    }
//
//    @Test
//    void testList() throws Exception {
//
//        this.mockMvc.perform(get("/properties")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[]"));
//        this.mockMvc.perform(post("/properties")
//                        .param("key", "theKey")
//                        .param("value", "theValue")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//        // MockHttpServletResponse response = mvcResult.getResponse();
//        this.mockMvc.perform(get("/properties")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{\"key\": \"theKey\", \"value\": \"theValue\"}]"));
//        this.mockMvc.perform(get("/properties/theKey")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"key\": \"theKey\", \"value\": \"theValue\"}"));
//        this.mockMvc.perform(delete("/properties/theKey")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string("true"));
//        this.mockMvc.perform(get("/properties")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[]"));
//        this.mockMvc.perform(get("/properties/badKey")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//}