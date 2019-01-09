package citygenerator.controllers;

import citygenerator.controllers.CityNameGeneratorController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@RestClientTest(CityNameGeneratorController.class)
public class CityNameGeneratorControllerTest {
//
//    @Test
//    public void getName() {
//        RestTemplate restTemplate = new RestTemplate();
//        String resourceUrl
//                = "http://localhost:8080/citynamegenerator/getname";
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(resourceUrl, String.class);
//        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//    }
//
//    @Test
//    public void setSeed() {
//        RestTemplate restTemplate = new RestTemplate();
//        String resourceUrl
//                = "http://localhost:8080/citynamegenerator/setseed?seed=1234";
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(resourceUrl, String.class);
//        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//        assertThat(response.getBody(), equalTo("Random seed was changed to: 1234"));
//    }
//
//    @Test
//    public void getNames() {
//
//    }
}