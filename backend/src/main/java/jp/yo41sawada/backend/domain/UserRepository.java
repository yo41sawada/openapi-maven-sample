package jp.yo41sawada.backend.domain;

import org.springframework.data.repository.CrudRepository;

import jp.yo41sawada.backend.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}