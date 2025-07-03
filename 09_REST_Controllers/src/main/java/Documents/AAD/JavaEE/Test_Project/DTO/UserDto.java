package Documents.AAD.JavaEE.Test_Project.DTO;

public class UserDto {
    private String id;
    private String name;
    private String address;

    public UserDto(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public UserDto() {

    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
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
}
