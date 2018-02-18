package my.home.contact_manager.service;


import my.home.contact_manager.dao.ApplicationDAO;
import my.home.contact_manager.dao.ApplicationDAOImpl;
import my.home.contact_manager.entity.ApplicationEntity;
import my.home.contact_manager.entity.GetApplicationResponse;
import my.home.contact_manager.entity.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;


@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ApplicationDAO applicationDAO;

    @Override
    public GetApplicationResponse getLastApplication(String contactIdRaw) {
        GetApplicationResponse response = new GetApplicationResponse();

        //------- validate contactId -----------
        Long contactId = null;
        try {
            contactId = Long.parseLong(contactIdRaw);
        } catch (NumberFormatException ex) {
            response.setResponseCode(ResponseCode.INCORRECT_PARAMETERS);
            response.setErrorMessage("Incorrect contactId parameter. Must be LONG.");
            return response;
        }

        //-------- get Application -----------
        ApplicationEntity application = null;
        try {
            application = applicationDAO.getLastApplication(contactId);
        } catch (Exception ex) {
            String errorUUID = UUID.randomUUID().toString();
            LOG.error(MessageFormat.format("DB error. UUID = {0}", errorUUID), ex);

            response.setResponseCode(ResponseCode.DB_ERROR);
            response.setErrorMessage(MessageFormat.format("DB error. UUID = {0}", errorUUID));
            return response;
        }

        if (application == null) {
            response.setResponseCode(ResponseCode.NOT_FOUND);
            response.setErrorMessage(MessageFormat.format("Not found Application for contactId = {0}", contactId));
            return response;
        }

        //--------- success ---------
        response.setResponseCode(ResponseCode.OK);
        response.setApplication(application);
        return response;
    }


}
