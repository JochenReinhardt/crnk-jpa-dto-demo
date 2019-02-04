package io.crnk.demo.jpa.manytomany;

import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.demo.jpa.manytomany.left.LeftDTO;
import io.crnk.demo.jpa.manytomany.right.RightDTO;
import io.crnk.spring.client.RestTemplateAdapter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ManyToManyDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class ManyToManyDemoApplicationTests {
    private CrnkClient client;

    @Before
    public void prepareClient() {
        client = new CrnkClient("http://localhost:8080/api");
        ((RestTemplateAdapter) client.getHttpAdapter()).getImplementation().setRequestFactory(new OkHttp3ClientHttpRequestFactory());
    }

    public void testGetLefts() {
        ResourceRepositoryV2<LeftDTO, Serializable> leftRepository = client.getRepositoryForType(LeftDTO.class);
        ResourceList<LeftDTO> lefts = leftRepository.findAll(new QuerySpec(LeftDTO.class));
        assertNotNull(lefts);
        assertEquals(10, lefts.size());
    }

    public void testGetRights() {
        ResourceRepositoryV2<RightDTO, Serializable> leftRepository = client.getRepositoryForType(RightDTO.class);
        ResourceList<RightDTO> rights = leftRepository.findAll(new QuerySpec(RightDTO.class));
        assertNotNull(rights);
        assertEquals(10, rights.size());
    }


}
