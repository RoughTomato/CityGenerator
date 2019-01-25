package citygenerator.model.DataLayer.Entities;

import citygenerator.Application;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class NamesTest {

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Names testName1;
    private Names testName2;

    @Before
    public void setUp() {
        testName1 = new Names("testname", NameTypes.SURNAME);
        testName2 = new Names("testname2", NameTypes.CITY);
    }

    @Test
    public void nameExistsTest() {
        Names name = this.entityManager.persistAndFlush(testName1);
        assertThat(name.getName(), is("testname"));
    }

    @Test
    public void setTypeTest() {
        Names name = this.entityManager.persistAndFlush(testName2);
        name.setType(NameTypes.STORE);
        assertThat(name.getType(), is(NameTypes.STORE));
    }

    @Test
    public void setNameTest() {
        Names name = this.entityManager.persistAndFlush(testName2);
        name.setName("anotherName");
        assertThat(name.getName(), is("anotherName"));
    }

}