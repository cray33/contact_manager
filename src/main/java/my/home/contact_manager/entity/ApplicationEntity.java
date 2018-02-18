package my.home.contact_manager.entity;


import my.home.contact_manager.utils.JsonDateSerializer;
import  org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public class ApplicationEntity {
    @JsonProperty("APPLICATION_ID")
    private Long applicationId;

    @JsonProperty("CONTACT_ID")
    private Long contactId;

    @JsonProperty("DB_CREATED")
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date dtCreated;

    @JsonProperty("PRODUCT_NAME")
    private String productName;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationEntity that = (ApplicationEntity) o;

        if (applicationId != null ? !applicationId.equals(that.applicationId) : that.applicationId != null)
            return false;
        if (contactId != null ? !contactId.equals(that.contactId) : that.contactId != null) return false;
        if (dtCreated != null ? !dtCreated.equals(that.dtCreated) : that.dtCreated != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicationId != null ? applicationId.hashCode() : 0;
        result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
        result = 31 * result + (dtCreated != null ? dtCreated.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }
}
