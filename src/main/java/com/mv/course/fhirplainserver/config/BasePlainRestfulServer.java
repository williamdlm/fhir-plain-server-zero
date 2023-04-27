package com.mv.course.fhirplainserver.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.EncodingEnum;
import ca.uhn.fhir.rest.server.RestfulServer;
import ca.uhn.fhir.rest.server.interceptor.ResponseHighlighterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;

public class BasePlainRestfulServer extends RestfulServer {

    @Autowired
    ApplicationContext myApplicationContext;

    public BasePlainRestfulServer() {
    }

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    protected void initialize() throws ServletException {
        super.initialize();

        // Add your own customization here
        setFhirContext(FhirContext.forR4());

        setDefaultPrettyPrint(true);
        setDefaultResponseEncoding(EncodingEnum.JSON);

        registerInterceptor(new ResponseHighlighterInterceptor());

    }


}
