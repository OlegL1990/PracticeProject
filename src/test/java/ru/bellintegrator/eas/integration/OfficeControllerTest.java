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
import ru.bellintegrator.eas.model.Office;
import ru.bellintegrator.eas.view.OfficeView;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
@Sql({"classpath:init-data-office.sql"})
public class OfficeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String URL = "/office/";

    @Test
    public void filterOffice() throws Exception {
        OfficeView ov = new OfficeView();
        ov.setOrg(1);
        ov.setName("Name");
        ov.setPhone("88888");
        ov.setActive(true);

        ResponseEntity<List> rs = restTemplate.postForEntity(URL + "/list", ov,List.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        List<Office> list = rs.getBody();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);
        assertNotNull(list);
        assertThat(list.size(), is(1));
    }
    @Test
    public void getOffice() throws Exception {
        ResponseEntity<OfficeView> rs = restTemplate.getForEntity(URL + "/1", OfficeView.class);

        // collect response
        int statusCode = rs.getStatusCodeValue();
        OfficeView ov = rs.getBody();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);
        assertNotNull(ov);
        assertThat(ov.getId(), is(1L));
        assertThat(ov.getName(), is("Name"));
        assertThat(ov.getAddress(), is("Address"));
        assertThat(ov.getPhone(), is("88888"));
        assertThat(ov.getActive(), is(true));
        assertThat(ov.getOrg(),is(1L));
    }

    @Test
    public void updateOffice() throws Exception {

        OfficeView ov = new OfficeView();
        ov.setId(1);
        ov.setName("DifferentName");
        ov.setAddress("DiffAddress");
        ov.setPhone("77777");
        ov.setActive(false);

        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/update", ov, Void.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }


    @Test
    public void saveOffice() throws Exception {

        OfficeView ov = new OfficeView();
        ov.setName("DifferentName");
        ov.setAddress("DiffAddress");
        ov.setPhone("77777");
        ov.setActive(false);
        ov.setOrg(1);

        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/save", ov, Void.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }

    @Test
    public void deleteOffice() throws Exception {
        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/delete",1, Void.class);

        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }
}
