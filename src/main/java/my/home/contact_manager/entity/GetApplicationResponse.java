package my.home.contact_manager.entity;

import  org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class GetApplicationResponse {
    @JsonProperty("RESPONSE_CODE")
    private ResponseCode responseCode;

    @JsonProperty("ERROR_MESSAGE")
    private String errorMessage;

    @JsonProperty("APPLICATION")
    private ApplicationEntity application;

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }
}
