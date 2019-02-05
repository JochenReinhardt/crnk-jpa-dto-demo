package io.crnk.demo.jpa.computedvalue;

import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.demo.jpa.computedvalue.computed.ComputedDTO;
import io.crnk.demo.jpa.computedvalue.plain.PlainDTO;
import io.crnk.spring.client.RestTemplateAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ComputedValueDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class ComputedValueDemoApplicationTests {
    private CrnkClient client;

    @Before
    public void prepareClient() {
        client = new CrnkClient("http://localhost:8080");
        ((RestTemplateAdapter) client.getHttpAdapter()).getImplementation().setRequestFactory(new OkHttp3ClientHttpRequestFactory());
    }

	@Test
	public void findPlain() {
        ResourceRepositoryV2<PlainDTO, Long> repo = client.getRepositoryForType(PlainDTO.class);
        PlainDTO found = repo.findOne(1L, new QuerySpec(PlainDTO.class));
        assertNotNull(found);
        assertEquals(Long.valueOf(1L), found.getId());
        assertNotNull(found.getValue());
    }

    @Test
    public void findComputed() {
        ResourceRepositoryV2<ComputedDTO, Long> repo = client.getRepositoryForType(ComputedDTO.class);
        ComputedDTO found = repo.findOne(11L, new QuerySpec(ComputedDTO.class));
        assertNotNull(found);
        assertEquals(Long.valueOf(11L), found.getId());
        assertNotNull(found.getValue());
    }

}
