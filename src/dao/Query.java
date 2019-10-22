package dao;

class Query {

    //insert queries
    static final String insertUser = "INSERT INTO RegUser VALUES (?, ?, ?, ?, ?, ?, ?);";
    static final String insertService = "INSERT INTO Service VALUES (?);";
    static final String insertApartment = "INSERT INTO Apartment VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    static final String insertApartmentService = "INSERT INTO AptService VALUES (?, ?);";
    static final String insertRoom = "INSERT INTO Room VALUES(DEFAULT, ?, ?, ?)";
    static final String insertTenantFilters = "INSERT INTO TenantFilter VALUES (?, ?, ?, ?, ?)";
    static final String insertTenFilServices = "INSERT INTO TenFilServices VALUES (?, ?)";
    static final String insertImage = "INSERT INTO AptImage VALUES (?, ?);";

    
    //select query
    static final String checkForUsername = "SELECT * FROM reguser where nickname = ? AND password = ? ;";
    static final String selectApt = "SELECT * from apartment, reguser where nickname = ? and apartment.ownernick=reguser.nickname and id = ?;";
    static final String selectRoomOfApt = "SELECT * from room, reguser where nickname = ? and idapartament = ? ";
    static final String selectServiceApt = "SELECT * from aptservice where idapt = ?";
    static final String selectImageApt = "SELECT * from aptimage where idapt = ?";
    static final String selectUser = "SELECT * from reguser where nickname = ?";
    static final String selectTenants = "SELECT * FROM RegUser WHERE role='tenant'";
    static final String selectRA = "SELECT Apartment.id, Apartment.city, Apartment.cost, ARRAY_AGG(ApartmentService.nameservice) " +
            "FROM Apartment INNER JOIN ApartmentService ON Apartment.id = ApartmentService.idapartment " +
            "WHERE Apartment.city = ? AND Apartment.cost >= ? AND Apartment.cost <= ? " +
            "GROUP BY Apartment.id;";
    static final String searchforuser = "SELECT * FROM RegUser WHERE nickname = ?";
    static final String searchRenterAnnList = "SELECT * FROM apartment ORDER BY id LIMIT ? OFFSET ?;";
    static final String searchAnnouncementDetail = "SELECT id, city, name, description, owner, creationdate, array_agg(nameservice) " +
            "FROM apartment INNER JOIN apartmentservice ON apartment.id = apartmentservice.idapartment RIGHT OUTER JOIN AptImage ON apartment.id = AptImage.idapartment" +
            "WHERE apartment.id = ?" +
            "GROUP BY apartment.id" +
            "ORDER BY apartment.id;";

    static final String searchAptServices = "SELECT id, array_agg(nameservice) " +
            "FROM apartment INNER JOIN apartmentservice ON apartment.id = apartmentservice.idapartment " +
            "WHERE apartment.id = ?" +
            "GROUP BY apartment.id;";

    static final String searchForAptImages = "SELECT id, imagepath " +
            "FROM Apartment INNER JOIN AptImage ON apartment.id = AptImage.idapartment " +
            "WHERE apartment.id = ?";

    static final String searchTenantAnnouncements = "SELECT id, owner, costrange, city, creationdate, array_agg(service) " +
            "FROM tenantfilters INNER JOIN tenfilservices ON tenantfilters.id = tenfilservices.idTF " +
            "GROUP BY tenantfilters.id " +
            "ORDER BY tenantfilters.id " +
            "LIMIT ? OFFSET ?;";

    static final String searchDateById = "SELECT creationDate " +
            "FROM Apartment " +
            "WHERE Apartment.id = ?;";

    static final String getusrnumber = "SELECT Count(nickname) FROM RegUser";
}