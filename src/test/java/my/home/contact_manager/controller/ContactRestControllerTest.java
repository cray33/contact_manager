package my.home.contact_manager.controller;

import my.home.contact_manager.entity.GetApplicationResponse;
import my.home.contact_manager.entity.ResponseCode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactRestControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getLastApplicationJson() throws IOException {
        ResponseEntity<String> response = this.restTemplate.getForEntity("/rest/contact/-1/application/json", String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().get("Content-Type").get(0));
        Assert.assertTrue(response.hasBody());

        GetApplicationResponse object = mapper.readValue(response.getBody(), GetApplicationResponse.class);
        Assert.assertNotNull(object);
        Assert.assertNotNull(object.getResponseCode());
    }

    @Test
    public void getLastApplicationXml() throws IOException {
        ResponseEntity<String> response = this.restTemplate.getForEntity("/rest/contact/-1/application/xml", String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertTrue(response.hasBody());
        Assert.assertEquals(MediaType.APPLICATION_XML, response.getHeaders().get("Content-Type").get(0));

    }

}
