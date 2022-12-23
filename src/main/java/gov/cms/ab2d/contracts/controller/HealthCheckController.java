package gov.cms.ab2d.contracts.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@Slf4j
public class HealthCheckController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/health")
    public ResponseEntity<Void> getHealth() {
        try {
            jdbcTemplate.query("SELECT 1", x -> {
            });
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Healthcheck failed", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}