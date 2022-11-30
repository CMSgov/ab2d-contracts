//package gov.cms.ab2d.contracts.service;
//
//import gov.cms.ab2d.contracts.SpringBootTestApp;
//import gov.cms.ab2d.contracts.model.Contract;
//import gov.cms.ab2d.contracts.repository.ContractRepository;
//import gov.cms.ab2d.contracts.util.AB2DPostgresqlContainer;
//import java.util.List;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest(classes = SpringBootTestApp.class)
//@Testcontainers
//class ContractServiceTest {
//    @Autowired
//    private ContractRepository contractRepository;
//
//    @Container
//    private static final PostgreSQLContainer POSTGRE_SQL_CONTAINER = new AB2DPostgresqlContainer();
//
//    private String key = "Hello";
//    private String value = "World";
//
//    private ContractService service;
//
//    @BeforeEach
//    void init() {
//        service = new ContractServiceImpl(contractRepository);
//        contractRepository.deleteAll();
//    }
//
//    @AfterEach
//    void cleanUp() {
//        contractRepository.deleteAll();
//    }
//
//    @Test
//    void testTheDb() {
//        List<Contract> properties = service.getAllContracts();
//        assertNotNull(properties);
//        assertEquals(0, properties.size());
////        assertNull(service.getProperty(null));
////        assertNull(service.getProperty("NO_KEY"));
////        assertNull(service.saveProperty(null, null));
////        assertNull(service.saveProperty(null, value));
////        PropertyDto savedProp = service.saveProperty(key, value);
////        assertNotNull(savedProp);
////        assertEquals(key, savedProp.getKey());
////        assertEquals(value, savedProp.getValue());
////        PropertyDto loadedProp = service.getProperty(key);
////        assertEquals(key, loadedProp.getKey());
////        assertEquals(value, loadedProp.getValue());
////        properties = service.getPropertiesDto();
////        assertNotNull(properties);
////        assertEquals(1, properties.size());
////        assertEquals(key, properties.get(0).getKey());
////        assertEquals(value, properties.get(0).getValue());
////        service.deleteProperty(key);
////        properties = service.getPropertiesDto();
////        assertNotNull(properties);
////        assertEquals(0, properties.size());
//    }
//
//    @Test
//    void testSaveAsSameAsInsert() {
////        List<PropertyDto> properties = service.getPropertiesDto();
////        assertNotNull(properties);
////        assertEquals(0, properties.size());
////        service.saveProperty(key, value);
////        PropertyDto loadedProp = service.getProperty(key);
////        loadedProp.setValue("New Value");
////        service.saveProperty(loadedProp.getKey(), loadedProp.getValue());
////        PropertyDto loadedProp2 = service.getProperty(key);
////        assertEquals("New Value", loadedProp2.getValue());
////        service.deleteProperty(key);
//    }
//}
