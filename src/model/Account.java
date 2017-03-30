package model;

import service.AccountService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Raluca on 22.03.2017.
 */
public class Account {
    private int id;
    private String type;
    private float amount;
    private String date;
    private int clientId;
    public AccountService accountGateway;

    public Account(){
        accountGateway  = new AccountService();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public boolean isValid(Connection conn, int id) throws SQLException {
        if(accountGateway.exists(conn,id)) return true;
        else return false;
    }

    public String toString() {
        return "Account [id=" + id + ", type=" + type + ", amount=" + amount
                + ", date=" + date + ", client_id=" + clientId + "]";
    }
}
