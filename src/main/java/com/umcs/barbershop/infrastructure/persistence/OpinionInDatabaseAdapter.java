package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.model.Opinion;
import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.port.driving.OpinionRepositoryPort;
import com.umcs.barbershop.infrastructure.persistence.entity.OpinionEntity;
import com.umcs.barbershop.infrastructure.persistence.entity.UserEntity;
import com.umcs.barbershop.infrastructure.persistence.repository.OpinionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class OpinionInDatabaseAdapter implements OpinionRepositoryPort {

    private final OpinionRepository opinionRepository;

    public OpinionInDatabaseAdapter(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    @Override
    public List<Opinion> findAll() {
        return opinionRepository.findAll().stream()
                .map(opinionEntity -> new Opinion(
                        opinionEntity.getId(),
                        customerEntityToUser(opinionEntity.getCustomerEntity()),
                        opinionEntity.getAssessment(),
                        opinionEntity.getComment()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Opinion addOpinion(Opinion opinion) {
        OpinionEntity result = opinionRepository.save(new OpinionEntity(
                opinion.getId(),
                customerToEntityUser(opinion.getCustomer()),
                opinion.getComment(),
                opinion.getAssessment()
        ));
        return new Opinion(
                result.getId(),
                customerEntityToUser(result.getCustomerEntity()),
                result.getAssessment(),
                result.getComment()
        );
    }

    @Override
    public Opinion getOpinionById(UUID id) {
        Optional<OpinionEntity> result = opinionRepository.findById(id);

        if (result.isEmpty()) {
            return null;
        }

        return new Opinion(
                result.get().getId(),
                customerEntityToUser(result.get().getCustomerEntity()),
                result.get().getAssessment(),
                result.get().getComment()
        );
    }
    @Override
    public Opinion deleteOpinionById(UUID id) {
        OpinionEntity opinionToDelete = opinionRepository.findById(id).get();
        opinionRepository.deleteById(id);
        return new Opinion(
                opinionToDelete.getId(),
                customerEntityToUser(opinionToDelete.getCustomerEntity()),
                opinionToDelete.getAssessment(),
                opinionToDelete.getComment()
        );
    }

    private UserEntity customerToEntityUser(User customer) {
        return new UserEntity(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getRole()
        );
    }

    private User customerEntityToUser(UserEntity customerEntity) {
        return new User(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getPhoneNumber(),
                customerEntity.getEmail(),
                customerEntity.getRole()
        );
    }
}
