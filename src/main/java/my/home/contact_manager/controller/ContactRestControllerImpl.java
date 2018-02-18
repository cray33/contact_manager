package my.home.contact_manager.controller;

import io.swagger.annotations.Api;
import my.home.contact_manager.entity.GetApplicationResponse;
import my.home.contact_manager.service.ContactService;
import my.home.contact_manager.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Api("/contact")
@Service
public class ContactRestControllerImpl implements ContactRestController {
    @Resource
    private ContactService contactService;

    @Override
    public GetApplicationResponse getLastApplicationJson(String contactId) {
        return contactService.getLastApplication(contactId);
    }

    @Override
    public GetApplicationResponse getLastApplicationXml(String contactId) {
        return contactService.getLastApplication(contactId);
    }
}
