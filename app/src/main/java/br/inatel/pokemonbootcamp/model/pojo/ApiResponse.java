package br.inatel.pokemonbootcamp.model.pojo;

public class ApiResponse<T> {

  private T data;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
