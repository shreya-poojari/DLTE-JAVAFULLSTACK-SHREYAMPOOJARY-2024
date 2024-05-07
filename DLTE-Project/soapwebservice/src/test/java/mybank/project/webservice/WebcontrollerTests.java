package mybank.project.webservice;

import mybank.project.webservice.mvc.WebController;
import mybank.project.loansdao.interfaces.LoanInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
@AutoConfigureMockMvc
public class WebcontrollerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LoanInterface loanInterface;

    @InjectMocks
    private WebController webController;

    @Test
    public void testLandingPage() {
        WebController controller = new WebController();
        String landingPage = controller.landing();
        assertEquals("index", landingPage);
    }
    @Test
    public void testViewAllPage() {
        WebController controller = new WebController();
        String viewAllPage = controller.viewAll();
        assertEquals("viewAll", viewAllPage);
    }
    @Test
    public void testDashboardPage() {
        WebController controller = new WebController();
        String dashboardPage = controller.dashboard();
        assertEquals("dashboard", dashboardPage);
    }
    @Test
    public void testSearchPage() {
        WebController controller = new WebController();
        String searchPage = controller.search();
        assertEquals("search", searchPage);
    }
    @Test
    public void testHandleException() {
        WebController controller = new WebController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        Exception exception = new Exception("Test exception");

        ModelAndView modelAndView = controller.handleException(request, response, exception);

        assertEquals("error", modelAndView.getViewName());
        assertEquals("Test exception", modelAndView.getModel().get("errorMessage"));
    }

    }






