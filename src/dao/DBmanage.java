package dao;

//import entity.Apartment;
import enumeration.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBmanage {
    private static DBmanage dbm = null;

    private final static String[] fintables = {"reguser", "service", "apartment", "aptService", "room",
                                        "tenannfilter", "tenfilservice", "aptimage"};


    private static String[] tables = {"'RegUser'"};
    private static String[] createTabQueries = new String[fintables.length];

    private Connection con = null;

    private DBmanage(){}

    private DBmanage(boolean rebuild){
        if(rebuild) {
            //deleteAllTables();
            //initializeDB();
            //System.out.println("Inserting random values...");
            //fillDummy(1000, 3, 3);
            System.out.println("Complete");
        }
    }

    private void initializeDB(){
        boolean allright = true;

        con = DBhelper.getDBInstance().getConnection();

        tablesquery();

        //database table creation
        PreparedStatement ps;
        for(int i = 0; i < createTabQueries.length; i++){
            try {
                ps = con.prepareStatement(createTabQueries[i]);
                ps.executeUpdate();
            } catch (SQLException e) {
                allright = false;
                System.out.println("Error at table" + i);
                System.out.println(createTabQueries[i]);
                e.printStackTrace();
            }
        }
        if(allright){
            System.out.println("All tables created correctly");
        }else{
            System.exit(-1);
        }

        //insert services
        PreparedStatement serviceps;
        for(int i = 0; i < Services.numberofservices; i++){
            try {
                serviceps = con.prepareStatement(Query.insertService);
                serviceps.setString(1, String.valueOf(Services.values()[i]));
                serviceps.executeUpdate();//-----------SERVICE INSERT----
            }catch (SQLException e) {
                System.out.println("Error inserting service #" + i);
                e.printStackTrace();
            }
        }

        DBhelper.getDBInstance().conClose();
    }

    private void deleteAllTables(){
        boolean allright = true;
        con = DBhelper.getDBInstance().getConnection();

        tablesquery();

        //database table creation
        PreparedStatement ps;
        String query;
        for(int i = 0; i < fintables.length; i++){
            try {
                query = "DROP TABLE IF EXISTS \"" + fintables[i] + "\" CASCADE;";
                ps = con.prepareStatement(query);
                ps.executeUpdate();
            } catch (SQLException e) {
                allright = false;
                System.out.println("Error deleting table" + i);
                e.printStackTrace();
            }
        }
        if(allright){
            System.out.println("All tables successfully deleted");
        }
        DBhelper.getDBInstance().conClose();
    }


    private boolean checkServices(Services[] services, String[] matchedServices) {
        boolean[] matchFound = new boolean[services.length];

        for(int currserv = 0; currserv < services.length; currserv++){
            matchFound[currserv] = false;
            for(int matcurrserv = 0; matcurrserv < matchedServices.length; matcurrserv++){
                if(services[currserv].equals(matchedServices[matcurrserv])){
                    matchFound[currserv] = true;
                }
            }
        }

        for(int i = 0; i < matchFound.length; i++){
            if(!matchFound[i]){
                return false;
            }
        }
        return true;
    }

    private boolean imgExists(String s) {
        return false;
    }

    public static void prepareDB(Boolean rebuild){
        if(dbm == null){
            dbm = new DBmanage(rebuild);
        }
    }
    public static DBmanage getDBMistance(){
        if(dbm == null){
            dbm = new DBmanage(false);
        }
        return dbm;
    }

    private void tablesquery(){

        //User
        createTabQueries[0] = "CREATE TABLE IF NOT EXISTS " + fintables[0] +
                "(nickname VARCHAR(255) PRIMARY KEY, " +
                "password VARCHAR(255), " +
                "name VARCHAR(255), " +
                "surname VARCHAR(255), " +
                "role VARCHAR(255), " +
                "email VARCHAR(255), " +
                "profileimg VARCHAR(255))";

        //service
        createTabQueries[1] = "CREATE TABLE IF NOT EXISTS " + fintables[1] +
            "(name VARCHAR(255) PRIMARY KEY)";

        //apartment
        createTabQueries[2] = "CREATE TABLE IF NOT EXISTS " + fintables[2] +
            "(id SERIAL PRIMARY KEY, " +
            "ownernick VARCHAR(255) " +
                "REFERENCES RegUser(nickname), " +
            "address VARCHAR(255), " +
            "cap VARCHAR(255), " +
            "city VARCHAR(255), " +
            "plane VARCHAR(255), " +
            "indoor VARCHAR(255), " +
            "stair VARCHAR(255), " +
            "totalDimension DECIMAL(8,2), " +
            "freeSpace DECIMAL(8,2), " +
            "numberOfRooms INTEGER, " +
            "state VARCHAR(255), " +
            "title VARCHAR(255), " +
            "shortdescription VARCHAR(255), " +
            "fulldescription VARCHAR(255), " +
            "avgevaluation DECIMAL(2,1), " +
            "creationDate VARCHAR(255), " +
            "rentcost DECIMAL(7, 2))";

        //aptservice
        createTabQueries[3] = "CREATE TABLE IF NOT EXISTS " + fintables[3] +
            "(idApt INTEGER " +
                "REFERENCES Apartment(id)," +
            "nameServ VARCHAR(255) " +
                "REFERENCES Service(name)," +
            "PRIMARY KEY (idApt, nameServ))";

        //room
        createTabQueries[4] = "CREATE TABLE IF NOT EXISTS " + fintables[4] +
            "(id SERIAL PRIMARY KEY, " +
            "idapartment INTEGER " +
                "REFERENCES Apartment(id), " +
            "dimension DECIMAL(5,2), " +
            "category VARCHAR(255), " +
            "rentcost DECIMAL(7,2))";

        //tenannfilter
        createTabQueries[5] = "CREATE TABLE IF NOT EXISTS " + fintables[5] +
                "(id SERIAL PRIMARY KEY, " +
                "owner VARCHAR(255) " +
                        "REFERENCES RegUser(nickname), " +
                "costRange VARCHAR(255), " +
                "city VARCHAR(255), " +
                "creationDate VARCHAR(255))";

        //tenfilservices
        createTabQueries[6] = "CREATE TABLE IF NOT EXISTS " + fintables[6] +
                "(idTenFil INTEGER " +
                    "REFERENCES TenAnnFilter(id), " +
                "service VARCHAR(255) " +
                    "REFERENCES Service(name), " +
                "PRIMARY KEY(idTenFil, service))";

        //aptimages
        createTabQueries[7] = "CREATE TABLE IF NOT EXISTS " + fintables[7] +
            "(idApartment INTEGER " +
                "REFERENCES Apartment(id), " +
            "imagepath VARCHAR(255), " +
                "PRIMARY KEY (idApartment, imagepath))";
    }

}

/*
    private void fillDummy(int usrnumber, int apartnumber, int tenfilnumber) {
        Random rnd = new Random();
        RegisteredUserDAO rad = new RegisteredUserDAO();
        ApartmentDAO apd = new ApartmentDAO();


        String role;
        for(int i = 0; i < usrnumber; i++){
            if(rnd.nextInt(10) < 7){
                role = "landlord";
            }else{
                role = "tenant";
            }
            RegisteredUser ru = new RegisteredUser("user" + i, "pass" + i, "name" + i, "surname" + i,
                "email" + i + "@", role, "known_user_200x200.png");
            rad.insertUser(ru);

            if(role.equals("landlord")){
                int n = rnd.nextInt(apartnumber);
                for(int j = 0; j < n; j++)
                Apartment apt = new Apartment(0, "");
            }
        }
        //setup services
        PreparedStatement serviceps;
        for(int i = 0; i < Services.numberofservices; i++){
            try {
                serviceps = con.prepareStatement(Query.insertService);
                serviceps.setString(1, String.valueOf(Services.values()[i]));
                serviceps.executeUpdate();//-----------SERVICE INSERT----
            }catch (SQLException e) {
                System.out.println("Error inserting service #" + i);
                e.printStackTrace();
            }
        }

        Random rnd = new Random();
        int n = 0;
        PreparedStatement userps;

        for(int i = 0; i < usrnumber; i++){
            try{
                n = 0;
                //insert user with random role

                userps = con.prepareStatement(Query.insertUser);
                userps.setString(1, "user" + i);
                userps.setString(2, "passusr" + i);
                userps.setString(3, "name" + i);
                userps.setString(4, "surname" + i);
                userps.setString(6, "mail" + i);
                n = rnd.nextInt(10);
                //System.out.println(n);

                if(n > 3){
                    userps.setString(5, "landlord");
                }else {
                    userps.setString(5, "tenant");
                }
                userps.setString(7, "images/known_user_200x200.png");

                userps.executeUpdate();//--------------USER INSERT--------------

                if(n > 3) { //created user is renter
                    //make up to y apartments
                    n = rnd.nextInt(apartnumber) + 1;
                    //to register as a renter you need to add at lease an apartment
                    PreparedStatement apartps;
                    double avgeval;
                    for(int j = 0; j < n; j++){
                            apartps = con.prepareStatement(Query.insertApartment);

                            //id, city, name, description, user, evaluation, cost
                            apartps.setInt(1, apartcurrid);
                            //set random city
                            apartps.setString(2,
                                    String.valueOf(Cities.values()[rnd.nextInt(Cities.numberofcities)]));
                            apartps.setString(3, "user" + i + "apart" + j);
                            apartps.setString(4, "This is the description of user" + i + "apart" + j);
                            apartps.setString(5, "user" + i);//owner

                            //complex because evaluation is necessarily #.# format
                            avgeval = 4*rnd.nextDouble() +1;
                            apartps.setDouble(6,  Double.parseDouble(
                                    String.format(Locale.ROOT, "%.1f", avgeval)));

                            apartps.setString(7, MyUtils.genRandomDate());

                            apartps.setDouble(8,  Double.parseDouble(
                                    String.format(Locale.ROOT, "%.2f", 30*avgeval*rnd.nextDouble() +10)));

                            apartps.executeUpdate();//--------------APARTMENT INSERT--------------------
                            //insert random services
                            Services[] serv = Services.getServicesSubset(rnd.nextInt(Services.numberofservices) + 1);

                            PreparedStatement servps;

                            for(int servicecursor = 0; servicecursor < serv.length; servicecursor++){

                                    servps = con.prepareStatement(Query.insertApartmentService);
                                    servps.setInt(1, apartcurrid);
                                    servps.setString(2, serv[servicecursor].getUIname());

                                    servps.executeUpdate();//--------------SERVICE APARTMENT INSERT --------------
                            }

                            PreparedStatement imgaptps;
                            int nimgs = rnd.nextInt(2) + 1;
                            for(int imgcursor = 0; imgcursor < nimgs; imgcursor++){
                                if(imgExists("apt" + apartcurrid + "img" + imgcursor)){
                                    imgaptps = con.prepareStatement(Query.insertImage);
                                    imgaptps.setInt(1, apartcurrid);
                                    imgaptps.setString(2, "images/apt_" + apartcurrid + "_img" + imgcursor + ".png");
                                    imgaptps.executeUpdate();
                                }
                            }

                            apartcurrid++;

                        }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //making sure there is no renter announcement satisfying generated tenant announcements
        try {
            PreparedStatement tenantps = con.prepareStatement(Query.selectTenants);
            ResultSet tenRes = tenantps.executeQuery();

            double mincost, maxcost;
            String city;
            Services[] services;

            PreparedStatement searchRAps;
            ResultSet matchedApartServices;
            String[] matchedServices;
            String tempString;

            boolean apartExists;

            while(tenRes.next()){
                for(int tenfilcur = 0; tenfilcur < tenfilnumber; tenfilcur++){
                    //----------------GENERATE POTENTIAL TEN FILTERS-------------------
                    apartExists = false;
                    mincost = 30*rnd.nextDouble() + 20; //mincost 20-50
                    maxcost = mincost + 9*rnd.nextDouble() + 1;
                    city = String.valueOf(Cities.values()[rnd.nextInt(Cities.numberofcities)]);
                    services = Services.getServicesSubset(rnd.nextInt(Services.numberofservices) + 1);

                    searchRAps  = con.prepareStatement(Query.selectRA);
                    searchRAps.setString(1, city);
                    searchRAps.setDouble(2, mincost);
                    searchRAps.setDouble(3, maxcost);

                    matchedApartServices = searchRAps.executeQuery();

                    while(matchedApartServices.next()){
                        tempString = matchedApartServices.getString(4);
                        tempString = tempString.substring(1, tempString.length() - 2);
                        matchedServices = tempString.split(",");

                        if(checkServices(services, matchedServices)) {
                            apartExists = true;
                            break;
                        }
                    }
                    if(!apartExists){
                        //------------------INSERT TA----------------
                        try {
                            PreparedStatement tenantfilps, tenfilservices;
                            tenantfilps = con.prepareStatement(Query.insertTenantFilters);
                            tenantfilps.setInt(1, filtercurrid);
                            tenantfilps.setString(2, tenRes.getString(1));

                            tenantfilps.setString(3, java.lang.String.format(Locale.ROOT, "%.2f", mincost)
                                            + "-" + java.lang.String.format(Locale.ROOT, "%.2f", maxcost));
                            tenantfilps.setString(4, city);
                            tenantfilps.setString(5, MyUtils.genRandomDate());
                            tenantfilps.executeUpdate();

                            for(int cursorservfil = 0; cursorservfil < services.length; cursorservfil++) {
                                tenfilservices = con.prepareStatement(Query.insertTenFilServices);
                                tenfilservices.setInt(1, filtercurrid);
                                tenfilservices.setString(2, String.valueOf(services[cursorservfil]));
                                tenfilservices.executeUpdate();
                            }
                            filtercurrid++;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        DBhelper.getDBInstance().conClose();
    }
    */
