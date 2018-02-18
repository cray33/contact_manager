package my.home.contact_manager.dao;

import my.home.contact_manager.entity.ApplicationEntity;

public interface ApplicationDAO {
    ApplicationEntity getLastApplication(Long contactId);
}
