package my.home.contact_manager.controller;

import my.home.contact_manager.entity.GetApplicationResponse;
import my.home.contact_manager.service.ContactServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/application")
@Deprecated
public class ApplicationRestController {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationRestController.class);

    @Autowired
    private ContactServiceImpl applicationService;

    @RequestMapping(
            value = {"/{contactId}/json", "/{contactId}"},
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GetApplicationResponse getLastApplicationJson(@PathVariable String contactId) {
        return applicationService.getLastApplication(contactId);
    }

    @RequestMapping(
            value = "/{contactId}/xml",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public GetApplicationResponse getLastApplicationXml(@PathVariable String contactId) {
        return applicationService.getLastApplication(contactId);
    }

}
