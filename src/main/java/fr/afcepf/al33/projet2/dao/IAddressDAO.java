package fr.afcepf.al33.projet2.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al33.projet2.entity.Address;

public interface IAddressDAO  extends CrudRepository<Address, Long> {

}
