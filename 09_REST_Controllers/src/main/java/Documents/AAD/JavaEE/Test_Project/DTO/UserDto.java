package Documents.AAD.JavaEE.Test_Project.DTO;

public class UserDto {
    private String id;
    private String name;
    private String address;
    private CityDto cityDto;

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cityDto=" + cityDto +
                '}';
    }

    public UserDto(String id, String address, String name, CityDto cityDto) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.cityDto = cityDto;
    }

    public UserDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }
}
