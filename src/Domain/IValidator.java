package sample.Domain;


import Domain.Entity;

public interface IValidator<T extends Entity> {

    void validate(T entity);

}