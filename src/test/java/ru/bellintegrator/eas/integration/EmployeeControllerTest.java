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
import ru.bellintegrator.eas.model.Employee;
import ru.bellintegrator.eas.view.EmployeeView;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
@Sql({"classpath:init-data-employee.sql"})
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String URL = "/employee/";

  /*  @Test
    public void filterEmployee() throws Exception {
        EmployeeView ev = new EmployeeView();
        ev.setOffice(1);
        ev.setFirstName("FirstName");
        ev.setSecondName("SeName");
        ev.setMiddleName("MiddleName");
        ev.setPosition("Position");
        ev.setDocCode(10);
        ev.setCitizenshipCode(643);

        ResponseEntity<List> rs = restTemplate.postForEntity(URL + "/list", ev, List.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        List<Employee> list = rs.getBody();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);
        assertNotNull(list);
        assertThat(list.size(), is(1));
    }
*/

    @Test
    public void getEmployee() throws Exception {
        ResponseEntity<EmployeeView> rs = restTemplate.getForEntity(URL + "/1", EmployeeView.class);

        // collect response
        int statusCode = rs.getStatusCodeValue();
        EmployeeView ev = rs.getBody();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);
        assertNotNull(ev);
        assertThat(ev.getId(), is(1L));
        assertThat(ev.getFirstName(), is("FirstName"));
        assertThat(ev.getSecondName(), is("SeName"));
        assertThat(ev.getMiddleName(), is("MiddleName"));
        assertThat(ev.getPosition(), is("SeName"));
        assertThat(ev.getPhone(), is("88888"));
        assertThat(ev.getDocCode(), is(10L));
        assertThat(ev.getDocNumber(), is("12345"));
        assertThat(ev.getDocName(), is("Паспорт иностранного гражданина"));
        assertThat(ev.getCitizenshipCode(), is(643L));
        assertThat(ev.getCitizenshipName(), is("Российская Федерация"));
        assertThat(ev.getIdentified(), is(true));
        assertThat(ev.getOffice(), is(1L));

    }

    @Test
    public void updateEmployee() throws Exception {

        EmployeeView ev = new EmployeeView();
        ev.setId(1);
        ev.setFirstName("DifferentName");
        ev.setSecondName("DifferentSName");
        ev.setMiddleName("DifferentMName");
        ev.setPosition("DifferentPosition");
        ev.setPhone("77777");
        ev.setCitizenshipCode(895);
        ev.setDocCode(13);
        ev.setDocNumber("54321");
        ev.setIdentified(false);

        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/update", ev, Void.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }


    @Test
    public void saveEmployee() throws Exception {

        EmployeeView ev = new EmployeeView();
        ev.setFirstName("DifferentName");
        ev.setSecondName("DifferentSName");
        ev.setMiddleName("DifferentMName");
        ev.setPosition("DifferentPosition");
        ev.setPhone("77777");
        ev.setCitizenshipCode(895);
        ev.setDocCode(13);
        ev.setDocNumber("54321");
        ev.setIdentified(false);
        ev.setOffice(1);

        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/save", ev, Void.class);
        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }

    @Test
    public void deleteEmployee() throws Exception {
        ResponseEntity<Void> rs = restTemplate.postForEntity(URL + "/delete", 1, Void.class);

        // collect response
        int statusCode = rs.getStatusCodeValue();
        //verification
        assertEquals(HttpStatus.OK.value(), statusCode);

    }
}