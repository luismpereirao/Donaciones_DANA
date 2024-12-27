package Entities;

public class User {
    private String email;
    private String password;
    private int dineroDonado;
    private Producto prod;

    public User() {
        this.email = "";
        this.password = "";
        this.dineroDonado = 0;
        this.prod = new Producto();
    }

    public User(String email, String password, int dineroDonado, Producto prod) {
        this.email = email;
        this.password = password;
        this.dineroDonado = dineroDonado;
        this.prod = prod;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDineroDonado() {
        return this.dineroDonado;
    }

    public void setDineroDonado(int dineroDonado) {
        this.dineroDonado = dineroDonado;
    }

    public Producto getProd() {
        return this.prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                ", dineroDonado='" + getDineroDonado() + "'" +
                ", prod='" + getProd() + "'" +
                "}";
    }

}
