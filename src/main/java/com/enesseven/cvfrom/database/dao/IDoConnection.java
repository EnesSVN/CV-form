package com.enesseven.cvfrom.database.dao;

import com.enesseven.cvfrom.database.database.DatabaseConnection;
import com.enesseven.cvfrom.database.dto.CvDto;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDoConnection <T>{


    public void create(T t);


    default Connection getInterfaceConnection(){
        return DatabaseConnection.getInstance().getConnection();
    }

    ArrayList<CvDto> list();
}
