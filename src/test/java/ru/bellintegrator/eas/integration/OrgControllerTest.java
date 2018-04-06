package ru.bellintegrator.eas.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import ru.bellintegrator.eas.model.Org;
import ru.bellintegrator.eas.view.OrgView;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
@Sql({ "classpath:init-data-org.sql" })
public class OrgControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String URL = "/org/";

    @Test
      public void filterOrg() throws Exception {
        OrgView orv = new OrgView();
        orv.setName("Name");
        orv.setInn("12345");
        orv.setActive(true);

        ResponseEntity<List> rs = restTemplate.postForEntity(URL + "/list", orv,List.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        List<Org> list = rs.getBody();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);
        assertNotNull(list);
        assertThat(list.size(), is(1));
    }
    @Test
    public void getOrg() throws Exception {
        ResponseEntity<OrgView> rs = restTemplate.getForEntity(URL + "/1", OrgView.class);

        // collect response
        int statusCode = rs.getStatusCodeValue();
        OrgView orv = rs.getBody();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);
        assertNotNull(orv);
        assertThat(orv.getId(), is(1L));
        assertThat(orv.getName(), is("Name"));
        assertThat(orv.getFullName(), is("FullName"));
        assertThat(orv.getInn(), is("12345"));
        assertThat(orv.getKpp(), is("12345"));
        assertThat(orv.getAddress(), is("Address"));
        assertThat(orv.getPhone(), is("88888"));
        assertThat(orv.getActive(), is(true));
    }

    @Test
    public void updateOrg() throws Exception {

        OrgView orv = new OrgView();
        orv.setId(1);
        orv.setName("DifferentName");
        orv.setFullName("DifferentFullName");
        orv.setInn("54321");
        orv.setKpp("54321");
        orv.setAddress("DiffAddress");
        orv.setPhone("77777");
        orv.setActive(false);

        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/update", orv, Void.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }


    @Test
    public void saveOrg() throws Exception {

        OrgView orv = new OrgView();
        orv.setName("DifferentName");
        orv.setFullName("DifferentFullName");
        orv.setInn("54321");
        orv.setKpp("54321");
        orv.setAddress("DiffAddress");
        orv.setPhone("77777");
        orv.setActive(false);

        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/save", orv, Void.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }

    @Test
    public void deleteOrg() throws Exception {
        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/delete",1, Void.class);

        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }

}
