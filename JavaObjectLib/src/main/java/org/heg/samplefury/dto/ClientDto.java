package org.heg.samplefury.dto;

import org.fm.fury.annotation.FuryObject;

@FuryObject
public class ClientDto {

    public ClientDto(Long clientId, String firstname, String lastname, String country) {
        this.clientId = clientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
    }

    public ClientDto() {}

    private Long clientId;

    private String firstname;

    private String lastname;

    private String country;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "clientId=" + clientId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
