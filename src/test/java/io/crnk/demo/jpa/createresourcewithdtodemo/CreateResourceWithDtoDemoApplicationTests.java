package io.crnk.demo.jpa.createresourcewithdtodemo;

import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.demo.jpa.createresourcewithdtodemo.modern.ModernDTO;
import io.crnk.demo.jpa.createresourcewithdtodemo.traditional.TraditionalDTO;
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
@SpringBootTest(classes = {CreateResourceWithDtoDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class CreateResourceWithDtoDemoApplicationTests {
    private CrnkClient client;

    @Before
    public void prepareClient() {
        client = new CrnkClient("http://localhost:8080");
        ((RestTemplateAdapter) client.getHttpAdapter()).getImplementation().setRequestFactory(new OkHttp3ClientHttpRequestFactory());
    }

	@Test
	public void findExistingModernEntry() {
        ResourceRepositoryV2<ModernDTO, Long> repo = client.getRepositoryForType(ModernDTO.class);
        ModernDTO found = repo.findOne(1L, new QuerySpec(ModernDTO.class));
        assertNotNull(found);
        assertEquals(Long.valueOf(1L), found.getId());
        assertNotNull(found.getValue());
    }

    @Test
    public void editExistingModernEntry() {
        ResourceRepositoryV2<ModernDTO, Long> repo = client.getRepositoryForType(ModernDTO.class);
        ModernDTO updated = new ModernDTO();
        updated.setId(1L);
        updated.setValue("Test-Updated");
        repo.save(updated);
        ModernDTO found = repo.findOne(1L, new QuerySpec(ModernDTO.class));
        assertNotNull(found);
        assertEquals(Long.valueOf(1L), found.getId());
        assertEquals("Test-Updated", found.getValue());
    }

    @Test
    public void testCreateNewModernEntry() {
        ResourceRepositoryV2<ModernDTO, Long> repo = client.getRepositoryForType(ModernDTO.class);
        ModernDTO newDto = new ModernDTO();
        newDto.setValue("New Value");
        repo.create(newDto);
    }

    @Test
    public void findExistingTraditionalEntry() {
        ResourceRepositoryV2<TraditionalDTO, Long> repo = client.getRepositoryForType(TraditionalDTO.class);
        TraditionalDTO found = repo.findOne(11L, new QuerySpec(TraditionalDTO.class));
        assertNotNull(found);
        assertEquals(Long.valueOf(11L), found.getId());
        assertNotNull(found.getValue());
    }

    @Test
    public void editExistingTraditionalEntry() {
        ResourceRepositoryV2<TraditionalDTO, Long> repo = client.getRepositoryForType(TraditionalDTO.class);
        TraditionalDTO updated = new TraditionalDTO();
        updated.setId(11L);
        updated.setValue("Test-Updated");
        repo.save(updated);
        TraditionalDTO found = repo.findOne(11L, new QuerySpec(TraditionalDTO.class));
        assertNotNull(found);
        assertEquals(Long.valueOf(11L), found.getId());
        assertEquals("Test-Updated", found.getValue());
    }

    @Test
    public void testCreateNewTraditionalEntry() {
        ResourceRepositoryV2<TraditionalDTO, Long> repo = client.getRepositoryForType(TraditionalDTO.class);
        TraditionalDTO newDto = new TraditionalDTO();
        newDto.setValue("New Value");
        repo.create(newDto);
    }
}
