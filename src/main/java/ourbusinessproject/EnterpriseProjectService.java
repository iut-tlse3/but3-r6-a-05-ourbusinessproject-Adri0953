package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public Project newProject(String aTitle, String aDescription) {
        Project project = new Project();
        project.setTitle(aTitle);
        project.setDescription(aDescription);

        entityManager.persist(project);
        entityManager.flush();

        return project;
    }

    public Enterprise newEnterprise(String aName, String aDescription, String aContactName, String aMail) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(aName);
        enterprise.setDescription(aDescription);
        enterprise.setContactName(aContactName);
        enterprise.setContactEmail(aMail);

        entityManager.persist(enterprise);
        entityManager.flush();

        return enterprise;
    }

    public Project findProjectById(Long id) {
        return entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id) {
        return entityManager.find(Enterprise.class, id);
    }
}
