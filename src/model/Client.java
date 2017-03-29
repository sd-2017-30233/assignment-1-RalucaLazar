package model;

import Gateway.ClientGateway;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Raluca on 22.03.2017.
 */
public class Client {
    private int id;
    private String name;
    private String idCardNumber;
    private String PNC;
    private String address;
    public ClientGateway clientGateway;

    public Client(){
        clientGateway = new ClientGateway();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public String getPNC() {
        return PNC;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public void setPNC(String PNC) {
        this.PNC = PNC;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isValid(Connection conn) throws SQLException {
        if(clientGateway.exists(conn,this.getName())) return true;
        else return false;
    }

    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", idCardNumber=" + idCardNumber
                + ", PNC=" + PNC + ", address=" + address + "]";
    }
}
