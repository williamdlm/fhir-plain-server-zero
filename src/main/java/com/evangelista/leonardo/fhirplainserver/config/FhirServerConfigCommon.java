package com.evangelista.leonardo.fhirplainserver.config;


import com.evangelista.leonardo.fhirplainserver.utils.AppProperties;
import com.google.common.base.Strings;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This is the primary configuration file for the example server
 */
@Configuration
@EnableTransactionManagement
public class FhirServerConfigCommon {

    private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(FhirServerConfigCommon.class);


    public FhirServerConfigCommon(AppProperties appProperties) {
        ourLog.info("Server configured to " + (appProperties.getAllow_contains_searches() ? "allow" : "deny") + " contains searches");
        ourLog.info("Server configured to " + (appProperties.getAllow_multiple_delete() ? "allow" : "deny") + " multiple deletes");
        ourLog.info("Server configured to " + (appProperties.getAllow_external_references() ? "allow" : "deny") + " external references");
        ourLog.info("Server configured to " + (appProperties.getExpunge_enabled() ? "enable" : "disable") + " expunges");
        ourLog.info("Server configured to " + (appProperties.getAllow_placeholder_references() ? "allow" : "deny") + " placeholder references");
        ourLog.info("Server configured to " + (appProperties.getAllow_override_default_search_params() ? "allow" : "deny") + " overriding default search params");

        if (appProperties.getSubscription().getEmail() != null) {
            AppProperties.Subscription.Email email = appProperties.getSubscription().getEmail();
            ourLog.info("Server is configured to enable email with host '" + email.getHost() + "' and port " + email.getPort());
            ourLog.info("Server will use '" + email.getFrom() + "' as the from email address");

            if (!Strings.isNullOrEmpty(email.getUsername())) {
                ourLog.info("Server is configured to use username '" + email.getUsername() + "' for email");
            }

            if (!Strings.isNullOrEmpty(email.getPassword())) {
                ourLog.info("Server is configured to use a password for email");
            }
        }

        if (appProperties.getSubscription().getResthook_enabled()) {
            ourLog.info("REST-hook subscriptions enabled");
        }

        if (appProperties.getSubscription().getEmail() != null) {
            ourLog.info("Email subscriptions enabled");
        }
    }
}
