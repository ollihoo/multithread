package de.hoogvliet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class VersionController {

    @Value("${application.version}")
    private String buildVersion;

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String getVersion() {
        return buildVersion;
    }
}
