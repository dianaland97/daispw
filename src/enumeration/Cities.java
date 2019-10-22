package enumeration;

public enum Cities {
    ROMA, PALERMO, VERONA,
    MILANO, NAPOLI, VENEZIA,
    PARIGI, LONDRA, WASHINGTON,
    SINGAPORE, PECHINO;
    public static final int numberofcities = Cities.values().length;

    public static String[] getAllStrCities(String none) {
        if(none != null) {
            String[] citiesn = new String[numberofcities + 1];
            String temp;

            citiesn[0] = none;

            for (int i = 1; i < numberofcities + 1; i++) {
                temp = Cities.values()[i-1].name();
                temp = temp.charAt(0) + temp.substring(1).toLowerCase();
                citiesn[i] = temp;
            }
            return citiesn;
        }else{
            String[] cities = new String[numberofcities];
            String temp;

            for (int i = 0; i < numberofcities; i++) {
                temp = Cities.values()[i].name();
                temp = temp.charAt(0) + temp.substring(1).toLowerCase();
                cities[i] = temp;
            }
            return cities;
        }

    }


    public String getUIname() {
        String temp = this.name();

        return temp.charAt(0) + temp.substring(1).toLowerCase();
    }
}
