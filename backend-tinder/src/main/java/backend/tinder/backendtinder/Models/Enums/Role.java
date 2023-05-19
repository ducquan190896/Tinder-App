package backend.tinder.backendtinder.Models.Enums;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
