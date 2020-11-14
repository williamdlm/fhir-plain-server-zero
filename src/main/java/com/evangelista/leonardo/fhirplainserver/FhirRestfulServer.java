package com.evangelista.leonardo.fhirplainserver;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.EncodingEnum;
import ca.uhn.fhir.rest.server.RestfulServer;
import ca.uhn.fhir.rest.server.interceptor.ResponseHighlighterInterceptor;
import com.evangelista.leonardo.fhirplainserver.controllers.PatientResourceProvider;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.Arrays;

@WebServlet(urlPatterns = { "/*" }, displayName = "FHIR Server")
public class FhirRestfulServer extends RestfulServer {

    private ApplicationContext applicationContext;

    FhirRestfulServer(ApplicationContext context) {
        this.applicationContext = context;
    }

    @Override
    protected void initialize() throws ServletException {
        super.initialize();
        ApplicationContext appCtx = (ApplicationContext) getServletContext()
                .getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");


        // Add your own customization here
        setFhirContext(FhirContext.forR4());

        setDefaultPrettyPrint(true);
        setDefaultResponseEncoding(EncodingEnum.JSON);

        setResourceProviders(Arrays.asList(
                applicationContext.getBean(PatientResourceProvider.class)
        ));

        registerInterceptor(new ResponseHighlighterInterceptor());
    }
}
