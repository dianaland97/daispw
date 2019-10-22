package dao;

import entity.*;
import enumeration.Cities;
import enumeration.Services;
import sun.text.normalizer.UnicodeMatcher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AptManagementDAO {

    public static Apartment getInformationApt(String nickname, int idApt) {

        Apartment apartment = null;
        List<Room> room = AptManagementDAO.getInformationRooms(nickname, idApt) ;
        RegisteredUser registeredUser = AptManagementDAO.getUser(nickname);
        List<String> imgPath = AptManagementDAO.getImageApt(idApt);
        List<Service> services = AptManagementDAO.getInformationServices(idApt);

        try {
            PreparedStatement preparedStatement = DBhelper.getDBInstance().getConnection().prepareStatement(Query.selectApt, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Connection connection = DBhelper.getDBInstance().getConnection();
            //PreparedStatement preparedStatement = null;
            //preparedStatement = connection.prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, nickname);
            preparedStatement.setInt (2, idApt);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) //rs empty
                return null;
            else {
                resultSet.first();
                // lettura delle colonne "by name"
                do{
                    String ownernick = resultSet.getString("ownernick");
                    String address = resultSet.getString("address");
                    String cap = resultSet.getString("cap");
                    String city = resultSet.getString("city");
                    String plane = resultSet.getString("plane");
                    String indoor = resultSet.getString("indoor");
                    String stair = resultSet.getString("stair");
                    double totaldimension = resultSet.getDouble("totaldimension");
                    double freespace = resultSet.getDouble("freespace");
                    int numberorooms = resultSet.getInt("numberofrooms");
                    String state = resultSet.getString("state");
                    String title = resultSet.getString("title");
                    String shortdescription = resultSet.getString("shortdescription");
                    String fulldescription = resultSet.getString("fulldescription");
                    double agvevaluation = resultSet.getDouble("agvevaluation");
                    String creationdate = resultSet.getString("creationdate");
                    double rentcost = resultSet.getDouble("rentcost");
                    apartment = new Apartment(idApt, city, agvevaluation, registeredUser, address, cap, plane,
                            indoor, stair, imgPath, services, title, room, shortdescription, totaldimension, freespace,
                            numberorooms, state, rentcost);

                }while (resultSet.next());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return apartment;
    }

    public static List<Room> getInformationRooms(String nickname, int idApt) {
        List<Room> rooms = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DBhelper.getDBInstance().getConnection().prepareStatement(Query.selectRoomOfApt, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Connection connection = DBhelper.getDBInstance().getConnection();
            //PreparedStatement preparedStatement = null;
            //preparedStatement = connection.prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, nickname);
            preparedStatement.setInt(2, idApt);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) //rs empty
                return null;
            else {
                resultSet.first();
                // lettura delle colonne "by name"
                do{
                    int id = resultSet.getInt("id");
                    double dimension = resultSet.getDouble("dimension");
                    String category = resultSet.getString("category");
                    double rentcost = resultSet.getDouble("rentcost");
                    rooms.add(new Room(id,dimension,category,rentcost));
                }while (resultSet.next());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public static List<Service> getInformationServices(int idApt) {
        List<Service> services = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DBhelper.getDBInstance().getConnection().prepareStatement(Query.selectServiceApt, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Connection connection = DBhelper.getDBInstance().getConnection();
            //PreparedStatement preparedStatement = null;
            //preparedStatement = connection.prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, idApt);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) //rs empty
                return null;
            else {
                resultSet.first();
                // lettura delle colonne "by name"
                do{
                    String nameserv = resultSet.getString("nameserv");
                    services.add(new Service(nameserv, idApt));
                }while (resultSet.next());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public static List<String> getImageApt(int idApt) {
        List<String> image = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DBhelper.getDBInstance().getConnection().prepareStatement(Query.selectImageApt, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Connection connection = DBhelper.getDBInstance().getConnection();
            //PreparedStatement preparedStatement = null;
            //preparedStatement = connection.prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, idApt);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) //rs empty
                return null;
            else {
                resultSet.first();
                // lettura delle colonne "by name"
                do{
                    String imagePath = resultSet.getString("imagepath");
                    image.add(imagePath);
                }while (resultSet.next());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static RegisteredUser getUser(String nickname) {
        RegisteredUser user = null;

        try {
            PreparedStatement preparedStatement = DBhelper.getDBInstance().getConnection().prepareStatement(Query.selectUser, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Connection connection = DBhelper.getDBInstance().getConnection();
            //PreparedStatement preparedStatement = null;
            //preparedStatement = connection.prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) //rs empty
                return null;
            else {
                resultSet.first();
                // lettura delle colonne "by name"
                do{
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    String email = resultSet.getString("email");
                    String img = resultSet.getString("profileimg");
                    user = new RegisteredUser(nickname, password,email, role, img);
                }while (resultSet.next());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public static Vector<Integer> getIdApt(String nickname) {
        Vector<Integer> app = new Vector<Integer>();
        try {

            PreparedStatement preparedStatement = DBhelper.getDBInstance().getConnection().prepareStatement(Query.selectApt, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Connection connection = DBhelper.getDBInstance().getConnection();
            //PreparedStatement preparedStatement = null;
            //preparedStatement = connection.prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) //rs empty
                return app;
            else {
                resultSet.first();
                // lettura delle colonne "by name"
                do{
                    System.out.println(resultSet);
                    int aptId = resultSet.getInt("id");
                    app.add(aptId);
                }while (resultSet.next());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return app;
    }
}


