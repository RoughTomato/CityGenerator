package citygenerator

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert NamesController response for all`() {
        val resourceUrl = "http://localhost:8080/names/all"
        val response = restTemplate.getForEntity("$resourceUrl/1", String::class.java)
        assertThat(response.statusCode, equalTo(HttpStatus.OK))
    }

}