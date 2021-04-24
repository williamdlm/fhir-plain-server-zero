package com.evangelista.leonardo.fhirplainserver.config;

import com.evangelista.leonardo.fhirplainserver.providers.PatientResourceProvider;

import javax.servlet.ServletException;
import java.util.Arrays;

public class PlainRestfulServer extends BasePlainRestfulServer {

    @Override
    protected void initialize() throws ServletException {
        super.initialize();

        setResourceProviders(Arrays.asList(
                myApplicationContext.getBean(PatientResourceProvider.class)
        ));

    }
}
