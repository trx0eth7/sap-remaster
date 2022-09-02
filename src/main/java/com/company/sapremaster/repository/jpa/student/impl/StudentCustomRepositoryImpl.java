package com.company.sapremaster.repository.jpa.student.impl;

import com.company.sapremaster.entity.Student;
import com.company.sapremaster.repository.jpa.student.StudentCustomRepository;
import io.jmix.core.UnconstrainedDataManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;

@Repository
public class StudentCustomRepositoryImpl implements StudentCustomRepository {
    private final UnconstrainedDataManager dataManager;
    private final TransactionTemplate transactionTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public StudentCustomRepositoryImpl(UnconstrainedDataManager dataManager,
                                       PlatformTransactionManager transactionManager) {
        this.dataManager = dataManager;
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Override
    public void deleteInactive() {
        transactionTemplate.executeWithoutResult(status -> {
            var students = dataManager.load(Student.class)
                    .all().list().stream()
                    .filter(student -> FALSE.equals(student.getActive()))
                    .collect(Collectors.toList());

            dataManager.remove(students);
        });
    }

    @Transactional
    @Override
    public void deleteInactive2() {
        entityManager.createNativeQuery("delete from SAP_STUDENT " +
                        "where active = false or active is null")
                .executeUpdate();
    }
}
