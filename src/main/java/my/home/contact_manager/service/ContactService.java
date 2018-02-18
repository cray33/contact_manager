package my.home.contact_manager.service;

import my.home.contact_manager.entity.GetApplicationResponse;

public interface ContactService {
    public GetApplicationResponse getLastApplication(String contactIdRaw);
}
