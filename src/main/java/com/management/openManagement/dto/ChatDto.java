package com.management.openManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatDto {

    @JsonProperty("clientRequest")
    private String clientRequest;

    @JsonProperty("serverResponse")
    private String serverResponse;

    public String getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(String clientRequest) {
        this.clientRequest = clientRequest;
    }

    public String getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(String serverResponse) {
        this.serverResponse = serverResponse;
    }
}
