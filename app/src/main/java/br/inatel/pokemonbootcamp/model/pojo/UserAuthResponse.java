package br.inatel.pokemonbootcamp.model.pojo;

public class UserAuthResponse {

  private String name;
  private String username;
  private String email;
  private String token;
  private String rtoken;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getRtoken() {
    return rtoken;
  }

  public void setRtoken(String rtoken) {
    this.rtoken = rtoken;
  }

  @Override
  public String toString() {
    return "UserAuthResponse{" +
        "name='" + name + '\'' +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", token='" + token + '\'' +
        ", rtoken='" + rtoken + '\'' +
        '}';
  }
}
