package com.enesseven.cvfrom.database.dao;

import com.enesseven.cvfrom.database.dto.CvDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Log4j2
public class CvDao implements  IDoConnection<CvDto>{


    @Override
    public void create(CvDto cvDto) {
        try (Connection connection = getInterfaceConnection()){
            String sql = "insert into cv(name,surname,email,message) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cvDto.getName());
            preparedStatement.setString(2,cvDto.getSurname());
            preparedStatement.setString(3,cvDto.getEmail());
            preparedStatement.setString(4,cvDto.getMessage());
            int rowEffected = preparedStatement.executeUpdate();
            if (rowEffected>0){
                log.info("product added successfully");
            }else{
                log.error("product not added");
            }

        } catch (Exception e) {
            log.error(CvDao.class + " Error during the insertion");
            e.printStackTrace();
        }
    }



    @Override
    public ArrayList<CvDto> list() {
        ArrayList<CvDto> listem = new ArrayList<>();
        CvDto productDto;
        try (Connection connection = getInterfaceConnection()){
            String sql = "select * from product";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productDto = new CvDto();
                productDto.setId(resultSet.getInt("id"));
                productDto.setName(resultSet.getString("name"));
                productDto.setSurname(resultSet.getString("surname"));
                productDto.setEmail(resultSet.getString("email"));
                productDto.setMessage(resultSet.getString("message"));

                listem.add(productDto);
            }
        } catch (Exception e) {
            log.error(CvDao.class + " Error during the delete");
            e.printStackTrace();
        }
        return listem;
    }
}
