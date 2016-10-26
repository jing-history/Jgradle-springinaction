package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static com.habuma.spitter.mvc.HomeController.DEFAULT_SPITTLES_PER_PAGE;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by wangyunjing on 2016/10/26.
 */
public class HomeControllerTest {

    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpittles = asList(new Spittle(), new Spittle(), new Spittle());
        SpitterService spitterService = mock(SpitterService.class);
        when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).
                thenReturn(expectedSpittles);
        //<co id="co_createController"/>
        HomeController controller = new HomeController(spitterService);
        HashMap<String, Object> model = new HashMap<>();
        String viewName = controller.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedSpittles, model.get("spittles"));

        verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
    }
}