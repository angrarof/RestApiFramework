package resources;
//Collection of constants and methods

public enum ApiResources {
    addPlace("/maps/api/place/add/json")
    ,getPlace("/maps/api/place/get/json")
    ,deletePlace("/maps/api/place/delete/json");

    private String resource;

    ApiResources(String resource) {
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
