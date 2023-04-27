package com.mv.course.fhirplainserver.config;

import com.mv.course.fhirplainserver.providers.PatientProvider;

import javax.servlet.ServletException;
import java.util.Arrays;

public class PlainRestfulServer extends BasePlainRestfulServer {

    @Override
    protected void initialize() throws ServletException {
        super.initialize();

        setResourceProviders(Arrays.asList(
                myApplicationContext.getBean(PatientProvider.class)
        ));

    }
}
