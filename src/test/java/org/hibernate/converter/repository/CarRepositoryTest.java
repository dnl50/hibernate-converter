package org.hibernate.converter.repository;

import org.hibernate.converter.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("classpath:data/cars.sql")
class CarRepositoryTest {

    private final CarRepository carRepository;

    @Autowired
    CarRepositoryTest(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Test
    void canQueryPositiveSerialUsingCriteriaApi() {
        // given / when
        List<Car> allCars = carRepository.findAll((Specification<Car>) (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("serial"), BigInteger.valueOf(10L))
        );

        // then
        assertThat(allCars).extracting(Car::getId).containsExactly(1L);
    }

    @Test
    void canQueryNegativeSerialUsingCriteriaApi() {
        // given / when
        List<Car> allCars = carRepository.findAll((Specification<Car>) (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("serial"), BigInteger.valueOf(-11L))
        );

        // then
        assertThat(allCars).extracting(Car::getId).containsExactly(2L);
    }

}