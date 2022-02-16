package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    public AddPlace addPlacePayload(String name, String address){
        AddPlace place = new AddPlace();
        place.setAccuracy(50);
        place.setAddress(address);
        place.setLanguage("Spanish");
        place.setPhone_number("(+91) 983 893 6664");
        place.setWebsite("facebook.com");
        place.setName(name);
        List<String> types = new ArrayList<>();
        types.add("house");
        types.add("park");
        types.add("store");
        place.setTypes(types);
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        place.setLocation(location);
        return place;
    }

    public String deletePlacePayload(String place_id){
        return "{\n" +
                "\"place_id\":\""+place_id+"\"\n" +
                "}";
    }
}
