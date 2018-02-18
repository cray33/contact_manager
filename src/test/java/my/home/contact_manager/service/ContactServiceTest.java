package my.home.contact_manager.service;

import my.home.contact_manager.entity.ApplicationEntity;
import my.home.contact_manager.entity.GetApplicationResponse;
import my.home.contact_manager.entity.ResponseCode;
import org.junit.Assert;
import my.home.contact_manager.dao.ApplicationDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

    @Mock
    ApplicationDAO applicationDAO;

    @InjectMocks
    ContactService contactService = new ContactServiceImpl();

    @Test
    public void getLastApplicationInvalidParams() {
        GetApplicationResponse response = contactService.getLastApplication("asdf");

        Assert.assertNotNull(response);
        Assert.assertEquals(ResponseCode.INCORRECT_PARAMETERS, response.getResponseCode());
        Assert.assertNotNull(response.getErrorMessage());
        Assert.assertNull(response.getApplication());
        verify(applicationDAO, never()).getLastApplication(anyLong());
    }

    @Test
    public void getLastApplicationDbError() {
        Mockito.when(applicationDAO.getLastApplication(anyLong())).thenThrow(new RuntimeException("DB error"));
        GetApplicationResponse response = contactService.getLastApplication("123");

        Assert.assertNotNull(response);
        Assert.assertEquals(ResponseCode.DB_ERROR, response.getResponseCode());
        Assert.assertNotNull(response.getErrorMessage());
        Assert.assertNull(response.getApplication());
    }

    @Test
    public void getLastApplicationNotFound() {
        Mockito.when(applicationDAO.getLastApplication(anyLong())).thenReturn(null);

        GetApplicationResponse response = contactService.getLastApplication("123");

        Assert.assertNotNull(response);
        Assert.assertEquals(ResponseCode.NOT_FOUND, response.getResponseCode());
        Assert.assertNotNull(response.getErrorMessage());
        Assert.assertNull(response.getApplication());
    }

    @Test
    public void getLastApplicationSuccess() {
        ApplicationEntity application = new ApplicationEntity();
        application.setApplicationId(1L);
        application.setContactId(1L);
        application.setDtCreated(new Date());
        application.setProductName("Product name");

        Mockito.when(applicationDAO.getLastApplication(123L)).thenReturn(application);

        GetApplicationResponse response = contactService.getLastApplication("123");

        Assert.assertNotNull(response);
        Assert.assertEquals(ResponseCode.OK, response.getResponseCode());
        Assert.assertNull(response.getErrorMessage());
        Assert.assertNotNull(response.getApplication());
        Assert.assertEquals(application, response.getApplication());


    }
}
