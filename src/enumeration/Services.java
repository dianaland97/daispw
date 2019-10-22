package enumeration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Services{
    WIFI, TV, MINIBAR, KITCHEN, ROOMCLEANING,
            PARKINGAREA, WASHINGMACHINE, CONDITIONER;

    public static final int numberofservices = Services.values().length;

    public static Services[] getServicesSubset(int n) {
        ArrayList<Services> subset = new ArrayList<>();
        Services[] result = new Services[n];
        int currsubdim, k = 0, randindex;
        Random rnd = new Random();

        for (int i = 0; i < numberofservices; i++) {
            subset.add(Services.values()[i]);
        }
        currsubdim = numberofservices;

        while (n != 0) {
            randindex = rnd.nextInt(currsubdim);
            result[k] = subset.get(randindex);
            subset.remove(randindex);

            currsubdim--;
            n--;
            k++;
        }

        return result;
    }

    public static String[] getAllStrServices() {
        String[] res = new String[numberofservices];
        String temp;

        for(int i = 0; i < numberofservices; i++){
            temp = Services.values()[i].name();
            temp = temp.charAt(0) + temp.substring(1).toLowerCase();
            res[i] = temp;
        }

        return res;
    }


    public static String[] servicesToStrings(Services[] services) {
        String[] res = new String[services.length];

        for(int i = 0; i < services.length; i++){
            res[i] = services[i].getUIname();
        }
        return res;
    }

    public static Services[] getComplementarySubset(List<Services> remServices) {
            int complementarySize = numberofservices - remServices.size();
            List<Services> lcs = servicesList(Services.values());
            String tempserv;

            for(int i = 0; i < remServices.size(); i++){
                tempserv = String.valueOf(remServices.get(i)).toUpperCase();
                for(int j = 0; j < lcs.size(); j++){
                    if(tempserv.equals(lcs.get(j))){
                        lcs.remove(j);
                        break;
                    }
                }
            }
            return listToArrayServices(lcs);
    }


    public static String[] getComplementarySubsetFromStrings(List<String> remServices) {
        List<Services> rs = stringsToServicesList(remServices);
        Services[] arrs = getComplementarySubset(rs);
        return servicesToStrings(arrs);
    }

    private static List<Services> stringsToServicesList(List<String> remServices) {
        List<Services> lser = new ArrayList<>();

        for(int i = 0; i < remServices.size(); i++){
            lser.add(Services.valueOf(remServices.get(i).toUpperCase()));
        }
        return lser;
    }

    private static Services[] listToArrayServices(List<Services> lcs) {
        Services[] res = new Services[lcs.size()];

        for(int i = 0; i < lcs.size(); i++){
            res[i] = lcs.get(i);
        }
        return res;
    }

    private static List<Services> servicesList(Services[] values) {
            List<Services> lcs = new ArrayList<>();

            for(int i = 0; i < values.length; i++){
            lcs.add(values[i]);
            }
            return lcs;
            }

    public static List<String> servicesArrayToStringsList(Services[] apartmentServices) {
        List<String> ls = new ArrayList<>();

        for(int i = 0; i < apartmentServices.length; i++){
            ls.add(apartmentServices[i].getUIname());
        }

        return ls;
    }


    public String getUIname() {
            String temp = String.valueOf(this);
            return temp.charAt(0) + temp.substring(1).toLowerCase();
            }

    public static Services[] stringsToServicesArray(String[] services) {
        Services[] s = new Services[services.length];

        for(int i = 0; i < services.length; i++){
            s[i] = Services.valueOf(services[i].toUpperCase());
        }
        return s;
    }
}

